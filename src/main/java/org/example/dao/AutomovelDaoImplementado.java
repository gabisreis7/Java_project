package org.example.dao;

import org.example.entities.Automovel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutomovelDaoImplementado implements AutomovelDao{

    private final Connection connection;

    public AutomovelDaoImplementado(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Automovel automovel) throws SQLException {
        String sql = "INSERT INTO T_AUTOMOVEL(placaAutomovel, marcaAutomovel, modeloAutomovel, numeroChassi, codigoRenavam, anoAutomovel, porteAutomovel) " +
                "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, automovel.getPlacaAutomovel());
        pstmt.setString(2, automovel.getMarcaAutomovel());
        pstmt.setString(3, automovel.getModeloAutomovel());
        pstmt.setLong(4, automovel.getNumeroChassi());
        pstmt.setLong(5, automovel.getCodigoRenavam());
        pstmt.setInt(6, automovel.getAnoAutomovel());
        pstmt.setString(7, automovel.getPorteAutomovel());
        pstmt.executeUpdate();

    }

    @Override
    public List<Automovel> read() throws SQLException {
        List<Automovel> result = new ArrayList<>();
        String sql = "SELECT * FROM T_AUTOMOVEL";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            String placaAutomovel = rs.getString("placaAutomovel");
            String marcaAutomovel = rs.getString("marcaAutomovel");
            String modeloAutomovel = rs.getString("modeloAutomovel");
            Long numeroChassi = rs.getLong("numeroChassi");
            Long codigoRenavem = rs.getLong("codigoRenavam");
            int anoAutomovel = rs.getInt("anoAutomovel");
            String porteAutomovel = rs.getString("porteAutomovel");

        }
        return result;
    }


    @Override
    public void update(Automovel automovel) throws SQLException {
        String sql = "UPDATE T_AUTOMOVEL SET id=?, placaAutomovel=?, marcaAutomovel=?, modeloAutomovel=?, numeroChassi=?, codigoRenavam=?, anoAutomovel=?, porteAutomovel=? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, automovel.getPlacaAutomovel());
        pstmt.setString(2, automovel.getMarcaAutomovel());
        pstmt.setString(3, automovel.getModeloAutomovel());
        pstmt.setLong(4, automovel.getNumeroChassi());
        pstmt.setLong(5, automovel.getCodigoRenavam());
        pstmt.setInt(6, automovel.getAnoAutomovel());
        pstmt.setString(7, automovel.getPorteAutomovel());
        pstmt.executeUpdate();





    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE T_AUTOMOVEL WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);

        pstmt.executeUpdate();
    }

    @Override
    public Automovel findId(int id) throws SQLException {
        Automovel automovelEncontrado = null;
        List<Automovel> result = new ArrayList<>();
        String sql = "SELECT * FROM T_AUTOMOVEL WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()){
            String placaAutomovel = rs.getString("placaAutomovel");
            String marcaAutomovel = rs.getString("marcaAutomovel");
            String modeloAutomovel = rs.getString("modeloAutomovel");
            Long numeroChassi = rs.getLong("numeroChassi");
            Long codigoRenavem = rs.getLong("codigoRenavam");
            int anoAutomovel = rs.getInt("anoAutomovel");
            String porteAutomovel = rs.getString("porteAutomovel");

            automovelEncontrado = new Automovel(id, placaAutomovel, marcaAutomovel, modeloAutomovel, numeroChassi, codigoRenavem, anoAutomovel, porteAutomovel);

        }

        return automovelEncontrado;
    }


}
