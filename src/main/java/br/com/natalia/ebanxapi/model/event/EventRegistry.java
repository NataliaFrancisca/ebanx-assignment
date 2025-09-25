package br.com.natalia.ebanxapi.model.event;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record EventRegistry(
        @NotNull(message = "type must be provided")
        EventType type,
        @NotNull(message = "amount must be provided")
        @PositiveOrZero(message = "amount must be a positive number.")
        Double amount,
        String origin,
        String destination
) {
}
