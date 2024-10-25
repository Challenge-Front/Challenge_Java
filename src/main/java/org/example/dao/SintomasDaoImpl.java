package org.example.dao;

import org.example.config.DBConnectionFactory;
import org.example.models.assegurado.Sintomas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class SintomasDaoImpl implements SintomasDao{

    @Override
    public List<Sintomas> readByPlaca(String cpf) {
        List<Sintomas> result = new ArrayList<>();
        String sql = "select * from problemas  where nr_cpf = ?";
        try (Connection connection = DBConnectionFactory.create().get()){
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, cpf);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id_problemas");
                Long id_veiculo = rs.getLong("id_veiculo");
                String nr_cpf = rs.getString("nr_cpf");
                String diagnostico = rs.getString("tipo_problema");
                String sintomasRelatados = rs.getString("caracteristica");
                result.add(new Sintomas(id, id_veiculo, nr_cpf, diagnostico, sintomasRelatados));
            }
            stat.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException("Erro ao ler os dados do Sintomas: " + e.getMessage());
        }
        return result;
    }


}
