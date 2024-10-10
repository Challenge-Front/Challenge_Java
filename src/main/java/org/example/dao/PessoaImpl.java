package org.example.dao;

import org.example.assegurado.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaImpl implements PessoaDao {
    private final Connection connection;

    public PessoaImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Pessoa p1){
        String sql = "INSERT INTO cliente(nm_completo, nr_cpf, idade, email, nr_telefone) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);

            // Define os valores para os parâmetros
            pstat.setString(1, p1.getNome());
            pstat.setString(2, p1.getCpf());
            pstat.setString(3, String.valueOf(p1.getIdade()));  // converte int para String
            pstat.setString(4, p1.getEmail());
            pstat.setString(5, p1.getTelefone());

            // Executa o comando
            pstat.executeUpdate();
            // Fecha o PreparedStatement
            pstat.close();
            System.out.println("Dados inseridos com sucesso");
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel inserir os dados");
        }
    }

    @Override
    public List<Pessoa> readAll(){
        List<Pessoa> result = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String cpf = rs.getString("nr_cpf");
                String nome = rs.getString("nm_completo");

                // Converte a idade de String para int
                int idade = Integer.parseInt(rs.getString("idade"));

                String email = rs.getString("email");
                String telefone = rs.getString("nr_telefone");

                // Adiciona um novo objeto Pessoa com a idade como int
                result.add(new Pessoa(nome, idade, email, telefone, cpf));
            }

            rs.close();
            stat.close();
        }catch (SQLException e){
            throw new RuntimeException("Não foi possivel buscar os dados");
        }

        return result;
    }



    @Override
    public void update(Pessoa p1){
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

            // Executa a atualização
            stat.executeUpdate();

            // Fecha o PreparedStatement
            stat.close();

            System.out.println("Dados alterados com sucesso");
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar os dados");
        }
    }


    @Override
    public void delete(String cpf, String placa){
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
