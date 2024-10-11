package org.example.dao;

import org.example.models.assegurado.Carro;

import java.sql.SQLException;
import java.util.List;

public interface CarroDao {
    void create(Carro c1);

    List<Carro> readAll();

    void update(Carro c1);

    void delete(Long id);
}
