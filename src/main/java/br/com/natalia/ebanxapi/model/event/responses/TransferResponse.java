package br.com.natalia.ebanxapi.model.event.responses;

import br.com.natalia.ebanxapi.model.account.Account;

public record TransferResponse(
        Account origin,
        Account destination
) implements EventResponse {
}
