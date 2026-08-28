package org.brunagabriel.dto;

import java.time.LocalDateTime;

import org.brunagabriel.entity.WalletEntity;

public record WalletResponse(
        Long id,
        LocalDateTime createdAt
){
    public static WalletResponse fromWallet(WalletEntity wallet){
        return new WalletResponse(
            wallet.getId(),
            wallet.getCreatedAt()
        );
    }
}
