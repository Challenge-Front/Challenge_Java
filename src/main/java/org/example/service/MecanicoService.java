package org.example.service;

import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Pessoa;
import org.example.models.oficina.Mecanico;

import java.sql.SQLException;
import java.util.List;

public interface MecanicoService {
    Mecanico create(Mecanico m1) throws UnsupportedServiceOperationException, SQLException, NotSavedException;

    List<Mecanico> readByCpf(String cpf) throws SQLException;

    Pessoa update(Mecanico m1) throws NotFoundException, SQLException;

    void delete(String cpf) throws NotFoundException, SQLException;
}
