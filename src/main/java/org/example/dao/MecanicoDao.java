package org.example.dao;

import org.example.models.assegurado.Pessoa;
import org.example.models.oficina.Mecanico;

import java.sql.SQLException;
import java.util.List;

public interface MecanicoDao {
    void create(Mecanico m1) throws SQLException;

    List<Pessoa> readAll() throws SQLException;

    void update(Mecanico m1) throws SQLException;

    void delete( Long cpf) throws SQLException;
}
