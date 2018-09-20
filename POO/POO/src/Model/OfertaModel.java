/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author hique
 */
public class OfertaModel implements Serializable {
   
    private String oferta;
    private int cod;
    private float preco;

    public OfertaModel(String oferta, int cod, float preco) {
        this.oferta = oferta;
        this.cod = cod;
        this.preco = preco;
    }
    
  
    
    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
