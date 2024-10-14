package org.example.dao;

import org.example.entities.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImplementado implements ClienteDao{

    private final Connection connection;

    public ClienteDaoImplementado(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO T_VB_CLIENTE(id, nome, idade, email, senha, numeroCpf, numeroRg, endereco, numeroCnh) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, cliente.getId());
        pstmt.setString(2, cliente.getNome());
        pstmt.setInt(3, cliente.getIdade());
        pstmt.setString(4, cliente.getEmail());
        pstmt.setString(5, cliente.getSenha());
        pstmt.setLong(6, cliente.getNumeroCpf());
        pstmt.setLong(7, cliente.getNumeroRg());
        pstmt.setString(8, cliente.getEndereco());
        pstmt.setLong(9, cliente.getNumeroCnh());
        pstmt.executeUpdate();

    }

    @Override
    public List<Cliente> read() throws SQLException {
        List<Cliente> result = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_CLIENTE";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            Long id = rs.getLong("id");
            String nome = rs.getString("nome");
            int idade = rs.getInt("idade");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            Long numeroCpf = rs.getLong("numeroCpf");
            Long numeroRg = rs.getLong("numeroRg");
            String endereco = rs.getString("endereco");
            Long numeroCnh = rs.getLong("numeroCnh");
            result.add(new Cliente(id, nome, idade, email, senha, numeroCpf, numeroRg, endereco , numeroCnh));
        }
        return result;
    }


    @Override
    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE T_VB_CLIENTE SET ID=?, NOME=?, IDADE=?, EMAIL=?, SENHA=?, NUMEROCPF=?, NUMERORG=?, ENDERECO=?, NUMEROCNH=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, cliente.getId());
        pstmt.setString(2, cliente.getNome());
        pstmt.setInt(3, cliente.getIdade());
        pstmt.setString(4, cliente.getEmail());
        pstmt.setString(5, cliente.getSenha());
        pstmt.setLong(6, cliente.getNumeroCpf());
        pstmt.setLong(7, cliente.getNumeroRg());
        pstmt.setString(8, cliente.getEndereco());
        pstmt.setLong(9, cliente.getNumeroCnh());

        pstmt.executeUpdate();

    }


    @Override
    public void delete(Long id, String nome, int idade, String email, String senha, Long numeroCpf, Long numeroRg, String endereco, Long numeroCnh) throws SQLException {
        String sql = "DELETE T_VB_CLIENTE WHERE ID=?, NOME=?, IDADE=?, EMAIL=?, SENHA=?, NUMEROCPF=?, NUMERORG=?, ENDERECO=?, NUMEROCNH=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, id);
        pstmt.setString(2, nome);
        pstmt.setInt(3, idade);
        pstmt.setString(4, email);
        pstmt.setString(5, senha);
        pstmt.setLong(6, numeroCpf);
        pstmt.setLong(7, numeroRg);
        pstmt.setString(8, endereco);
        pstmt.setLong(9, numeroCnh);

        pstmt.executeUpdate();

    }


}
