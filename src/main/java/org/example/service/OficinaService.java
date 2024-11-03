package org.example.service;

import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.oficina.Oficina;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OficinaService {
    Oficina create(Oficina o1) throws UnsupportedServiceOperationException, SQLException, NotSavedException;

    List<Oficina> readByCnpj(String cnpj) throws SQLException;

    Oficina update(Oficina o1)  throws NotFoundException, SQLException;

    void delete(String cnpj) throws NotFoundException, SQLException ;
}
