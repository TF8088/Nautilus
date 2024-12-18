package org.Nautilus.group1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.stream.Collectors;

public class marinheiro implements Comparable<marinheiro>{
    private static int nextId = 1;
    private final int id;
    private String nome;
    private LocalDate dataNascimento;
    private patentes patente;

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

        if (dataNascimento == null) {
            throw new IllegalStateException("Data de nascimento não definida para validar a idade.");
        }

        int idadeMinima = 35;

        if (calcularIdade(dataNascimento) < idadeMinima) {
            throw new IllegalArgumentException(
                    "Idade insuficiente para obter a patente " + patente + ". Idade mínima: " + idadeMinima + " anos.");
        }

        this.patente = patente;
    }

    /* METODS */
    private int calcularIdade(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataNascimento, hoje).getYears();
    }
    
    @Override
    public int compareTo(Marinheiro outroMarinheiro) {
        return Integer.compare(this.id, outroMarinheiro.id); //ordem crescente de id
    }
}
