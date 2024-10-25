package org.example.dao;

import org.example.models.assegurado.Endereco;

import java.sql.Connection;
import java.util.List;

public interface EnderecoDao {
    void create(Endereco e1, Connection connection);

    List<Endereco> readByCpf(String cpf);

    void update(Endereco e1, Connection connection);

    void delete(Long id, Connection connection);
}
