package br.com.alura.LanguagesApi;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class EmployeeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(LanguageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  Map<String, String> languageNotFoundHandler(LanguageNotFoundException err) {
    return Collections.singletonMap("message", err.getMessage());
  }
}
