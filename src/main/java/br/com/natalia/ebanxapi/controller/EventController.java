package br.com.natalia.ebanxapi.controller;

import br.com.natalia.ebanxapi.model.event.responses.DepositResponse;
import br.com.natalia.ebanxapi.model.event.EventRegistry;
import br.com.natalia.ebanxapi.model.event.responses.EventResponse;
import br.com.natalia.ebanxapi.model.event.EventType;
import br.com.natalia.ebanxapi.model.event.responses.TransferResponse;
import br.com.natalia.ebanxapi.model.event.responses.WithdrawResponse;
import br.com.natalia.ebanxapi.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<EventResponse> event(@Valid @RequestBody EventRegistry event){
        if (event.type().equals(EventType.deposit)){
            DepositResponse response = this.accountService.registryDeposit(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        if (event.type().equals(EventType.withdraw)){
            WithdrawResponse response = this.accountService.registryWithdraw(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        if (event.type().equals(EventType.transfer)){
            TransferResponse response = this.accountService.registryTransfer(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        return ResponseEntity.noContent().build();
    }
}
