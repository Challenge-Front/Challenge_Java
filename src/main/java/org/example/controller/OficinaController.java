package org.example.controller;

import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Pessoa;
import org.example.models.oficina.Oficina;
import org.example.service.OficinaService;
import org.example.service.OficinaServiceFactory;
import org.example.service.PessoaService;
import org.example.service.PessoaServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/rest/oficina")
public class OficinaController    {
    private final OficinaService oficinaService = OficinaServiceFactory.create();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Oficina input) throws UnsupportedServiceOperationException {
        if (input.getCnpj() != null) {
            try {
                Oficina o1 = this.oficinaService.create(new Oficina( input.getEndereco(),input.getNome(), input.getCnpj()));
                return Response
                        .status(Response.Status.CREATED)
                        .entity(o1)
                        .build();
            } catch (SQLException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(Map.of("mensagem", "erro inesperado ao tentar inserir pessoa"))
                        .build();
            } catch (NotSavedException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(Map.of("mensagem", "não foi possível salvar a pessoa"))
                        .build();
            } catch (UnsupportedServiceOperationException e) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(Map.of("mensagem", "operação não suportada"))
                        .build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("mensagem", "esse método só permite a criação de novas pessoas"))
                    .build();
        }
    }

    @GET
    @Path("/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@PathParam("cnpj") String cnpj) throws SQLException {
        return Response.status(Response.Status.OK)
                .entity(this.oficinaService.readByCnpj(cnpj)).build();
    }

    @PUT
    @Path("/alter/{cnpj}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("cnpj") String cnpj, Oficina input){
        try {
            Oficina updated = this.oficinaService.update(new Oficina( input.getEndereco(),input.getNome(), cnpj));
            return Response.status(Response.Status.OK).entity(updated).build();
        } catch (org.example.exception.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar atualizar oficina")).build();
        }
    }

    @DELETE
    @Path("/delete/{cnpj}")
    public Response delete(@PathParam("cnpj")String cnpj){
        try {
            this.oficinaService.delete(cnpj);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar deletar oficina")).build();
        }
    }
}
