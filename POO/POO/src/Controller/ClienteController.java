/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import Model.ClienteModel;
import java.util.ArrayList;

/**
 *
 * @author Gabinator 2.0
 */
public class ClienteController {
    public void cadClienteDAO (ClienteModel c){
        ClienteDAO relatorio = new ClienteDAO();
        relatorio.openToWrite("Cliente");
        relatorio.gravaCliente(c);
        relatorio.closeAfterWrite();
    }
    
     public ArrayList<ClienteModel> getCliente(){
        ArrayList<ClienteModel> c = new ArrayList<>();
        ClienteDAO cliente = new ClienteDAO();
        cliente.openToRead("Cliente");
        c = cliente.retornaArrayCliente();
        cliente.closeAfterRead();
        return c;
    }
     
     public boolean removeCliente (String rg){
        boolean remove = false;
        ArrayList<ClienteModel> c = new ArrayList<>();
        ClienteDAO cliente = new ClienteDAO();
        cliente.openToRead("Cliente");
        c = cliente.retornaArrayCliente();
        cliente.closeAfterRead();
        for (int i = 0; i < c.size(); i++) {
            if(rg.compareToIgnoreCase(c.get(i).getRg()) == 0){
                c.remove(i);
                remove = true;
            }
        }
        if (remove == true){
            ClienteDAO d = new ClienteDAO();
            CarroController carroC = new CarroController();
            d.openToReWrite("Cliente");
            for (int i = 0; i < c.size(); i++) {
                cadClienteDAO(c.get(i));
            }
            d.closeAfterWrite();
            
            carroC.removeCarroRG(rg);
            
        }
        return remove;
    }
}
