package org.example.dao;

import org.example.entities.Problema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemaDaoImplementado implements ProblemaDao {

        private final Connection connection;

        public ProblemaDaoImplementado(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void create(Problema problema) throws SQLException {
            String sql = "INSERT INTO T_PROBLEMA(tipoProblema, descricaoProblema, gravidadeProblema) VALUES (?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, problema.getTipoProblema());
            pstmt.setString(2, problema.getDescricaoProblema());
            pstmt.setInt(3, problema.getGravidadeProblema());
            pstmt.executeUpdate();
        }

        @Override
        public List<Problema> read() throws SQLException {
            List<Problema> result = new ArrayList<>();
            String sql = "SELECT * FROM T_PROBLEMA";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipoProblema = rs.getString("tipoProblema");
                String descricaoProblema = rs.getString("descricaoProblema");
                int gravidadeProblema = rs.getInt("gravidadeProblema");
                result.add(new Problema(id, tipoProblema, descricaoProblema, gravidadeProblema));
            }
            return result;
        }

        @Override
        public void update(Problema problema) throws SQLException {
            String sql = "UPDATE T_PROBLEMA SET id=?, tipoProblema=?, descricaoProblema=?, gravidadeProblema=? WHERE tipoProblema=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, problema.getTipoProblema());
            pstmt.setString(2, problema.getDescricaoProblema());
            pstmt.setInt(3, problema.getGravidadeProblema());
            pstmt.executeUpdate();
        }

        @Override
        public void delete(int id) throws SQLException {
            String sql = "DELETE T_PROBLEMA WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }

    @Override
    public Problema findId(int id) throws SQLException {
            Problema problemaEncontrado = null;
            String sql = "SELECT * FROM T_PROBLEMA WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
                String tipoProblema = rs.getString("tipoProblema");
                String descricaoProblema = rs.getString("descricaoProblema");
                int gravidadeProblema = rs.getInt("gravidadeProblema");

                problemaEncontrado = new Problema(id, tipoProblema, descricaoProblema, gravidadeProblema);
            }
        return problemaEncontrado;
    }
}
