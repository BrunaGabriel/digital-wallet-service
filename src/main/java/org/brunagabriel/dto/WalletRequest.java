package org.brunagabriel.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.brunagabriel.entity.WalletEntity;

public record WalletRequest(
        //a partir do java 17, há o record. um objeto unico e imutavel e já traz getter e setter embutidos. mais rapdo na memoria

        @NotBlank(message = "The email cannot be null")
        String email,
        @Positive(message = "The amount must be positive")
        @NotNull (message = "The amount cannot be null")
        BigDecimal amount
) {

}
