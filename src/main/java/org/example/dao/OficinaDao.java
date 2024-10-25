package org.example.dao;

import org.example.models.oficina.Oficina;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OficinaDao {
    void create(Oficina o1, Connection connection) throws SQLException;

    List<Oficina> readByCnpj(String cnpj) throws SQLException;

    void update(Oficina o1, Connection connection) throws SQLException;

    void delete(String cnpj, String cpf, Connection connection) throws SQLException;
}
