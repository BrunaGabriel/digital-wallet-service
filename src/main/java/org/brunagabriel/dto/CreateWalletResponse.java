package org.brunagabriel.dto;

import java.time.LocalDateTime;

import org.brunagabriel.entity.WalletEntity;

public record CreateWalletResponse(
        Long id,
        LocalDateTime createdAt
){
    public static CreateWalletResponse fromWallet(WalletEntity wallet){
        return new CreateWalletResponse(
            wallet.getId(),
            wallet.getCreatedAt()
        );
    }
}
