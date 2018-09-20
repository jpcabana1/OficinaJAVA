/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ItemDAO;
import Model.ItemModel;
import java.util.ArrayList;

/**
 *
 * @author Gabinator 2.0
 */
public class ItemController {

    public void CadItemDAO(ItemModel i) {
        ItemDAO item = new ItemDAO();
        item.openToWrite("Item");
        item.gravaItem(i);
        item.closeAfterWrite();
    }

    public ArrayList<ItemModel> getItens() {
        ArrayList<ItemModel> i = new ArrayList<>();
        ItemDAO item = new ItemDAO();
        item.openToRead("Item");
        i = item.retornaArrayItem();
        item.closeAfterRead();
        return i;
    }

    public boolean removeItem(int codigo) {
        boolean remove = false;
        ArrayList<ItemModel> arrayI = new ArrayList<>();
        ItemDAO iDAO = new ItemDAO();
        iDAO.openToRead("Item");
        arrayI = iDAO.retornaArrayItem();
        iDAO.closeAfterRead();

        for (int i = 0; i < arrayI.size(); i++) {
            if (codigo == arrayI.get(i).getCod()) {
                arrayI.remove(i);
                remove = true;
            }
        }
        if (remove == true) {
            ItemDAO d = new ItemDAO();
            d.openToReWrite("Item");
            for (int i = 0; i < arrayI.size(); i++) {
                d.gravaItem(arrayI.get(i));
            }
            d.closeAfterWrite();
        }
        return remove;
    }

    public boolean removeEstoque(int codigo) {
        boolean remove = false;
        int qtd;
        ArrayList<ItemModel> arrayI = new ArrayList<>();
        ItemDAO iDAO = new ItemDAO();
        iDAO.openToRead("Item");
        arrayI = iDAO.retornaArrayItem();
        iDAO.closeAfterRead();

        for (int i = 0; i < arrayI.size(); i++) {
            if (codigo == arrayI.get(i).getCod()) {
                qtd = arrayI.get(i).getEstoque();
                qtd--;
                if (qtd >= 0) {
                    arrayI.get(i).setEstoque(qtd);
                    remove = true;
                } else {
                    return remove = false;
                }
            }
        }
        if (remove == true) {
            ItemDAO d = new ItemDAO();
            d.openToReWrite("Item");
            for (int i = 0; i < arrayI.size(); i++) {
                d.gravaItem(arrayI.get(i));
            }
            d.closeAfterWrite();
        }
        return remove;
    }

    public void adicionaEstoque(int codigo, int quantidade) {
        boolean remove = false;
        int qtd;
        ArrayList<ItemModel> arrayI = new ArrayList<>();
        ItemDAO iDAO = new ItemDAO();
        iDAO.openToRead("Item");
        arrayI = iDAO.retornaArrayItem();
        iDAO.closeAfterRead();
        for (int i = 0; i < arrayI.size(); i++) {
            if (codigo == arrayI.get(i).getCod()) {
                qtd = arrayI.get(i).getEstoque();
                qtd = qtd + quantidade;
                arrayI.get(i).setEstoque(qtd);
                break;
            }
        }
        ItemDAO d = new ItemDAO();
        d.openToReWrite("Item");
        for (int i = 0; i < arrayI.size(); i++) {
            d.gravaItem(arrayI.get(i));
        }
        d.closeAfterWrite();
    }
}
