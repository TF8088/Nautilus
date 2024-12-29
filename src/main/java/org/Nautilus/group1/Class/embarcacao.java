package org.Nautilus.group1.Class;

import java.time.LocalDate;
import java.time.Period;

import org.Nautilus.group1.Enums.zonas;

public class embarcacao {
    private static int nextId = 1;
    private final int id;
    private String nome;
    private String marca;
    private String modelo;
    private LocalDate dataConstrucao;
    private motor motor;
    private zonas zona;
    private int totalEmbarcacoes;

    /* CONSTRUTOR */
    public embarcacao(String nome, String marca, String modelo, LocalDate dataConstrucao, motor motor, zonas zona) {
        this.id = nextId++;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.dataConstrucao = dataConstrucao;
        this.motor = motor;
        this.zona = zona;
        this.totalEmbarcacoes++;
    }
    
    /* GET ID */
    public int getId() {
        return id;
    }
    
    /* GET NOME - SET NOME */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /* GET MARCA - SET MARCA */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /* GET MODELO - SET MODELO */
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /* GET DATACONSTRUCAO - SET DATACONSTRUCAO */
    public LocalDate getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(LocalDate dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    /* GET MOTOR - SET MOTOR */
    public motor getMotor() {
        return motor;
    }

    public void setMotor(motor motor) {
        this.motor = motor;
    }

    /* GET ZONA - SET ZONA */
    public zonas getZona() {
        return zona;
    }

    public void setZona(zonas zona) {
        this.zona = zona;
    }

    /* GET TOTALEMBARCACOES - SET TOTALEMBARCACOES */
    public int getTotalEmbarcacoes() {
        return totalEmbarcacoes;
    }

    public void setTotalEmbarcacoes(int totalEmbarcacoes) {
        this.totalEmbarcacoes = totalEmbarcacoes;
    }

    /* METODS */
    public void addEmbarcacao() {
        this.totalEmbarcacoes++; // Adiciona uma embarcação
    }

    public void removeEmbarcacao() {
        this.totalEmbarcacoes--; // Remove uma embarcação
    }

    public int calcularIdade() {
        return Period.between(dataConstrucao, LocalDate.now()).getYears(); // Calcula a idade da embarcação
    }
    
    public String toString() {
        return "Embarcação: " + nome + "\nMarca: " + marca + "\nModelo: " + modelo + "\nData de Construção: "
                + dataConstrucao + "\nMotor: " + motor + "\nZona: " + zona + "\nTotal de Embarcações: "
                + totalEmbarcacoes;
    }
}
