package br.com.alura.LanguagesApi;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("languages")
    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }

    @GetMapping("languages/{id}")
    public Optional<Language> getLanguage(@PathVariable String id) {
        return languageRepository.findById(id);
    }

    @PostMapping("languages")
    public Language createLanguage(@RequestBody Language newLanguage) {
        return languageRepository.save(newLanguage);
    }
}
