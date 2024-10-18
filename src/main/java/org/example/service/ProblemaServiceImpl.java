package org.example.service;

import org.example.dao.ProblemaDao;
import org.example.entities.Problema;

import java.sql.SQLException;
import java.util.List;

public class ProblemaServiceImpl implements ProblemaService{

    private final ProblemaDao problemaDao;

    public ProblemaServiceImpl(ProblemaDao problemaDao) {
        this.problemaDao = problemaDao;
    }

    @Override
    public void cadastrarProblema(Problema problema) throws SQLException {
        this.problemaDao.create(problema);
    }

    @Override
    public List<Problema> listarProblemas() throws SQLException {
        return this.problemaDao.read();
    }

    @Override
    public void atualizarProblema(Problema problema) throws Exception {
        Problema problemaAtualizado = this.problemaDao.findId(problema.getId());
        problemaAtualizado.setTipoProblema(problema.getTipoProblema());
        problemaAtualizado.setDescricaoProblema(problema.getDescricaoProblema());
        problemaAtualizado.setGravidadeProblema(problema.getGravidadeProblema());
        this.problemaDao.update(problemaAtualizado);
    }

    @Override
    public void deletarProblema(int id) throws SQLException {
        Problema problemaAchado = problemaDao.findId(id);
        problemaDao.delete(problemaAchado.getId());
    }
}
