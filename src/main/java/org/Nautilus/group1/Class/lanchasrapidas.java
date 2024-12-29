package org.Nautilus.group1.Class;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.Nautilus.group1.Enums.zonas;
import org.Nautilus.group1.Enums.patentes;

public class lanchasrapidas extends embarcacao {
    private List<motor> motores;
    private int numeroTripulantes;
    private static final int numeroTripulantesMaximo = 4;
    private boolean holofote;
    private List<marinheiro> tripulantes = new ArrayList<>();

    /* CONSTRUTOR */
    public lanchasrapidas(String nome, String marca, String modelo, LocalDate dataConstrucao, List<motor> motores, zonas zona, int numeroTripulantes, boolean holofote) {
        super(nome, marca, modelo, dataConstrucao, motores.get(0), zona);
        this.motores = motores;
        this.numeroTripulantes = numeroTripulantes;
        this.holofote = holofote;

        if (motores.size() < 2 || motores.size() > 4) {
            throw new IllegalArgumentException("Número de motores inválido. Deve ter entre 2 e 4 motores.");
        }
        if (numeroTripulantes < 2 || numeroTripulantes > 4) {
            throw new IllegalArgumentException("Número de tripulantes inválido. Deve ter entre 2 e 4 tripulantes.");
        }
    }

    /* GET MOTORES */
    public List<motor> getMotores() {
        return motores;
    }

    /* GET NUMEROTRIPULANTES  */
    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }

    /* GET HOLOFOTE - SET HOLOFOTE */
    public boolean isHolofote() {
        return holofote;
    }

    public void setHolofote(boolean holofote) {
        this.holofote = holofote;
    }

    /* METODS */
    public void adicionarMarinheiro(marinheiro marinheiro) {
        if (tripulantes.size() >= numeroTripulantesMaximo) {
            throw new IllegalArgumentException("Número máximo de tripulantes atingido.");
        }

        if (marinheiro.getPatente() == patentes.SARGENTO) {
            for (marinheiro trip : tripulantes) {
                if (trip.getPatente() == patentes.SARGENTO) {
                    throw new IllegalArgumentException("Já existe um sargento a bordo.");
                }
            }
        }

        tripulantes.add(marinheiro);
    }

    public void removerMarinheiro(marinheiro marinheiro) {
        tripulantes.remove(marinheiro);
    }

    @Override
    public String toString() {
        return "Lancha Rápida: " + super.toString() + ", Número de Motores: " + motores.size() + ", Número de Tripulantes: " + numeroTripulantes + ", Holofote: " + holofote;
    }
}