package org.example.service;

import org.example.dao.AutomovelDao;
import org.example.entities.Automovel;

import java.sql.SQLException;
import java.util.List;

public class AutomovelService  {

    private final AutomovelDao automovelDao;

    private AutomovelService(AutomovelDao automovelDao){
        this.automovelDao = automovelDao;
    }



    public void criarAutomovel(Automovel automovel) {
        validarAutomovel(automovel);
        try {
            automovelDao.create(automovel);
        }catch (SQLException e){
            throw new RuntimeException("Erro ao criar automóvel " + e.getMessage());
        }
    }


    public List<Automovel> listarAutomoveis() {
        try {
            return automovelDao.read();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao listar automóveis " + e.getMessage());
        }
    }


    public void atualizarAutomovel(Automovel automovel) {
        validarAutomovel(automovel);
        try {
            automovelDao.update(automovel);
        } catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar automóvel " + e.getMessage());
        }
    }


    public void deletarAutomovel(String placaAutomovel, String marcaAutomovel, String modeloAutomovel, Long numeroChassi, Long codigoRenavam, int anoAutomovel, String porteAutomovel) {
        try {
            automovelDao.delete(placaAutomovel, marcaAutomovel, modeloAutomovel, numeroChassi, codigoRenavam, anoAutomovel, porteAutomovel);

        } catch (SQLException e){
            throw new RuntimeException("Erro ao deletar automóvel " + e.getMessage());
        }
    }

    public void validarAutomovel(Automovel automovel){
        validarPlaca(automovel.getPlacaAutomovel());
        validarRenavam(automovel.getCodigoRenavam());
    }

    public void validarPlaca(String placaAutomovel){
        if (placaAutomovel.length() != 7){
            throw new IllegalArgumentException("Placa inexistente, deve possuir 7 caracteres");
        }
    }

    public void validarRenavam(Long codigoRenavam){
        String renavamstr = String.valueOf(codigoRenavam);
        if (renavamstr.length() != 11){
            throw new IllegalArgumentException("O código Renavam deve conter 11 dígitos numéricos.");
        }
    }


}
