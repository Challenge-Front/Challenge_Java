package org.example.dao;

import org.example.models.assegurado.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PessoaDao {

    void create(Pessoa p1, Connection connection);

    List<Pessoa> readByCpf(String cpf);

    void update(Pessoa p1, Connection connection);

    void delete( String cpf, String placa, Connection connection);
}
