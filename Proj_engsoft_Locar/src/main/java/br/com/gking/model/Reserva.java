/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gking.model;

import java.sql.Date;

/**
 *
 * @author Gking
 */
public class Reserva {
    private Date data_locacao;
    private long cpf;
    private String placa;

    public Reserva(Date data_locacao, long cpf, String placa) {
        this.data_locacao = data_locacao;
        this.cpf = cpf;
        this.placa = placa;
    }

    public Date getData_locacao() {
        return data_locacao;
    }

    public long getCpf() {
        return cpf;
    }

    public String getPlaca() {
        return placa;
    }
    
    public void setData_locacao(Date data_locacao) {
        this.data_locacao = data_locacao;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
