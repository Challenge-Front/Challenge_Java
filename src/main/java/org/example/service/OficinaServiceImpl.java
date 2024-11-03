package org.example.service;

import org.example.config.DBConnectionFactory;
import org.example.dao.OficinaDao;
import org.example.dao.OficinaDaoFactory;
import org.example.exception.NotFoundException;
import org.example.exception.NotSavedException;
import org.example.exception.UnsupportedServiceOperationException;
import org.example.models.oficina.Oficina;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OficinaServiceImpl implements OficinaService{
    private final OficinaDao dao = OficinaDaoFactory.get();
    @Override
    public Oficina create(Oficina o1) throws UnsupportedServiceOperationException, SQLException, NotSavedException {
        if(o1.getCnpj() != null){
            Connection connection = DBConnectionFactory.create().get();
            try {
                o1 = this.dao.create(o1, connection);
                connection.commit();
                return o1;
            } catch( SQLException e) {
                connection.rollback();
                throw e;
            }
        } else {
            throw new UnsupportedServiceOperationException();
        }
    }

    @Override
    public List<Oficina> readByCnpj(String cnpj) throws SQLException {
        return this.dao.readByCnpj(cnpj);
    }

    @Override
    public Oficina update(Oficina o1)  throws NotFoundException, SQLException {
        if (o1.getCnpj() != null) {
            Connection connection = DBConnectionFactory.create().get();
            try{
                o1 = this.dao.update(o1, connection);
                connection.commit();
                return o1;
            }catch ( SQLException e){
                connection.rollback();
                throw e;
            }
        }
        return o1;
    }

    @Override
    public void delete(String cnpj) throws NotFoundException, SQLException  {
        Connection connection = DBConnectionFactory.create().get();
        this.dao.delete(cnpj,connection);
        connection.commit();
    }
}
