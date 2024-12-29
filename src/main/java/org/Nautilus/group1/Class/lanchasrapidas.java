package org.Nautilus.group1.Class;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.Nautilus.group1.Enums.zonas;
import org.Nautilus.group1.Enums.patentes;

public class lanchasrapidas extends embarcacao {
    private List<marinheiro> tripulantes = new ArrayList<>();
    private static final int numeroTripulantesMaximo = 4;
    private static final int numeroMotoresMaximo = 4;
    private List<motor> motores;
    private boolean holofote;

    /* CONSTRUTOR */
    public lanchasrapidas(String nome, String marca, String modelo, LocalDate dataConstrucao, motor motor, zonas zona,
            boolean holofote) {
        super(nome, marca, modelo, dataConstrucao, motor, zona);
        this.holofote = holofote;
        this.motores = new ArrayList<>();
    }

    /* GET TRIPULANTES - ADD TRIPULANTE */
    public List<marinheiro> getTripulantes() {
        return tripulantes;
    }

    public void addTripulante(marinheiro tripulante) {
        if (tripulantes.size() < numeroTripulantesMaximo) {
            if (tripulante.getPatente() == patentes.SARGENTO) {
                tripulantes.add(tripulante);
            } else {
                throw new IllegalStateException("Apenas o capitão pode ser adicionado como tripulante.");
            }
            tripulantes.add(tripulante);
        } else {
            throw new IllegalStateException("Número máximo de tripulantes atingido.");
        }
    }

    /* GET MOTORES - SET MOTORES */
    public List<motor> getMotores() {
        return motores;
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

}