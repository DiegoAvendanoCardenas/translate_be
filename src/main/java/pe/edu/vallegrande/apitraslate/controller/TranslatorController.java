package pe.edu.vallegrande.apitraslate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.apitraslate.model.Translation;
import pe.edu.vallegrande.apitraslate.repository.TranslationRepository;
import pe.edu.vallegrande.apitraslate.service.TranslatorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class TranslatorController {

    private final TranslatorService translatorService;
    private final TranslationRepository translationRepository;

    @Autowired
    public TranslatorController(TranslatorService translatorService, TranslationRepository translationRepository) {
        this.translatorService = translatorService;
        this.translationRepository = translationRepository;
    }

    @PostMapping("/translate")
    public Mono<ResponseEntity<String>> translateText(@RequestBody Translation requestBody) {
        String text = requestBody.getOriginalText();
        String from = requestBody.getFromLanguage();
        String to = requestBody.getToLanguage();
        return translatorService.translateText(text, from, to)
                .flatMap(translatedText -> {
                    requestBody.setTranslatedText(translatedText);
                    return translationRepository.save(requestBody)
                            .map(savedTranslation -> ResponseEntity.status(HttpStatus.OK)
                                    .body("Translation saved successfully"));
                })
                .onErrorResume(error -> {
                    log.error("Error translating text: {}", error.getMessage());
                    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Error translating text"));
                });
    }

    @GetMapping("/translations/{id}")
    public Mono<ResponseEntity<Translation>> getTranslationById(@PathVariable Long id) {
        return translationRepository.findById(id)
                .map(translation -> ResponseEntity.status(HttpStatus.OK).body(translation))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/translations")
    public Flux<Translation> getAllTranslations() {
        return translationRepository.findAll();
    }

    @PutMapping("/translations/{id}")
    public Mono<ResponseEntity<Translation>> updateTranslation(@PathVariable Long id, @RequestBody Translation updatedTranslation) {
        String text = updatedTranslation.getOriginalText();
        String from = updatedTranslation.getFromLanguage();
        String to = updatedTranslation.getToLanguage();
        return translationRepository.findById(id)
                .flatMap(existingTranslation -> translatorService.translateText(text, from, to)
                        .flatMap(translatedText -> {
                            existingTranslation.setOriginalText(text);
                            existingTranslation.setTranslatedText(translatedText);
                            existingTranslation.setFromLanguage(from);
                            existingTranslation.setToLanguage(to);
                            return translationRepository.save(existingTranslation);
                        }))
                .map(savedTranslation -> ResponseEntity.status(HttpStatus.OK).body(savedTranslation))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/translations/{id}")
    public Mono<ResponseEntity<Void>> deleteTranslation(@PathVariable Long id) {
        return translationRepository.findById(id)
                .flatMap(existingTranslation ->
                        translationRepository.delete(existingTranslation)
                                .then(Mono.just(ResponseEntity.status(HttpStatus.NO_CONTENT).<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
