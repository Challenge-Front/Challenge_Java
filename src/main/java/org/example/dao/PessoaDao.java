package org.example.dao;

import org.example.models.assegurado.Pessoa;

import java.sql.SQLException;
import java.util.List;

public interface PessoaDao {

    void create(Pessoa p1);

    List<Pessoa> readAll();

    void update(Pessoa p1);

    void delete( String cpf, String placa);
}
