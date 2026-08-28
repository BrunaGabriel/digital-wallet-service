package org.brunagabriel.controller;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.brunagabriel.dto.WalletRequest;
import org.brunagabriel.dto.WalletResponse;
import org.brunagabriel.entity.WalletEntity;
import org.brunagabriel.service.WalletService;

@ApplicationScoped
@Path("/wallets")
public class WalletController {
    @Inject
    private WalletService service;

    @POST
    public WalletResponse createWallet(@Valid WalletRequest request){ //força as validaçoes do NotNull e posityive
        return service.save(request);
    }

    @GET
    public List<WalletEntity> searchWallet(){
        return service.searchWallet();
    }

    @GET
    @Path("/{id}")
    public WalletResponse getWalletById(@PathParam("id") Long id){
        return service.searchById(id);
    }

    @PUT
    @Path("/{id}")
    public WalletResponse updateWallet(@PathParam("id") Long id, @Valid WalletRequest request){
        return service.update(id,request);
    }

    @DELETE
    @Path("/{id}")
    public void deleteWallet(@PathParam("id") Long id){
        service.delete(id);
    }
}
