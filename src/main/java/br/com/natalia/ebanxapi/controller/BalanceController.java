package br.com.natalia.ebanxapi.controller;

import br.com.natalia.ebanxapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<Double> getBalance(@RequestParam("account_id") String account_id ){
        var balance = this.accountService.getBalance(account_id);
        return ResponseEntity.ok(balance);
    }
}
