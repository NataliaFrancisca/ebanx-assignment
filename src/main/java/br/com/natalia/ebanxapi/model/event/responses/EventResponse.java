package br.com.natalia.ebanxapi.model.event.responses;

public sealed interface EventResponse permits DepositResponse, WithdrawResponse, TransferResponse {
}
