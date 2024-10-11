package org.example.dao;

import org.example.models.assegurado.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDaoImpl implements EnderecoDao{

    private final Connection connection;

    public EnderecoDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Endereco e1) {
        String sql = "insert into endereco(id_endereco, cidade, bairro, estado, nr_residencia, nr_cep, nm_de_logradouro, nr_cpf) values(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setLong(1,e1.getId());
            stat.setString(2,e1.getCidade());
            stat.setString(3,e1.getBairro());
            stat.setString(4, e1.getEstadoUf());
            stat.setString(5, e1.getNumero());
            stat.setString(6, e1.getCep());
            stat.setString(7, e1.getLogradouro());
            stat.setString(8, e1.getCpfCliente());

            stat.executeUpdate();

            stat.close();
            System.out.println("Dados inseridos com sucesso");
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel inserir os dados, devido ao erro: " + e.getMessage());
        }
    }

    @Override
    public List<Endereco> readAll() {
        List<Endereco> result = new ArrayList<>();
        String sql = "select * from endereco";
        try{
            PreparedStatement stat = connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("id_endereco");
                String cidade = rs.getString("cidade");
                String bairro = rs.getString("bairro");
                String estado = rs.getString("estado");
                String nr_cep = rs.getString("nr_cep");
                String nr_residencia = rs.getString("nr_residencia");
                String nm_logradouro = rs.getString("nm_de_logradouro");
                String nr_cpf = rs.getString("nr_cpf");
                result.add(new Endereco(id, nm_logradouro,nr_residencia,bairro,estado,cidade,nr_cep,nr_cpf));
            }
            stat.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel buscar os dados, devido ao erro: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void update(Endereco e1) {
        String sql = "update endereco set cidade = ?, bairro = ?, estado = ?, nr_cep = ?, nr_residencia = ?, nm_de_logradouro = ?, nr_cpf = ? where id_endereco = ?";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setString(1,e1.getCidade());
            stat.setString(2,e1.getBairro());
            stat.setString(3, e1.getEstadoUf());
            stat.setString(4, e1.getCep());
            stat.setString(5, e1.getNumero());
            stat.setString(6, e1.getLogradouro());
            stat.setString(7, e1.getCpfCliente());
            stat.setLong(8,e1.getId());

            stat.executeUpdate();

            stat.close();
            System.out.println("Dados alterados com sucesso");
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel alterar os dados, devido ao erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from endereco where id_endereco = ?";
        try{
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setLong(1,id);

            stat.executeUpdate();

            stat.close();
            System.out.println("Dados deletados com sucesso");
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel alterar os dados, devido ao erro: " + e.getMessage());
        }
    }
}
