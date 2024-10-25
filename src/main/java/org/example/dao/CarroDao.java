package org.example.dao;

import org.example.models.assegurado.Carro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CarroDao {
    void create(Carro c1, Connection connection);

    List<Carro> readAllById(String cpfDono);

    void update(Carro c1,Connection connection);

    void delete(String placa,Connection connection);
}
