package org.example.dao;

import org.example.models.assegurado.Sintomas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SintomasDaoImpl implements SintomasDao{
    private final Connection connection;

    public SintomasDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Sintomas s1) {
        String sql = "insert into problemas(id_problemas, id_veiculo, nr_cpf, tipo_problema, caracteristica) values(?,?,?,?,?)";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setLong(1, s1.getId());
            stat.setLong(2, s1.getId_veiculo());
            stat.setString(3, s1.getCpf());
            stat.setString(4, s1.getDiagnostico());
            stat.setString(5,s1.getSintomasRelatados());

            stat.executeUpdate();

            stat.close();

            System.out.println("Dados inseridos com sucesso.");
        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir os dados: " + e.getMessage());
        }
    }

    @Override
    public List<Sintomas> readAll() {
        List<Sintomas> result = new ArrayList<>();
        String sql = "select * from problemas  ";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id_problemas");
                Long id_veiculo = rs.getLong("id_veiculo");
                String cpf = rs.getString("nr_cpf");
                String diagnostico = rs.getString("tipo_problema");
                String sintomasRelatados = rs.getString("caracteristica");
                result.add(new Sintomas(id, id_veiculo, cpf, diagnostico, sintomasRelatados));
            }
            stat.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException("Erro ao ler os dados do Sintomas: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void delete(String id) {
        String sql = "delete from problemas where id_problemas = ?";
        try{
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1,id);
            stat.executeUpdate();
            stat.close();
            System.out.println("Sintoma deletado com sucesso");
        }catch (SQLException e){

        }
    }
}
