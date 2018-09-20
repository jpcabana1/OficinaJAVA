/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PedidosModel;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hique
 */
public class PedidoDAO extends CadastroEmArquivoDAO {

    public void gravaPedido(PedidosModel p) {
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

    public ArrayList<PedidosModel> retornaArrayPedidos() {
        PedidosModel pedido;
        ArrayList<PedidosModel> array = new ArrayList();
        if (input != null) {
            try {
                while (true) {
                    pedido = (PedidosModel) input.readObject();
                    array.add(pedido);
                }
            } catch (EOFException eofException) {
                System.out.println("Fim de arquivo");
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
