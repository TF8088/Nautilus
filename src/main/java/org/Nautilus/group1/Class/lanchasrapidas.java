package org.Nautilus.group1.Class;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.Nautilus.group1.Enums.zonas;
import org.Nautilus.group1.Enums.patentes;

public class lanchasrapidas extends embarcacao {
    private List<marinheiro> tripulantes = new ArrayList<>();
    private static final int numeroTripulantesMaximo = 4;
    private static final int numeroTripulantesMinimo = 4;
    private static final int numeroMotoresMaximo = 4;
    private List<motor> motores = new ArrayList<>();
    private boolean holofote;

    /* CONSTRUTOR */
    public lanchasrapidas(String nome, String marca, String modelo, LocalDate dataConstrucao, motor motor, zonas zona,
            boolean holofote) {
        super(nome, marca, modelo, dataConstrucao, motor, zona);
        this.holofote = holofote;
    }

    /* GET TRIPULANTES - ADD TRIPULANTE - REMOVE TRIPULANTE */
    public List<marinheiro> getTripulantes() {
        return tripulantes;
    }

    public void addTripulante(marinheiro tripulante) {
        if (tripulantes.size() < numeroTripulantesMaximo) {
            boolean jaExisteOficial = false;
            for (marinheiro marinheiro : tripulantes) {
                if (marinheiro.getPatente() == patentes.SARGENTO) {
                    jaExisteOficial = true;
                    break;
                }
            }
            if (jaExisteOficial && tripulante.getPatente() == patentes.SARGENTO) {
                throw new IllegalStateException("Já existe um oficial na tripulação.");
            } else {
                tripulantes.add(tripulante);
            }

        } else {
            throw new IllegalStateException("Número máximo de tripulantes atingido.");
        }
    }

    public void removeTripulante(marinheiro tripulante) {
        if (tripulantes.size() > numeroTripulantesMinimo) {
            tripulantes.remove(tripulante);
        } else {
            throw new IllegalStateException("Número mínimo de tripulantes atingido.");
        }
    }

    /* GET MOTORES - ADD MOTOR - SET MOTORES */
    public List<motor> getMotores() {
        return motores;
    }

    public void addMotor(motor motor) {
        if (motores.size() < numeroMotoresMaximo) {
            motores.add(motor);
        } else {
            throw new IllegalStateException("Número máximo de motores atingido.");
        }
    }

    public void setMotores(List<motor> motores) {
        if (motores.size() <= numeroMotoresMaximo) {
            this.motores = motores;
        } else {
            throw new IllegalStateException("Número máximo de motores atingido.");
        }
    }

    /* GET HOLOFOTE - SET HOLOFOTE */
    public boolean getHolofote() {
        return holofote;
    }

    public void setHolofote(boolean holofote) {
        this.holofote = holofote;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLancha Rápida:\n");
        sb.append("  Nome: ").append(getNome()).append("\n");
        sb.append("  Marca: ").append(getMarca()).append("\n");
        sb.append("  Modelo: ").append(getModelo()).append("\n");
        sb.append("  Data de Construção: ").append(getDataConstrucao()).append("\n");
        sb.append("  Zona: ").append(getZona()).append("\n");
        sb.append("  Tripulantes:\n");
        for (marinheiro tripulante : tripulantes) {
            sb.append("    - ").append(tripulante.toString()).append("\n");
        }
        sb.append("  Motores:\n");
        for (motor motor : motores) {
            sb.append("    - ").append(motor.toString()).append("\n");
        }
        sb.append("  Holofote: ").append(holofote).append("\n");
        return sb.toString();
    }

}