package br.com.natalia.ebanxapi.infra;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message){
        super(message);
    }
}
