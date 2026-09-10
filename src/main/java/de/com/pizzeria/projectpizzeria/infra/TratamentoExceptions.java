package de.com.pizzeria.projectpizzeria.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratar404(EntityNotFoundException exception){ // pode tirar tb que funciona
        //return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teste");
    }

}
