package org.example.dao;

import org.example.entities.Manutencao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDaoImplSingleton implements ManutencaoDao {

    private static ManutencaoDaoImplSingleton instance;

    private final Connection connection;


    public ManutencaoDaoImplSingleton(Connection connection) {
        this.connection = connection;
    }


    public static synchronized ManutencaoDaoImplSingleton getInstance(Connection connection){
        if (instance == null){
            instance = new ManutencaoDaoImplSingleton(connection);
        }
        return instance;
    }




    @Override
    public void create(Manutencao manutencao) throws SQLException {
        String sql = "INSERT INTO MANUTENCAO(dataAgendamentoManutencao, horarioAgendamentoManutencao, enderecoCentroAutomotivo) VALUES (?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, manutencao.getDataAgendamentoManutencao());
        pstmt.setInt(2, manutencao.getHorarioAgendamentoManutencao());
        pstmt.setString(3, manutencao.getEnderecoCentroAutomotivo());
        pstmt.executeUpdate();
    }

    @Override
    public List<Manutencao> read() throws SQLException {
        List<Manutencao> result = new ArrayList<>();
        String sql = "SELECT * FROM MANUTENCAO";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String dataAgendamentoManutencao = rs.getString("dataAgendamentoManutencao");
            int horarioAgendamentoManutencao = rs.getInt("horarioAgendamentoManutencao");
            String enderecoCentroAutomotivo = rs.getString("enderecoCentroAutomotivo");
            result.add(new Manutencao(id, dataAgendamentoManutencao, horarioAgendamentoManutencao, enderecoCentroAutomotivo));

        }
        return result;
    }

    @Override
    public void update(Manutencao manutencao) throws SQLException {
        String sql = "UPDATE MANUTENCAO SET dataAgendamentoManutencao=?, horarioAgendamentoManutencao=?, enderecoCentroAutomotivo=? WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, manutencao.getDataAgendamentoManutencao());
        pstmt.setInt(2, manutencao.getHorarioAgendamentoManutencao());
        pstmt.setString(3, manutencao.getEnderecoCentroAutomotivo());

        pstmt.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE MANUTENCAO WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);

        pstmt.executeUpdate();
    }

    @Override
    public Manutencao findId(int id) throws SQLException {
        Manutencao manutencaoEncontrada = null;
        String sql = "SELECT * FROM MANUTENCAO WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String dataAgendamentoManutencao = rs.getString("dataAgendamentoManutencao");
            int horarioAgendamentoManutencao = rs.getInt("horarioAgendamentoManutencao");
            String enderecoCentroAutomotivo = rs.getString("enderecoCentroAutomotivo");

            manutencaoEncontrada = new Manutencao(id, dataAgendamentoManutencao, horarioAgendamentoManutencao, enderecoCentroAutomotivo);

        }
        return manutencaoEncontrada;

    }
}