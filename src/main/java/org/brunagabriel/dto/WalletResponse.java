package org.brunagabriel.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.brunagabriel.entity.WalletEntity;

public record WalletResponse(
        Long id,
        LocalDateTime createdAt,
        String email,
        BigDecimal balance
){
    public static WalletResponse fromWallet(WalletEntity wallet){
        return new WalletResponse(
            wallet.getId(),
            wallet.getCreatedAt(),
            wallet.getEmail(),
            wallet.getBalance()
        );
    }
}
