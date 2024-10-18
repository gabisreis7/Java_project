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
        String sql = "INSERT INTO T_SEGURO(numeroApolice, vigencia) " +
                "VALUES (?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, seguro.getNumeroApolice());
        pstmt.setString(2, seguro.getVigencia());
        pstmt.executeUpdate();
    }

    @Override
    public List<Seguro> read() throws SQLException {
        List<Seguro> result = new ArrayList<>();
        String sql = "SELECT * FROM T_SEGURO";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            Long numeroApolice = rs.getLong("numeroApolice");
            String vigencia = rs.getString("vigencia");
            result.add(new Seguro(id, numeroApolice, vigencia));
        }
        return result;
    }

    @Override
    public void update(Seguro seguro) throws SQLException {
        String sql = "UPDATE T_SEGURO SET numeroApolice=?, vigencia=?  WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, seguro.getNumeroApolice());
        pstmt.setString(2, seguro.getVigencia());
        pstmt.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE T_SEGURO WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    @Override
    public Seguro findId(int id) throws SQLException {
        Seguro seguroEncontrado = null;
        String sql = "SELECT * FROM T_SEGURO WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()){
            Long numeroApolice = rs.getLong("numeroApolice");
            String vigencia = rs.getString("vigencia");

            seguroEncontrado = new Seguro(id, numeroApolice, vigencia);
        }
        return seguroEncontrado;
    }
}
