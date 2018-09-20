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
public class RelatorioVendasModel implements Serializable{
    private float valor;
    private String Status;
    private String reason;

    public RelatorioVendasModel(float valor, String Status, String reason) {
        this.valor = valor;
        this.Status = Status;
        this.reason = reason;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}
