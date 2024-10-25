package org.example.dao;

import org.example.config.DBConnectionFactory;
import org.example.models.assegurado.Pessoa;
import org.example.models.oficina.Mecanico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class MecanicoDaoImpl implements MecanicoDao{

    @Override
    public void create(Mecanico m1, Connection connection){
        String sql = "insert into mecanico( nm_completo, nr_cpf, nr_telefone, idade, nr_cnpj) values (?,?,?,?,?)";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, m1.getNome());
            pstat.setString(2, m1.getCpf());
            pstat.setString(3, m1.getTelefone());
            pstat.setLong(4, m1.getIdade());
            pstat.setString(5,m1.getCnpjOficina());
            pstat.executeUpdate();
            pstat.close();
            System.out.println("Dados inseridos com sucesso");
        }catch (SQLException e){
            System.out.println("Não foi possível inserir os dados devido ao erro: " + e.getMessage());
        }
    }

    @Override
    public List<Pessoa> readByCpf(String cpf){
        List<Pessoa> result = new ArrayList<>();
        String sql = "select * from mecanico where nr_cpf = ?";
        try (Connection connection = DBConnectionFactory.create().get()){
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, cpf);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                String cpfRs = rs.getString("cpf");
                String nome = rs.getString("nome");
                Integer idade = rs.getInt("idade");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                result.add(new Pessoa(nome,idade,email,telefone,cpfRs));
            }
            rs.close();
            stat.close();
        }catch (SQLException e){
            System.out.println("Não foi possível buscar os dados devido ao erro: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void update(Mecanico m1, Connection connection) throws SQLException {
        try {
            String sql = "update mecanico set nm_completo = ?, nr_telefone = ?, idade = ?, nr_cnpj = ?,  where nr_cpf = ?";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, m1.getNome());
            stat.setString(2, m1.getTelefone());
            stat.setInt(3, m1.getIdade());
            stat.setString(4, m1.getCnpjOficina());
            stat.setString(5, m1.getCpf());
            stat.executeUpdate();
            stat.close();
        }catch(SQLException e){
            System.out.println("Não foi possível alterar os dados devido ao erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long cpf, Connection connection) throws SQLException {
        String sql = "delete from mecanico where cpf = ?";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setLong(1,cpf);
            stat.executeUpdate();
        }catch(SQLException e){
            System.out.println("Não foi possível excluir os dados devido ao erro: " + e.getMessage());
        }
    }
}
