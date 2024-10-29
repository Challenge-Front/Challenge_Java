package org.example.dao;

import org.example.models.assegurado.Carro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CarroDao {
    Carro create(Carro c1, Connection connection) throws SQLException;

    List<Carro> readAllById(String cpfDono);

    Carro update(Carro c1,Connection connection) throws SQLException;

    void delete(String placa,Connection connection);
}
