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
            String sql = "INSERT INTO T_VB_PROBLEMA(tipoProblema, descricaoProblema, gravidadeProblema) VALUES (?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, problema.tipoProblema);
            pstmt.setString(2, problema.descricaoProblema);
            pstmt.setInt(3, problema.gravidadeProblema);
            pstmt.executeUpdate();
        }

        @Override
        public List<Problema> read() throws SQLException {
            List<Problema> result = new ArrayList<>();
            String sql = "SELECT * FROM T_VB_PROBLEMA";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int tipoProblema = rs.getInt("tipoProblema");
                String descricaoProblema = rs.getString("descricaoProblema");
                int gravidadeProblema = rs.getInt("gravidadeProblema");

                Problema problema = new Problema(tipoProblema, descricaoProblema, gravidadeProblema);
                result.add(problema);
            }
            return result;
        }

        @Override
        public void update(Problema problema) throws SQLException {
            String sql = "UPDATE T_VB_PROBLEMA SET descricaoProblema=?, gravidadeProblema=? WHERE tipoProblema=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, problema.descricaoProblema);
            pstmt.setInt(2, problema.gravidadeProblema);
            pstmt.setInt(3, problema.tipoProblema);
            pstmt.executeUpdate();
        }

        @Override
        public void delete(int tipoProblema, String descricaoProblema, int gravidadeProblema) throws SQLException {
            String sql = "DELETE FROM T_VB_PROBLEMA WHERE tipoProblema=? AND descricaoProblema=? AND gravidadeProblema=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, tipoProblema);
            pstmt.setString(2, descricaoProblema);
            pstmt.setInt(3, gravidadeProblema);
            pstmt.executeUpdate();
        }
}
