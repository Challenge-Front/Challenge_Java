package org.example.dao;

import org.example.config.DBConnectionFactory;
import org.example.models.assegurado.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class CarroDaoImpl implements CarroDao{


    @Override
    public Carro create(Carro c1,Connection connection){
        String sql = "insert into veiculo (id_veiculo, marca, ano, modelo, nr_placa, nr_cpf) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1,c1.getId());
            ps.setString(2, c1.getMarca());
            ps.setInt(3, c1.getAno());
            ps.setString(4, c1.getModelo());
            ps.setString(5, c1.getPlaca());
            ps.setString(6, c1.getCpfDono());

            ps.executeUpdate();

            ps.close();
            System.out.println("Dados inseridos com sucesso");
            return c1;
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel inserir os dados" + e.getMessage());
        }
    }

    @Override
    public List<Carro> readAllById(String cpfDono) {
        List<Carro> result = new ArrayList<>();
        String sql = "select * from veiculo where nr_cpf=?";
        try (Connection connection = DBConnectionFactory.create().get()){
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, cpfDono);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id_veiculo");
                String marca = rs.getString("marca");
                int ano = rs.getInt("ano");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("nr_placa");
                String cpf = rs.getString("nr_cpf");

                result.add(new Carro(id, marca, modelo, placa, ano, cpf));
            }

            rs.close();
            stat.close();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar os dados: " + e.getMessage());
        }
        return result;
    }


    @Override
    public Carro update(Carro c1,Connection connection){
        String sql = "update veiculo set  marca = ?, ano = ?, modelo = ?, nr_placa = ?, nr_cpf = ? where id_veiculo = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, c1.getMarca());
            ps.setInt(2, c1.getAno());
            ps.setString(3, c1.getModelo());
            ps.setString(4, c1.getPlaca());
            ps.setObject(5, c1.getCpfDono());
            ps.setLong(6,c1.getId());

            ps.executeUpdate();

            ps.close();
            System.out.println("Dados alterados com sucesso");
            return c1;
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar os dados");
        }

    }

    @Override
    public void delete(String placa,Connection connection){
        String sql = "delete from veiculo where nr_placa = ?";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1,placa);
            stat.executeUpdate();
            stat.close();
            System.out.println("Dados excluídos com sucesso");
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel excluir os dados");
        }

    }
}
