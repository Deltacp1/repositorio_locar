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
    private Date dataRetirada;
    private Date dataRetorno;
    private long cpf;
    private String placa;

    public Reserva(long cpf, String placa, Date dataRetirada, Date dataRetorno) {
        this.dataRetirada = dataRetirada;
        this.dataRetorno = dataRetorno;
        this.cpf = cpf;
        this.placa = placa;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public long getCpf() {
        return cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
