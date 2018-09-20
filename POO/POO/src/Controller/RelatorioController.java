/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RelatorioVendaDAO;
import Model.RelatorioVendasModel;
import java.util.ArrayList;

/**
 *
 * @author hique
 */
public class RelatorioController {
    
    public ArrayList<RelatorioVendasModel> GetRelatorio() {
        RelatorioVendaDAO p = new RelatorioVendaDAO();
        ArrayList<RelatorioVendasModel> arrayP = new ArrayList<>();
        p.openToRead("Relatorio");
        arrayP = p.retornaArrayRelatorio();
        p.closeAfterRead();
        return arrayP;
    }
    
        public void CadRelatorioDAO(RelatorioVendasModel p) {
        RelatorioVendaDAO pedido = new RelatorioVendaDAO();
        pedido.openToWrite("Relatorio");
        pedido.gravaRelatorio(p);
        pedido.closeAfterWrite();
    }
    
    
}
