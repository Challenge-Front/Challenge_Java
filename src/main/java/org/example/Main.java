package org.example;

import org.example.config.DBConfig;
import org.example.dao.*;
import org.example.models.assegurado.Carro;
import org.example.models.assegurado.Pessoa;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBConfig db = new DBConfig("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","RM555357","200805");
        PessoaDao pessoaDao = new PessoaImpl(db.getConnection());

        Pessoa p1 = new Pessoa("Gabriel", 2002,"email@gmail.com","11912345678","12311111111");
//        pessoaDao.create(p1);
//        List<Pessoa> pessoasSalvas = pessoaDao.readAll();
//        for (Pessoa pessoaSalva : pessoasSalvas){
//            System.out.println(pessoaSalva.toString());
//        }
//        p1.setEmail("gabriel@gmail.com");
//        pessoaDao.update(p1);
//        pessoaDao.delete(p1.getCpf(),"1");

        CarroDao c1Dao = new CarroDaoImpl(db.getConnection());
        Carro c1 = new Carro(1L,"Volkswagen","Jetta","ABC1234",2021,p1.getCpf());
//        c1Dao.create(c1);
//        List<Carro> carrosSalvos = c1Dao.readAll();
//        for (Carro carroSalvo : carrosSalvos) {
//            System.out.println(carroSalvo.toString());
//        }
//        c1.setAno(2022);
//        c1Dao.update(c1);
//        c1Dao.delete(c1.getId());

    }
}
