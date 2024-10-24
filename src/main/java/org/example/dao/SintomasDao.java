package org.example.dao;

import org.example.models.assegurado.Sintomas;

import java.util.List;

public interface SintomasDao {
    void create(Sintomas s1);


    List<Sintomas> readAll();

    void delete(String id);
}
