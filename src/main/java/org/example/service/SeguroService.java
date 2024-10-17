package org.example.service;

import org.example.entities.Seguro;

import java.util.List;

public interface SeguroService {

    void cadastrarSeguro(Seguro seguro);

    List<Seguro> listarSeguros();

    void atualizarSeguro(Seguro seguro);

    void deletarSeguro(int id);
}
