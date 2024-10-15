package org.example.service;

import org.example.entities.Automovel;

import java.util.List;

public interface AutomovelService {

    void criarAutomovel(Automovel automovel);

    List<Automovel> listarAutomoveis();

    void atualizarAutomovel(Automovel automovel);

    void deletarAutomovel(String placaAutomovel, String marcaAutomovel, String modeloAutomovel, Long numeroChassi, Long codigoRenavam, int anoAutomovel, String porteAutomovel);

}
