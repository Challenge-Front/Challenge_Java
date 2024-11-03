package org.example.dao;

import org.example.config.DBConnectionFactory;
import org.example.models.oficina.Oficina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class OficinaDaoImpl implements OficinaDao {


    @Override
    public Oficina create(Oficina o1, Connection connection) throws SQLException {
        String sql = "insert into oficina(nome, nr_cnpj, endereco) values (?,?,?)";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, o1.getNome());
            pstat.setString(2, o1.getCnpj());
            pstat.setString(3, o1.getEndereco());
            pstat.executeUpdate();
            pstat.close();
        }catch (SQLException e){
            System.out.println("Não foi possível inserir os dados devido ao erro: " + e.getMessage());
        }
        return o1;
    }

    @Override
    public List<Oficina> readByCnpj(String cnpj) throws SQLException {
        List<Oficina> result = new ArrayList<>();
        String sql = "select * from oficina where nr_cnpj = ?";
        try (Connection connection = DBConnectionFactory.create().get()){
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, cnpj);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpnjRs = rs.getString("nr_cnpj");
                String endereco = rs.getString("endereco");
                result.add(new Oficina(endereco,nome,cpnjRs));
            }
            rs.close();
            stat.close();
        }catch (SQLException e){
            System.out.println("Não foi possível buscar os devido ao erro: " + e.getMessage());
        }
        return result;
    }

    @Override
    public Oficina update(Oficina o1, Connection connection) throws SQLException {
        String sql = "update oficina set nome = ?, endereco = ? where nr_cnpj = ?";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, o1.getNome());
            pstat.setString(2, o1.getEndereco());
            pstat.setString(3, o1.getCnpj());
            pstat.executeUpdate();
            pstat.close();
        }catch (SQLException e){
            System.out.println("Não foi possível fazer update dos devido ao erro: " + e.getMessage());
        }
        return o1;

    }

    @Override
    public void delete(String cnpj, Connection connection) throws SQLException {
        String sql = "delete from oficina where nr_cnpj = ?";
        try{
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1,cnpj);
            stat.executeUpdate();
            stat.close();
            System.out.println("Dados excluidos com sucesso!");
        }catch (SQLException e){
            System.out.println("Não foi possível excluir os devido ao erro: " + e.getMessage());
        }
    }
}
