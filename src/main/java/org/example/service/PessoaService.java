package org.example.service;

import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Pessoa;

import java.sql.SQLException;
import java.util.List;

public interface PessoaService {
    Pessoa create(Pessoa pessoa) throws UnsupportedServiceOperationException, SQLException, NotSavedException;

    List<Pessoa> readByCpf(String cpf);

    Pessoa update(Pessoa pessoa) throws NotFoundException, SQLException;

    void delete(String cpf, String placa) throws NotFoundException, SQLException;
}
