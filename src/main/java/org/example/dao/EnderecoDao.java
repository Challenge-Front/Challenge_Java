package org.example.dao;

import org.example.models.assegurado.Endereco;

import java.util.List;

public interface EnderecoDao {
    void create(Endereco e1);

    List<Endereco> readAll();

    void update(Endereco e1);

    void delete(Long id);
}
