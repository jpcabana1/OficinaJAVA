/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ItemModel;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hique
 */
public class ItemDAO extends CadastroEmArquivoDAO {
    
    public void gravaItem(ItemModel p) {
        try {       
            if (output != null) {
                System.out.println("entrou");
                output.writeObject(p);
                output.flush();// pra gravar <
                System.out.println("Gravacao efetuada com sucesso!");
            }
        } catch (IOException ioException) {
            System.err.println("Error ao gravar");
            System.exit(1);
        }
    }

    public ArrayList<ItemModel> retornaArrayItem() {
        ItemModel item;
        ArrayList<ItemModel> array = new ArrayList<>();
        if (input != null) {
            try {
                while (true) {
                    item = (ItemModel) input.readObject();
                    array.add(item);
                }
            } catch (EOFException eofException) {
            } catch (ClassNotFoundException classNotFoundException) {
                System.err.println("Classe nao encontrada");
                System.exit(1);
            } catch (IOException ioException) {
                System.err.println("Erro ao tentar ler o arquivo");
                System.exit(1);
            }
        }
        return array;
    }
}
