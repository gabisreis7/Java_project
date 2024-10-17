package org.example.dao;

import org.example.entities.Seguro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeguroDaoImplementado implements SeguroDao {

    private final Connection connection;

    public SeguroDaoImplementado(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Seguro seguro) throws SQLException {
        String sql = "INSERT INTO T_VB_SEGURO(id, numeroApolice, dataInicio, dataFim) " +
                "VALUES (?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, seguro.getId());
        pstmt.setLong(2, seguro.getNumeroApolice());
        pstmt.setDate(3, new java.sql.Date(seguro.getDataInicio().getTime()));
        pstmt.setDate(4, new java.sql.Date(seguro.getDataFim().getTime()));
        pstmt.executeUpdate();
    }

    @Override
    public List<Seguro> read() throws SQLException {
        List<Seguro> result = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_SEGURO";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String numeroApolice = rs.getString("numeroApolice");
            Date dataInicio = rs.getDate("dataInicio");
            Date dataFim = rs.getDate("dataFim");

            Seguro seguro = new Seguro(id, numeroApolice, dataInicio, dataFim);
            result.add(seguro);
        }
        return result;
    }

    @Override
    public void update(Seguro seguro) throws SQLException {
        String sql = "UPDATE T_VB_SEGURO SET numeroApolice=?, dataInicio=?, dataFim=? WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, seguro.getNumeroApolice());
        pstmt.setDate(2, new java.sql.Date(seguro.getDataInicio().getTime()));
        pstmt.setDate(3, new java.sql.Date(seguro.getDataFim().getTime()));
        pstmt.setLong(4, seguro.getId());
        pstmt.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE T_VB_SEGURO WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);    pstmt.executeUpdate();
    }
}
