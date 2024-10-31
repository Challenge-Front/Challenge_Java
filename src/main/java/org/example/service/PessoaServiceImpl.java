package org.example.service;

import org.example.config.DBConnectionFactory;
import org.example.dao.PessoaDao;
import org.example.dao.PessoaDaoFactory;
import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PessoaServiceImpl implements PessoaService{
    private final PessoaDao dao = PessoaDaoFactory.get();


    @Override
    public Pessoa create(Pessoa pessoa) throws UnsupportedServiceOperationException, SQLException {
        if(pessoa.getCpf() != null){
            Connection connection = DBConnectionFactory.create().get();
            try {
                pessoa = this.dao.create(pessoa, connection);
                connection.commit();
                return pessoa;
            } catch( SQLException e) {
                connection.rollback();
                throw e;
            }
        } else {
            throw new UnsupportedServiceOperationException();
        }
    }

    @Override
    public List<Pessoa> readByCpf(String cpf) {
        return this.dao.readByCpf(cpf);
    }




    @Override
    public Pessoa update(Pessoa pessoa) throws NotFoundException, SQLException {
        if (pessoa.getCpf() != null) {
            Connection connection = DBConnectionFactory.create().get();
            try{
                pessoa = this.dao.update(pessoa, connection);
                connection.commit();
                return pessoa;
            }catch ( SQLException e){
                connection.rollback();
                throw e;
            }
        }
        return pessoa;
    }

    @Override
    public void delete(String cpf, String placa) throws NotFoundException, SQLException {
        Connection connection = DBConnectionFactory.create().get();
        this.dao.delete(cpf,placa,connection);
        connection.commit();
    }
}
