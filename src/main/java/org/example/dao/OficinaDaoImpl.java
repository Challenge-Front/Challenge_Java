package org.example.dao;

import org.example.models.oficina.Oficina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OficinaDaoImpl implements OficinaDao {

    private final Connection connection;

    public OficinaDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Oficina o1) throws SQLException {
        String sql = "insert into oficina(nome, nr_cnpj, id_endereco) values (?,?,?)";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, o1.getNome());
            pstat.setString(2, o1.getCnpj());
            pstat.setLong(3, o1.getEndereco());
            pstat.executeUpdate();
            pstat.close();
        }catch (SQLException e){
            System.out.println("Não foi possível inserir os dados devido ao erro: " + e.getMessage());
        }
    }

    @Override
    public List<Oficina> readAll() throws SQLException {
        List<Oficina> result = new ArrayList<>();
        String sql = "select * from oficina";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpnj = rs.getString("nr_cpnj");
                Long endereco = rs.getLong("id_endereco");
                result.add(new Oficina(endereco,nome,cpnj));
            }
            rs.close();
            stat.close();
        }catch (SQLException e){
            System.out.println("Não foi possível buscar os devido ao erro: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void update(Oficina o1) throws SQLException {
        String sql = "update oficina set nome = ?, endereco = ? where nr_cnpj = ?";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, o1.getNome());
            pstat.setLong(2, o1.getEndereco());
            pstat.setString(3, o1.getCnpj());
            pstat.executeUpdate();
            pstat.close();
        }catch (SQLException e){
            System.out.println("Não foi possível fazer update dos devido ao erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(String cnpj, String cpf) throws SQLException {
        String sql = "delete from oficina where nr_cpf = ?";
        String sql2 = "delete from mecanico where nr_cnpj = ?";
        try{
            PreparedStatement stat = connection.prepareStatement(sql);
            PreparedStatement stat2 = connection.prepareStatement(sql2);
            stat.setString(1,cnpj);
            stat2.setString(1,cpf);
            stat.executeUpdate();
            stat2.executeUpdate();
        }catch (SQLException e){
            System.out.println("Não foi possível excluir os devido ao erro: " + e.getMessage());
        }
    }
}
