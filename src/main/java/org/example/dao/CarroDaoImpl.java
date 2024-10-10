package org.example.dao;

import org.example.assegurado.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDaoImpl implements CarroDao{

    private final Connection connection;

    public CarroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Carro c1){
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
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel inserir os dados");
        }
    }

    @Override
    public List<Carro> readAll() {
        List<Carro> result = new ArrayList<>();
        String sql = "select * from veiculo  ";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String marca = rs.getString("marca");
                Integer ano = rs.getInt("ano");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("nr_placa");
                String cpf = rs.getString("nr_cpf");
                result.add(new Carro(id,marca, modelo,placa, ano, cpf));

            }
            stat.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel buscar os dados");
        }
        return result;
    }

    @Override
    public void update(Carro c1) throws SQLException {

    }

    @Override
    public void delete(String placa) throws SQLException {

    }
}
