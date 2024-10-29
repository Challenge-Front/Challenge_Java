package org.example.service;

import org.example.config.DBConnectionFactory;
import org.example.dao.CarroDao;
import org.example.dao.CarroDaoFactory;
import org.example.exception.NotFoundException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.assegurado.Carro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarroServiceImpl implements CarroService{
    private final CarroDao dao = CarroDaoFactory.get();


    @Override
    public Carro create(Carro c1) throws UnsupportedServiceOperationException, SQLException {
        if(c1.getPlaca() == null){
            Connection connection = DBConnectionFactory.create().get();
            try {
                c1 = this.dao.create(c1, connection);
                connection.commit();
                return c1;
            } catch( SQLException e) {
                connection.rollback();
                throw e;
            }
        } else {
            throw new UnsupportedServiceOperationException();
        }
    }

    @Override
    public List<Carro> readAllById(String cpfDono) {
        return this.dao.readAllById(cpfDono);
    }




    @Override
    public Carro update(Carro c1) throws NotFoundException, SQLException {
        if (c1.getId() != null) {
            Connection connection = DBConnectionFactory.create().get();
            try{
                c1 = this.dao.update(c1, connection);
                connection.commit();
                return c1;
            }catch ( SQLException e){
                connection.rollback();
                throw e;
            }
        }
        return c1;
    }

    @Override
    public void delete( String placa) throws NotFoundException, SQLException {
        Connection connection = DBConnectionFactory.create().get();
        this.dao.delete(placa,connection);
        connection.commit();
    }
}
