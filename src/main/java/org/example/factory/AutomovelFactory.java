package org.example.factory;

import org.example.entities.Automovel;

public class AutomovelFactory {

    public static Automovel createAutomovel(String placaAutomovel, String marcaAutomovel, String modeloAutomovel, Long numeroChassi, Long codigoRenavam, int anoAutomovel, String porteAutomovel){
        return new Automovel(placaAutomovel, marcaAutomovel, modeloAutomovel, numeroChassi, codigoRenavam, anoAutomovel, porteAutomovel);
    }
}
