package br.com.natalia.ebanxapi.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestControllerAdvice
public class ExcepctionResponse {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity error404(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OK");
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity error400(BadRequestException badRequestException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity errorBodyRequest400(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(
                erros.stream()
                        .map(e -> e.getField().concat(" ").concat(Objects.requireNonNull(e.getDefaultMessage())) )
                        .toList()
        );
    }
}
