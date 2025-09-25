package br.com.natalia.ebanxapi.model.event;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record EventRegistry(
        @NotNull(message = "must be filled.")
        EventType type,
        @NotNull(message = "must be filled.")
        @PositiveOrZero(message = "must be a positive number.")
        Double amount,
        String origin,
        String destination
) {
}
