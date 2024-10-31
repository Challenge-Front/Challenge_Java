package org.example.controller;

import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Pessoa;
import org.example.service.PessoaService;
import org.example.service.PessoaServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/rest/cliente")
public class PessoaController {
    private final PessoaService pessoaService = PessoaServiceFactory.create();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Pessoa input) throws UnsupportedServiceOperationException {
        if (input.getCpf() != null) {
            if (input.getCpf() != null) {  // Condição corrigida
                try {
                    Pessoa pessoa = this.pessoaService.create(new Pessoa(input.getNome(), input.getDtNascimento(), input.getSenha(), input.getEmail(), input.getTelefone(), input.getCpf()));
                    return Response
                            .status(Response.Status.CREATED)
                            .entity(pessoa)
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

        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(
                            Map.of(
                                    "mensagem",
                                    "esse método só permite a criação de novas pessoas"))
                    .build();
        }
    }

    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@PathParam("cpf") String cpf) {
        return Response.status(Response.Status.OK)
                .entity(this.pessoaService.readByCpf(cpf)).build();
    }

    @PUT
    @Path("/alter/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("cpf") String cpf, Pessoa input){
        try {
            Pessoa updated = this.pessoaService.update(new Pessoa(input.getNome(), input.getDtNascimento(), input.getSenha(), input.getEmail(), input.getTelefone(), cpf));
            return Response.status(Response.Status.OK).entity(updated).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar atualizar pessoa")).build();
        }
    }

    @DELETE
    @Path("/delete/{cpf}")
    public Response delete(@PathParam("cpf")String cpf, String placa){
        try {
            this.pessoaService.delete(cpf, placa);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar deletar pessoa")).build();
        }
    }
}
