/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Gabinator 2.0
 */
public class ItemModel extends OfertaModel implements Serializable {
    
    private int estoque;

    public ItemModel(int cod,int estoque, String oferta , float preco) {
        super(oferta, cod, preco);
        this.estoque = estoque;
    }

   
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
