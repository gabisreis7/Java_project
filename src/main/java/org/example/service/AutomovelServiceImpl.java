package org.example.service;

import org.example.dao.AutomovelDao;
import org.example.entities.Automovel;

import java.sql.SQLException;
import java.util.List;

public class AutomovelServiceImpl implements AutomovelService{

    private final AutomovelDao automovelDao;

    public AutomovelServiceImpl(AutomovelDao automovelDao){
        this.automovelDao = automovelDao;
    }


    @Override
    public void salvarAutomovel(Automovel automovel) throws SQLException {
        automovelDao.create(automovel);
    }

    @Override
    public List<Automovel> listarAutomoveis() throws SQLException {
        return this.automovelDao.read();
    }

    @Override
    public void atualizarAutomovel(Automovel automovel) throws SQLException {
        Automovel automovelAtualizado = this.automovelDao.findId(automovel.getId());
        automovelAtualizado.setPlacaAutomovel(automovel.getPlacaAutomovel());
        this.automovelDao.update(automovelAtualizado);
    }

    @Override
    public void deletarAutomovel(int id) throws SQLException {
        Automovel automovelAchado = automovelDao.findId(id);
        automovelDao.delete(automovelAchado.getId());

    }
}
