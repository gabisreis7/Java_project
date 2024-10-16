package org.example.service;

import org.example.dao.ManutencaoDao;
import org.example.entities.Manutencao;

import java.util.List;

public class ManutencaoServiceImpl implements ManutencaoService{


    public ManutencaoServiceImpl(ManutencaoDao manutencaoDao) {
    }

    @Override
    public void agendarManutencao(Manutencao manutencao) {

    }

    @Override
    public List<Manutencao> listarManutencoes() {
        return List.of();
    }

    @Override
    public void atualizarManutencao(Manutencao manutencao) {

    }

    @Override
    public void deletarManutencao(int id) {

    }
}
