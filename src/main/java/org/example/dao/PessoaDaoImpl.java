package org.example.dao;

import org.example.config.DBConnectionFactory;
import org.example.models.assegurado.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class PessoaDaoImpl implements PessoaDao {


    @Override
    public Pessoa create(Pessoa p1, Connection connection) {
        String sql = "INSERT INTO cliente(nr_cpf, nm_completo, email, senha, idade, nr_telefone) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pstat = connection.prepareStatement(sql)) {


            pstat.setString(1, p1.getCpf());
            pstat.setString(2, p1.getNome());
            pstat.setString(3, p1.getEmail());
            pstat.setString(4, p1.getSenha());
            pstat.setInt(5, p1.getIdade());
            pstat.setString(6, p1.getTelefone());

            pstat.executeUpdate();

            System.out.println("Dados inseridos com sucesso");
            return p1;
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir os dados: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Pessoa> readByCpf(String cpf){
        List<Pessoa> result = new ArrayList<>();
        String sql = "SELECT * FROM cliente where nr_cpf = ?";
        try (Connection connection = DBConnectionFactory.create().get()){
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, cpf);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String nr_cpf = rs.getString("nr_cpf");
                String nome = rs.getString("nm_completo");
                String senha = rs.getString("senha");
                // Converte a idade de String para int
                int idade = Integer.parseInt(rs.getString("idade"));

                String email = rs.getString("email");
                String telefone = rs.getString("nr_telefone");

                // Adiciona um novo objeto Pessoa com a idade como int
                result.add(new Pessoa(nome, idade, senha, email, telefone, nr_cpf));
            }

            rs.close();
            stat.close();
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel buscar os dados: " + e.getMessage());
        }

        return result;
    }



    @Override
    public Pessoa update(Pessoa p1, Connection connection){
        String sql = "UPDATE cliente SET nm_completo = ?, idade = ?, email = ?, nr_telefone = ? WHERE nr_cpf = ?";
        try{
            PreparedStatement stat = connection.prepareStatement(sql);

            // Define os valores dos parâmetros
            stat.setString(1, p1.getNome());

            // Converte a idade de int para String para compatibilidade com a coluna VARCHAR no banco
            stat.setString(2, String.valueOf(p1.getIdade()));

            stat.setString(3, p1.getEmail());
            stat.setString(4, p1.getTelefone());
            stat.setString(5, p1.getCpf());

            stat.executeUpdate();

            stat.close();

            System.out.println("Dados alterados com sucesso");
            return p1;
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar os dados");
        }
    }


    @Override
    public void delete(String cpf, String placa, Connection connection){
        String sql = "DELETE FROM cliente WHERE nr_cpf = ?";
        String sql2 = "DELETE FROM veiculo WHERE nr_placa = ?";
        try {
            // PreparedStatement para deletar o cliente
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, cpf); // Passa o CPF como String

            // PreparedStatement para deletar o veículo
            PreparedStatement stat2 = connection.prepareStatement(sql2);
            stat2.setString(1, placa); // Passa a placa do veículo

            // Executa as operações de exclusão
            stat.executeUpdate();
            stat2.executeUpdate();

            // Fecha os PreparedStatements
            stat.close();
            stat2.close();
            System.out.println("Dados deletados com sucesso");
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel deletar os dados");
        }
    }

}
