package org.example.service;

import org.example.dao.ManutencaoDao;

public class ManutencaoServiceFactory {

    private final ManutencaoDao manutencaoDao;


    public ManutencaoServiceFactory(ManutencaoDao manutencaoDao) {
        this.manutencaoDao = manutencaoDao;
    }

    public ManutencaoService criarManutencaoService(){
        return new ManutencaoServiceImpl(manutencaoDao);
    }
}
