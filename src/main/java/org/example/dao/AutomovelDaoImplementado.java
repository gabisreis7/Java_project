package org.example.dao;

import org.example.entities.Automovel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutomovelDaoImplementado implements AutomovelDao{

    private final Connection connection;

    public AutomovelDaoImplementado(){
        this.connection = connection;
    }

    @Override
    public void create(Automovel automovel) throws SQLException {
        String sql = "INSERT INTO T_VB_AUTOMOVEL(placaAutomovel, marcaAutomovel, modeloAutomovel, numeroChassi, codigoRenavam, anoAutomovel, porteAutomovel) " +
                "VALUES (?,?,?,?,?,?,?";
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
        String sql = "SELECT * FROM T_VB_AUTOMOVEL";

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
        String sql = "UPDATE T_VB_AUTOMOVEL SET PLACAAUTOMOVEL=?, MARCAAUTOMOVEL=?, MODELOAUTOMOVEL=?, NUMEROCHASSI=?, CODIGORENAVAM=?, ANOAUTOMOVEL=?,PORTEAUTOMOVEL=? ";
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
    public void delete(String placaAutomovel, String marcaAutomovel, String modeloAutomovel, Long numeroChassi, Long codigoRenavam, int anoAutomovel, String porteAutomovel) throws SQLException {
        String sql = "DELETE T_VB_AUTOMOVEL WHERE PLACAAUTOMOVEL=?, MARCAAUTOMOVEL=?, MODELOAUTOMOVEL=?, NUMEROCHASSI=?, CODIGORENAVAM=?, ANOAUTOMOVEL=?, PORTEAUTOMOVEL=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, placaAutomovel);
        pstmt.setString(2, marcaAutomovel);
        pstmt.setString(3, modeloAutomovel);
        pstmt.setLong(4, numeroChassi);
        pstmt.setLong(5, codigoRenavam);
        pstmt.setInt(6, anoAutomovel);
        pstmt.setString(7, porteAutomovel);
        pstmt.executeUpdate();
    }








}
