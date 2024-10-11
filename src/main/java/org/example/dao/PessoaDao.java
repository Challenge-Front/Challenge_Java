package org.example.dao;

import org.example.models.assegurado.Pessoa;

import java.sql.SQLException;
import java.util.List;

public interface PessoaDao {

    void create(Pessoa p1) throws SQLException;

    List<Pessoa> readAll() throws SQLException;

    void update(Pessoa p1) throws SQLException;

    void delete( String cpf, String placa) throws SQLException;
}
