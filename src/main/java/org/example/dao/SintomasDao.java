package org.example.dao;

import org.example.models.assegurado.Sintomas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SintomasDao {

    List<Sintomas> readByPlaca(String cpf) throws SQLException;

}
