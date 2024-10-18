package org.example.service;

import org.example.dao.SeguroDao;
import org.example.entities.Seguro;

import java.sql.SQLException;
import java.util.List;

public class SeguroServiceImpl implements SeguroService{

    private final SeguroDao seguroDao;

    public SeguroServiceImpl(SeguroDao seguroDao) {
        this.seguroDao = seguroDao;
    }


    @Override
    public void cadastrarSeguro(Seguro seguro) throws SQLException {
        this.seguroDao.create(seguro);
    }

    @Override
    public List<Seguro> listarSeguros() throws SQLException {
        return this.seguroDao.read();
    }

    @Override
    public void atualizarSeguro(Seguro seguro) throws SQLException {
        Seguro seguroAtualizado = this.seguroDao.findId(seguro.getId());
        seguroAtualizado.setNumeroApolice(seguro.getNumeroApolice());
        seguroAtualizado.setVigencia(seguro.getVigencia());
        this.seguroDao.update(seguroAtualizado);
    }

    @Override
    public void deletarSeguro(int id) throws SQLException {
        Seguro seguroAchado = seguroDao.findId(id);
        seguroDao.delete(seguroAchado.getId());

    }
}
