package org.brunagabriel.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

import org.brunagabriel.entity.WalletEntity;

@ApplicationScoped
public class WalletRepository implements PanacheRepository<WalletEntity> {

    public boolean findByEmail(String email) {
        return count("email", email)>0;
    }
    //Panache é como um pacote de funcionalidades
}
