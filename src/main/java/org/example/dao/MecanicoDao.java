package org.example.dao;

import org.example.models.assegurado.Pessoa;
import org.example.models.oficina.Mecanico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface MecanicoDao {
    Mecanico create(Mecanico m1, Connection connection) throws SQLException;

    List<Mecanico> readByCpf(String cpf) throws SQLException;

    Mecanico update(Mecanico m1, Connection connection) throws SQLException;

    void delete( String cpf, Connection connection) throws SQLException;
}
