package org.example.service;

import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Carro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CarroService {
    Carro create(Carro c1) throws UnsupportedServiceOperationException, SQLException, NotSavedException;

    List<Carro> readAllById(String cpfDono);

    Carro update(Carro c1) throws NotFoundException, SQLException;

    void delete(String placa) throws NotFoundException, SQLException;
}
