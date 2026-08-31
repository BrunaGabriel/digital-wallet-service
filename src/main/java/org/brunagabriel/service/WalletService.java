package org.brunagabriel.service;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.brunagabriel.dto.WalletRequest;
import org.brunagabriel.dto.CreateWalletResponse;
import org.brunagabriel.dto.WalletResponse;
import org.brunagabriel.entity.WalletEntity;
import org.brunagabriel.repository.WalletRepository;

@ApplicationScoped //deixa a classe pronta para que seja usada facilmente - cria a classe uma unica vez -singleton
public class WalletService {

    @Inject
    private WalletRepository repository;

//    @Transactional //este metodo tem de rodar dentro de uma transação
//    public WalletResponse save (WalletRequest request){
//
//        WalletEntity wallet= WalletEntity.toWallet(request);
//        repository.persist(wallet);
//        return WalletResponse.fromWallet(wallet);
//    }

    @Transactional
    public CreateWalletResponse save (WalletRequest request){
        WalletEntity wallet=new WalletEntity();
        wallet.setEmail(request.email());
        wallet.setBalance(request.amount());
        wallet.setCreatedAt(LocalDateTime.now());
        repository.persist(wallet);
        return CreateWalletResponse.fromWallet(wallet);
    }

    @Transactional
    public WalletResponse searchById(Long id) {
        WalletEntity wallet = repository.findById(id);
        return WalletResponse.fromWallet(wallet);
    }

    @Transactional
    public List<WalletResponse> searchWallet() {
        List<WalletEntity> wallets = repository.listAll();
        return wallets.stream()
                .map(WalletResponse::fromWallet)
                .toList();
    }

    @Transactional
    public WalletResponse update(Long id, WalletRequest request) {
        WalletEntity wallet = repository.findById(id);
        wallet.setEmail(request.email());
        return WalletResponse.fromWallet(wallet);
    }

    @Transactional
    public void delete(Long id) {
        WalletEntity wallet = repository.findById(id);
        repository.delete(wallet);
    }
}
