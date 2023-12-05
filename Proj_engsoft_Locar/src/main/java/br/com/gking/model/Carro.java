/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gking.model;

/**
 *
 * @author Gking
 */
public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private int quilometragem;
    private String categoria;
    private boolean disponibilidade;
    
    public Carro(String placa, String marca, String modelo, int ano, String cor, int quilometragem, String categoria, boolean disponibilidade) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.categoria = categoria;
        this.disponibilidade = disponibilidade;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}