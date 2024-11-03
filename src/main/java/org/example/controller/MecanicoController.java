package org.example.controller;

import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.oficina.Mecanico;
import org.example.service.MecanicoService;
import org.example.service.MecanicoServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/rest/mecanico")
public class MecanicoController     {
    private final MecanicoService mecanicoService = MecanicoServiceFactory.get();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Mecanico input) throws UnsupportedServiceOperationException {
        if (input.getCpf() != null) {
            try {
                Mecanico m1 = this.mecanicoService.create(new Mecanico(input.getNome(), input.getDtNascimento(), input.getSenha(), input.getEmail(), input.getTelefone(), input.getCpf(), input.getCnpjOficina()));
                return Response
                        .status(Response.Status.CREATED)
                        .entity(m1)
                        .build();
            } catch (SQLException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(Map.of("mensagem", "erro inesperado ao tentar inserir mecanico"))
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
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@PathParam("cpf") String cpf) throws SQLException {
        return Response.status(Response.Status.OK)
                .entity(this.mecanicoService.readByCpf(cpf)).build();
    }

    @PUT
    @Path("/alter/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("cpf") String cpf, Mecanico input){
        try {
            Mecanico updated = (Mecanico) this.mecanicoService.update(new Mecanico(input.getNome(), input.getDtNascimento(), input.getSenha(), input.getEmail(), input.getTelefone(), cpf, input.getCnpjOficina()));
            return Response.status(Response.Status.OK).entity(updated).build();
        } catch (org.example.exception.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar atualizar pessoa")).build();
        }
    }

    @DELETE
    @Path("/delete/{cpf}")
    public Response delete(@PathParam("cpf")String cpf){
        try {
            this.mecanicoService.delete(cpf);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar deletar pessoa")).build();
        }
    }
}
