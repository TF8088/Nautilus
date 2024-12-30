package org.Nautilus.group1.Class;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.Nautilus.group1.Enums.zonas;
import org.Nautilus.group1.Enums.patentes;

public class barcopatrulha extends embarcacao {
    private List<marinheiro> tripulantes = new ArrayList<>();
    private static final int numeroTripulantesMaximo = 4;
    private static final int numeroTripulantesMinimo = 2;
    private boolean holofote;
    private boolean radar;
    private motor motor;

    public barcopatrulha(String nome, String marca, String modelo, LocalDate dataConstrucao, motor motor, zonas zona) {
        super(nome, marca, modelo, dataConstrucao, motor, zona);
        this.motor = motor;
    }

    /* GET MOTORES - SET MOTORES */
    public motor getMotor() {
        return motor;
    }

    public void setMotor(motor motor) {
        this.motor = motor;
    }

    /* GET TRIPULANTES - ADD TRIPULANTE - REMOVE TRIPULANTE */
    public List<marinheiro> getTripulantes() {
        return tripulantes;
    }

    public void addTripulante(marinheiro tripulante) {
        if (tripulantes.size() < numeroTripulantesMaximo) {
            boolean jaExisteOficial = false;
            for (marinheiro marinheiro : tripulantes) {
                if (marinheiro.getPatente() == patentes.OFICIAL) {
                    jaExisteOficial = true;
                    break;
                }
            }
            if (jaExisteOficial && tripulante.getPatente() == patentes.OFICIAL) {
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

    /* GET HOLOFOTE - SET HOLOFOTE */
    public boolean getHolofote() {
        return holofote;
    }

    public void setHolofote(boolean holofote) {
        this.holofote = holofote;
    }

    /* GET RADAR - SET RADAR */
    public boolean getRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
    }
}
