package org.example.service;

import org.example.dao.ManutencaoDao;
import org.example.entities.Manutencao;

import java.sql.SQLException;
import java.util.List;

public class ManutencaoServiceImpl implements ManutencaoService{

    private final ManutencaoDao manutencaoDao;

    public ManutencaoServiceImpl(ManutencaoDao manutencaoDao) {
        this.manutencaoDao = manutencaoDao;
    }

    @Override
    public void agendarManutencao(Manutencao manutencao) throws Exception {
        manutencao.validarAgendamento();
        this.manutencaoDao.create(manutencao);
    }

    @Override
    public List<Manutencao> listarManutencoes() throws SQLException {
        return this.manutencaoDao.read();
    }

    @Override
    public void atualizarManutencao(Manutencao manutencao) throws SQLException {
        Manutencao manutencaoAtualizada = this.manutencaoDao.findId(manutencao.getId());
        this.manutencaoDao.update(manutencaoAtualizada);


    }

    @Override
    public void deletarManutencao(int id) throws SQLException {
        Manutencao manutencaoAchada = manutencaoDao.findId(id);
        manutencaoDao.delete(manutencaoAchada.getId());
    }
}
