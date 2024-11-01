package org.example.service;

import org.example.config.DBConnectionFactory;
import org.example.dao.MecanicoDao;
import org.example.dao.MecanicoDaoFactory;
import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Pessoa;
import org.example.models.oficina.Mecanico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MecanicoServiceImpl implements MecanicoService{
    private final MecanicoDao dao = MecanicoDaoFactory.get();

    @Override
    public Mecanico create(Mecanico m1) throws UnsupportedServiceOperationException, SQLException, NotSavedException {
        if(m1.getCpf() != null){
            Connection connection = DBConnectionFactory.create().get();
            try {
                m1 = this.dao.create(m1, connection);
                connection.commit();
                return m1;
            } catch( SQLException e) {
                connection.rollback();
                throw e;
            }
        } else {
            throw new UnsupportedServiceOperationException();
        }
    }

    @Override
    public List<Mecanico> readByCpf(String cpf) throws SQLException {
        return this.dao.readByCpf(cpf);
    }

    @Override
    public Mecanico update(Mecanico m1) throws NotFoundException, SQLException {
        if (m1.getCpf() != null) {
            Connection connection = DBConnectionFactory.create().get();
            try{
                m1 = this.dao.update(m1, connection);
                connection.commit();
                return m1;
            }catch ( SQLException e){
                connection.rollback();
                throw e;
            }
        }
        return m1;
    }

    @Override
    public void delete(String cpf) throws NotFoundException, SQLException {
        Connection connection = DBConnectionFactory.create().get();
        this.dao.delete(cpf,connection);
        connection.commit();
    }
}
