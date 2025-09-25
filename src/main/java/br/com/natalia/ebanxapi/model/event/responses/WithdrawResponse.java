package br.com.natalia.ebanxapi.model.event.responses;

import br.com.natalia.ebanxapi.model.account.Account;

public record WithdrawResponse(
        Account origin
) implements EventResponse {
}
