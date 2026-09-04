package org.brunagabriel.controller;

import java.net.URI;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import org.brunagabriel.dto.WalletRequest;
import org.brunagabriel.dto.CreateWalletResponse;
import org.brunagabriel.dto.WalletResponse;
import org.brunagabriel.service.WalletService;

@ApplicationScoped
@Path("/wallets")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService walletService){
        this.service = walletService;
    }

    @POST
    public Response createWallet(@Valid WalletRequest request){
        CreateWalletResponse created =service.save(request);
        return Response.created(URI.create("/wallets/"+created.id())).entity(created).build();
    }

    @GET
    public List<WalletResponse> searchWallet(){
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
