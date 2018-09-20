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
public class CarroModel implements Serializable {
    private String modelo;
    private String cor;
    private String Descricao;
    private String placa;
    private String RG;

    public CarroModel(String modelo, String cor, String Descricao, String placa, String RG) {
        this.modelo = modelo;
        this.cor = cor;
        this.Descricao = Descricao;
        this.placa = placa;
        this.RG = RG;
    }

    public CarroModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
    
    @Override
    public String toString() {
        return "Carro{" + "modelo=" + modelo + ", cor=" + cor + ", Descricao=" + Descricao + ", placa=" + placa + ", RG=" + RG + '}';
    }

  
    
}
