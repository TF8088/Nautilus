package org.Nautilus.group1.Class;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import org.Nautilus.group1.Enums.patentes;

public class marinheiro implements Comparable<marinheiro> {
    private static int nextId = 1;
    private final int id;
    private String nome;
    private LocalDate dataNascimento;
    private patentes patente;
    
    /* CONSTRUTOR */
    public marinheiro(String Nome, LocalDate DataNascimento, patentes patente) {
        this.id = nextId++;
        this.nome = Nome;
        this.dataNascimento = DataNascimento;
        this.patente = patente;
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

    /* GET DATANASCIMENTO - SET DATANASCIMENTO */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /* GET PATENTE - SET PATENTE */
    public patentes getPatente() {
        return patente;
    }

    public void setPatente(patentes patente) {
        Objects.requireNonNull(patente, "Patente não pode ser nula!");
        
        // Valida a idade mínima para a patente
        if (dataNascimento == null) {
            throw new IllegalStateException("Data de nascimento não definida para validar a idade.");
        }

        int idadeMinima = 35;

        // Valida a idade mínima para a patente
        if (calcularIdade(dataNascimento) < idadeMinima) {
            throw new IllegalArgumentException(
                    "Idade insuficiente para obter a patente " + patente + ". Idade mínima: " + idadeMinima + " anos.");
        }

        this.patente = patente;
    }

    /* METODS */
    private int calcularIdade(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataNascimento, hoje).getYears(); // Calcula a diferença entre as datas
    }

    public String toString()    {
        return "Marinheiro: " + nome + " - " + dataNascimento + " - " + patente;
    }

    @Override
    public int compareTo(marinheiro arg0) {
        return Integer.compare(this.id, arg0.id); // Ordena por ID
    }
}
