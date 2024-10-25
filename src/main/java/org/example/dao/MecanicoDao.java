package org.example.dao;

import org.example.models.assegurado.Pessoa;
import org.example.models.oficina.Mecanico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface MecanicoDao {
    void create(Mecanico m1, Connection connection) throws SQLException;

    List<Pessoa> readByCpf(String cpf) throws SQLException;

    void update(Mecanico m1, Connection connection) throws SQLException;

    void delete( Long cpf, Connection connection) throws SQLException;
}
