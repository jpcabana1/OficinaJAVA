/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CarroModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author hique
 */
public class CadastroEmArquivoDAO {

    protected ObjectInputStream input;
    protected ObjectOutputStream output;

    public void openToRead(String nomeArq) {
        File arquivo = new File(nomeArq);
        if (arquivo.exists() == false){
            return;
        }
        try {
            FileInputStream arq = new FileInputStream(nomeArq);
            input = new ObjectInputStream(arq);
        } catch (IOException ioException) {
            System.err.println("Error ao tentar abrir o arquivo para leitura.");
            System.exit(1);
        }
    }

    public void openToWrite(String nomeArq) {
        File arq = new File(nomeArq);
        if (arq.exists() == false) {
            try {
                FileOutputStream fOut = new FileOutputStream(nomeArq);
                output = new ObjectOutputStream(fOut);
            } catch (IOException ioException) {
                System.err.println("Erro ao tentar abrir o arquivo para gravacao.");
                System.exit(1);
            }
        } else {
            try {
                FileOutputStream fOut = new FileOutputStream(nomeArq, true);
                output = new ObjectOutputStream(fOut) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } catch (IOException ioException) {
                System.err.println("Erro ao tentar abrir o arquivo para gravacao.");
                System.exit(1);
            }
        }
    }

    public void openToReWrite(String nomeArq) {
        File arq = new File(nomeArq);
        if (arq.exists() == false) {
            try {
                FileOutputStream fOut = new FileOutputStream(nomeArq);
                output = new ObjectOutputStream(fOut);
            } catch (IOException ioException) {
                System.err.println("Erro ao tentar abrir o arquivo para gravacao.");
                System.exit(1);
            }
        } else {
            try {
                FileOutputStream fOut = new FileOutputStream(nomeArq);
                output = new ObjectOutputStream(fOut);
            } catch (IOException ioException) {
                System.err.println("Erro ao tentar abrir o arquivo para gravacao.");
                System.exit(1);
            }
        }
    }

    public void closeAfterRead() {
        try {
            if (input != null) {
                input.close();
                input = null;
                System.out.println("Fechou com sucesso!");
            }
        } catch (IOException ioException) {
            System.err.println("ERRO AO FECHAR ARQUIVO!");
            System.exit(1);
        }
    }

    public void closeAfterWrite() {
        try {
            if (output != null) {
                output.close();
                output = null;
                System.out.println("Fechou com sucesso!");
            }
        } catch (IOException ioException) {
            System.err.println("ERRO AO FECHAR ARQUIVO!");
            System.exit(1);
        }
    }

    public void gravaObjeto(CarroModel p) {
        try {
            if (output != null) {
                output.writeObject(p);
                output.flush();// pra gravar <
                System.out.println("Gravacao efetuada com sucesso!");
            }
        } catch (IOException ioException) {
            System.err.println("Error ao gravar");
            System.exit(1);
        }
    }
}
