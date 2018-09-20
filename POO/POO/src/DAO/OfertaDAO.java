/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.OfertaModel;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hique
 */
public class OfertaDAO extends CadastroEmArquivoDAO {

    public void gravaOferta(OfertaModel p) {
        try {
            if (output != null) {
                output.writeObject(p);
                output.flush();// pra gravar <
            }
        } catch (IOException ioException) {
            System.err.println("Error ao gravar");
            System.exit(1);
        }
    }

    public ArrayList<OfertaModel> retornaArrayOferta() {
        OfertaModel oferta;
        ArrayList<OfertaModel> array = new ArrayList();
        if (input != null) {
            try {
                while (true) {
                    oferta = (OfertaModel) input.readObject();
                    array.add(oferta);
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
