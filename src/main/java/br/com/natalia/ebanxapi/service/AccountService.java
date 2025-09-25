package br.com.natalia.ebanxapi.service;
import br.com.natalia.ebanxapi.infra.BadRequestException;
import br.com.natalia.ebanxapi.model.account.Account;
import br.com.natalia.ebanxapi.model.event.responses.DepositResponse;
import br.com.natalia.ebanxapi.model.event.EventRegistry;
import br.com.natalia.ebanxapi.model.event.responses.TransferResponse;
import br.com.natalia.ebanxapi.model.event.responses.WithdrawResponse;
import br.com.natalia.ebanxapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    final private AccountRepository accountsRepository;

    @Autowired
    public AccountService(AccountRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    private void verifyDestinationField(EventRegistry event){
        if (Optional.ofNullable(event.destination()).isEmpty()){
            throw new BadRequestException("destination must be filled.");
        }
    }

    private void verifyOriginField(EventRegistry event){
        if (Optional.ofNullable(event.origin()).isEmpty()){
            throw new BadRequestException("origin must be filled.");
        }
    }

    public DepositResponse registryDeposit(EventRegistry event){
        this.verifyDestinationField(event);

        Optional<Account> account = this.accountsRepository.findById(event.destination());

        if (account.isPresent()){
            account.get().deposit(event.amount());
            return new DepositResponse(account.get());
        }

        Account accountNew = new Account(event);
        this.accountsRepository.save(accountNew);
        return new DepositResponse(accountNew);
    }

    public WithdrawResponse registryWithdraw(EventRegistry event){
        this.verifyOriginField(event);

        Account account = this.accountsRepository.getById(event.origin());

        if (account.getBalance() >= event.amount()){
            account.withdraw(event.amount());
        }

        return new WithdrawResponse(account);
    }

    public TransferResponse registryTransfer(EventRegistry event){
        this.verifyDestinationField(event);
        this.verifyOriginField(event);

        Account origin = this.accountsRepository.getById(event.origin());
        Account destination = this.accountsRepository.getById(event.destination());

        if(origin.getId().equals(destination.getId())){
            throw new BadRequestException("should transfer for another account.");
        }

        if (origin.getBalance() >= event.amount()){
            origin.withdraw(event.amount());
            destination.deposit(event.amount());
        }

        return new TransferResponse(origin, destination);
    }

    public Double getBalance(String accountId){
        Account origin = this.accountsRepository.getById(accountId);
        return origin.getBalance();
    }

    public void reset(){
        this.accountsRepository.reset();
    }
}
