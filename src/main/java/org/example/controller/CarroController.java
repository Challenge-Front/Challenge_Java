package org.example.controller;

import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Carro;
import org.example.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/rest/carro")
public class CarroController {
    private final CarroService carroService = CarroServiceFactory.create();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Carro input) throws UnsupportedServiceOperationException {
        if (input.getPlaca() != null) {
            try {
                Carro carro = this.carroService.create(new Carro( input.getId(), input.getMarca(), input.getModelo(), input.getPlaca(), input.getAno(), input.getCpfDono()));
                return Response
                        .status(Response.Status.CREATED)
                        .entity(carro)
                        .build();
            } catch (SQLException | NotSavedException e){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(Map.of("mensagem","erro inesperado ao tentar inserir veículo")).build();
            }

        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(
                            Map.of(
                                    "mensagem",
                                    "esse método só permite a criação de novos veículos"))
                    .build();
        }
    }

    @GET
    @Path("/todos/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@PathParam("cpf") String cpf) {
        return Response.status(Response.Status.OK)
                .entity(this.carroService.readAllById(cpf)).build();
    }

    @PUT
    @Path("/alter/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Carro input){
        try {
            Carro updated = this.carroService.update(new Carro( id, input.getMarca(), input.getModelo(), input.getPlaca(), input.getAno(), input.getCpfDono()));
            return Response.status(Response.Status.OK).entity(updated).build();
        } catch (org.example.exception.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar atualizar o veículo")).build();
        }
    }

    @DELETE
    @Path("/delete/{placa}")
    public Response delete(@PathParam("placa") String placa){
        try {
            this.carroService.delete(placa);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar deletar pessoa")).build();
        }
    }
}
