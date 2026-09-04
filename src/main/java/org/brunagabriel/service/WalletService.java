package org.brunagabriel.service;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import org.brunagabriel.dto.WalletRequest;
import org.brunagabriel.dto.CreateWalletResponse;
import org.brunagabriel.dto.WalletResponse;
import org.brunagabriel.entity.WalletEntity;
import org.brunagabriel.repository.WalletRepository;

@ApplicationScoped
public class WalletService {

    private final WalletRepository repository;

    public WalletService(WalletRepository repository){
        this.repository = repository;
    }

    @Transactional
    public CreateWalletResponse save (WalletRequest request){
        if (repository.findByEmail(request.email())){
            throw new WebApplicationException("Email already exists", Response.Status.CONFLICT);
        }
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

        if(wallet==null){
            throw new NotFoundException("Wallet not found");
        }
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

        if (wallet==null){
            throw new NotFoundException("Wallet not found");
        }
        wallet.setEmail(request.email());
        return WalletResponse.fromWallet(wallet);
    }

    @Transactional
    public void delete(Long id) {
        WalletEntity wallet = repository.findById(id);
        if (wallet==null){
            throw new NotFoundException("Wallet not found");
        }
        repository.delete(wallet);
    }
}
