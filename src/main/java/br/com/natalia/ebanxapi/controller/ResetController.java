package br.com.natalia.ebanxapi.controller;

import br.com.natalia.ebanxapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reset")
public class ResetController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<String> reset(){
        this.accountService.reset();
        return ResponseEntity.ok().body("OK");
    }
}
