package org.example.dao;

import org.example.entities.Manutencao;
import org.example.entities.ManutencaoCorretiva;
import org.example.entities.ManutencaoPreventiva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDaoImplementado implements ManutencaoDao {

    private final Connection connection;

    public ManutencaoDaoImplementado(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Manutencao manutencao) throws SQLException {
        String sql = "INSERT INTO T_VB_MANUTENCAO(tipo, descricao, dataAgendamentoManutencao, horarioAgendamentoManutencao, enderecoCentroAutomotivo) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, manutencao.getId());
        pstmt.setString(2, manutencao.getTipoManutencao());
        pstmt.setString(3, manutencao.getDescricao());
        pstmt.setString(4, manutencao.getDataAgendamentoManutencao());
        pstmt.setInt(5, manutencao.getHorarioAgendamentoManutencao());
        pstmt.setString(6, manutencao.getEnderecoCentroAutomotivo());
        pstmt.executeUpdate();
    }

    @Override
    public List<Manutencao> read() throws SQLException {
        List<Manutencao> result = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_MANUTENCAO";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
            int id = rs.getInt("id");
            String tipoManutencao = rs.getString("tipoManutencao");
            String descricao = rs.getString("descricao");
            String dataAgendamentoManutencao = rs.getString("dataAgendamentoManutencao");
            int horarioAgendamentoManutencao = rs.getInt("horarioAgendamentoManutencao");
            String enderecoCentroAutomotivo = rs.getString("enderecoCentroAutomotivo");
            result.add(new Manutencao(id, tipoManutencao, descricao, dataAgendamentoManutencao, horarioAgendamentoManutencao, enderecoCentroAutomotivo));

        }
        return result;
    }

    @Override
    public void update(Manutencao manutencao) throws SQLException {
        String sql = "UPDATE T_VB_MANUTENCAO SET tipoManutencao=?, descricao=?, dataAgendamentoManutencao=?, horarioAgendamentoManutencao=?, enderecoCentroAutomotivo=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, manutencao.getId());
        pstmt.setString(2, manutencao.getTipoManutencao());
        pstmt.setString(3, manutencao.getDescricao());
        pstmt.setString(4, manutencao.getDataAgendamentoManutencao());
        pstmt.setInt(5, manutencao.getHorarioAgendamentoManutencao());
        pstmt.setString(6, manutencao.getEnderecoCentroAutomotivo());

        pstmt.executeUpdate();
    }

    @Override
    public void delete(int id, String tipoManutencao, String descricao, String dataAgendamentoManutencao, int horarioAgendamentoManutencao, String enderecoCentroAutomotivo) throws SQLException {
        String sql = "DELETE T_VB_MANUTENCAO WHERE id=?, tipoManutencao=?, descricao=?, dataAgendamentoManutencao=?, horarioAgendamentoManutencao=?, enderecoCentroAutomotivo=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, tipoManutencao);
        pstmt.setString(3, descricao);
        pstmt.setString(4, dataAgendamentoManutencao);
        pstmt.setInt(5, horarioAgendamentoManutencao);
        pstmt.setString(6, enderecoCentroAutomotivo);

        pstmt.executeUpdate();
    }


}