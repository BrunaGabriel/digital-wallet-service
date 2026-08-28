package org.brunagabriel.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.brunagabriel.dto.WalletRequest;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "wallets")
public class WalletEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true) // não pode ser  null
    private String email;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    @CreationTimestamp //vai preencher automaticamente com a data de criação
    private LocalDateTime createdAt;

    //é um mapper - mapeia o dto para a nossa classe
    //static - podemos usar sem instanciar a classe
//    public static WalletEntity toWallet(WalletRequest request){
//        WalletEntity wallet = new WalletEntity();
//        wallet.setEmail(request.email());
//        wallet.setBalance(request.amount());
//        return wallet;
//    }


    public WalletEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
