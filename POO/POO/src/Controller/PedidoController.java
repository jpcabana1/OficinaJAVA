/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PedidoDAO;
import Model.PedidosModel;
import java.util.ArrayList;

/**
 *
 * @author hique
 */
public class PedidoController {

    public ArrayList<PedidosModel> GetPedidos() {
        PedidoDAO p = new PedidoDAO();
        ArrayList<PedidosModel> arrayP = new ArrayList<>();
        p.openToRead("Pedido");
        arrayP = p.retornaArrayPedidos();
        p.closeAfterRead();
        return arrayP;
    }

    public void CadPedidoDAO(PedidosModel p) {
        PedidoDAO pedido = new PedidoDAO();
        pedido.openToWrite("Pedido");
        pedido.gravaPedido(p);
        pedido.closeAfterWrite();
    }

    public boolean AttStatus(String placa, String status) {
        ArrayList<PedidosModel> arrayP = new ArrayList<>();
        arrayP = GetPedidos();
        boolean att = false;

        for (int i = 0; i < arrayP.size(); i++) {
            if (arrayP.get(i).getPlaca().compareToIgnoreCase(placa) == 0) {
                arrayP.get(i).setStatus(status);
                att = true;
                break;
            }
        }
        if (att = true) {
            PedidoDAO d = new PedidoDAO();
            d.openToReWrite("Pedido");
            for (int i = 0; i < arrayP.size(); i++) {
                d.gravaPedido(arrayP.get(i));
            }
            d.closeAfterWrite();
        }
        return att;
    }

    public void removerPedido(String placa) {
        ArrayList<PedidosModel> arrayP = new ArrayList<>();
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.openToRead("Pedido");
        arrayP = pedidoDAO.retornaArrayPedidos();
        pedidoDAO.closeAfterRead();

        for (int i = 0; i < arrayP.size(); i++) {
            if (placa.compareToIgnoreCase(arrayP.get(i).getPlaca()) == 0) {
                arrayP.remove(i);
            }
        }
        
            pedidoDAO.openToReWrite("Pedido");
            for (int i = 0; i < arrayP.size(); i++) {
                CadPedidoDAO(arrayP.get(i));
            }
            pedidoDAO.closeAfterWrite();
        }
    }
