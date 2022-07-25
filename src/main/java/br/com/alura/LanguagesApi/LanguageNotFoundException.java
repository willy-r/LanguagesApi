package br.com.alura.LanguagesApi;

class LanguageNotFoundException extends RuntimeException {

    LanguageNotFoundException(String id) {
      super("Could not find language " + id);
    }
}
