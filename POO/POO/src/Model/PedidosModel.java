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
public class PedidosModel implements Serializable{
    private int codigo;
    private String status;
    private String formaPagamento;
    private float total;
    private String cpf;
    private String placa;

    public PedidosModel(int codigo, String status, String formaPagamento, float total, String cpf, String placa) {
        this.codigo = codigo;
        this.status = status;
        this.formaPagamento = formaPagamento;
        this.total = total;
        this.cpf = cpf;
        this.placa = placa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
    

   
}
