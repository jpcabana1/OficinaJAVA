/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OfertaDAO;
import Model.OfertaModel;
import java.util.ArrayList;

/**
 *
 * @author hique
 */
public class OfertaController {

    public void gerarOfertaDAO(OfertaModel o) {
        OfertaDAO oferta = new OfertaDAO();
        oferta.openToWrite("Oferta");
        oferta.gravaOferta(o);
        oferta.closeAfterWrite();
    }

    public ArrayList<OfertaModel> getOferta() {
        ArrayList<OfertaModel> o = new ArrayList<>();
        OfertaDAO cliente = new OfertaDAO();
        cliente.openToRead("Oferta");
        o = cliente.retornaArrayOferta();
        cliente.closeAfterRead();
        return o;
    }

    public void removeOFertaCod(int codigo) {
        boolean remove = false;
        ArrayList<OfertaModel> c = new ArrayList<>();
        OfertaDAO oferta = new OfertaDAO();
        oferta.openToRead("Oferta");
        c = oferta.retornaArrayOferta();
        oferta.closeAfterRead();

        for (int i = 0; i < c.size(); i++) {
            if (codigo == c.get(i).getCod()) {
                c.remove(i);
                remove = true;
            }
        }
        if (remove == true) {
            OfertaDAO d = new OfertaDAO();
            d.openToReWrite("Oferta");
            for (int i = 0; i < c.size(); i++) {
                d.gravaOferta(c.get(i));
            }
            d.closeAfterWrite();
        }
    }
}
