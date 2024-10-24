package org.example.dao;

import org.example.models.oficina.Oficina;

import java.sql.SQLException;
import java.util.List;

public interface OficinaDao {
    void create(Oficina o1) throws SQLException;

    List<Oficina> readAll() throws SQLException;

    void update(Oficina o1) throws SQLException;

    void delete(String cnpj, String cpf) throws SQLException;
}
