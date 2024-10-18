package org.example.service;

import org.example.dao.ProblemaDao;

public class ProblemaServiceFactory {

    private final ProblemaDao problemaDao;


    public ProblemaServiceFactory(ProblemaDao problemaDao) {
        this.problemaDao = problemaDao;
    }

    public ProblemaService criarProblemaService(){
        return new ProblemaServiceImpl(problemaDao);
    }
}
