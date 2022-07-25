package br.com.alura.LanguagesApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }

    @GetMapping("/languages/{id}")
    public Language getLanguage(@PathVariable String id) {
        return languageRepository.findById(id)
            .orElseThrow(() -> new LanguageNotFoundException(id));
    }

    @PostMapping("/languages")
    @ResponseStatus(HttpStatus.CREATED)
    public Language createLanguage(@RequestBody Language newLanguage) {
        return languageRepository.save(newLanguage);
    }

    @PutMapping("/languages/{id}")
    public Language updateLanguage(@RequestBody Language newLanguage, @PathVariable String id) {
        return languageRepository.findById(id)
            .map(language -> {
                language.setTitle(newLanguage.getTitle());
                language.setImage(newLanguage.getImage());
                language.setRanking(newLanguage.getRanking());
                return languageRepository.save(language);
            })
            .orElseThrow(() -> new LanguageNotFoundException(id));
    }

    @DeleteMapping("/languages/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLanguage(@PathVariable String id) {
        languageRepository.deleteById(id);
    }
}
