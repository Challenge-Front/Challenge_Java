package org.example.dao;

import org.example.assegurado.Carro;

import java.sql.SQLException;
import java.util.List;

public interface CarroDao {
    void create(Carro c1) throws SQLException;

    List<Carro> readAll() throws SQLException;

    void update(Carro c1) throws SQLException;

    void delete(String placa) throws SQLException;
}
