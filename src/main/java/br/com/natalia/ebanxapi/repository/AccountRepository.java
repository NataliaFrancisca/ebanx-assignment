package br.com.natalia.ebanxapi.repository;

import br.com.natalia.ebanxapi.infra.NoSuchElementException;
import br.com.natalia.ebanxapi.model.account.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AccountRepository {
    private final HashMap<String, Account> accounts = new HashMap<>();

    public Optional<Account> findById(String id){
        return Optional.ofNullable(accounts.get(id));
    }

    public Account getById(String id){
        var account = Optional.ofNullable(accounts.get(id));

        if (account.isEmpty()){
            throw new NoSuchElementException("0");
        }

        return account.get();
    }

    public void save(Account account){
        this.accounts.put(account.getId(), account);
    }

    public void reset(){
        this.accounts.clear();
    }
}
