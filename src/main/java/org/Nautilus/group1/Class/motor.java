package org.Nautilus.group1.Class;

import org.Nautilus.group1.Enums.combustivel;

public class motor {
    private combustivel tipoCombustivel;
    private int cilindrada;
    private int potencia;
    
    /* CONSTRUTOR */
    public motor(combustivel tipoCombustivel, int cilindrada, int potencia) {
        this.tipoCombustivel = tipoCombustivel;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
    }
    
    /* GET TIPOCOMBUSTIVEL - SET TIPOCOMBUSTIVEL */
    public combustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(combustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    /* GET CILINDRADA - SET CILINDRADA */
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /* GET POTENCIA - SET POTENCIA */
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String toString() {
        return "Motor [tipoCombustivel=" + tipoCombustivel + ", cilindrada=" + cilindrada + ", potencia=" + potencia + "]";
    }
}

