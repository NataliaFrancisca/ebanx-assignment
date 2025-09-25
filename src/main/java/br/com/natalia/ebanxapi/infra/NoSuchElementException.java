package br.com.natalia.ebanxapi.infra;

public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException(String message){
        super(message);
    }

}
