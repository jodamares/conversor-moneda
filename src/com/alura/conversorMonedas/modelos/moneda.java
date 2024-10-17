package com.alura.conversorMonedas.modelos;

import com.google.gson.annotations.SerializedName;

public class moneda {
    @SerializedName("base_code")
    private String monedaB; /* Moneda base */
    @SerializedName("target_code")
    private String monedaC; /* Moneda a convertir */
    @SerializedName("conversion_rate")
    private double valor; /* Lee el valor a convertir */

    /* Metodos get y set */
    public String getMonedaB() {
        return monedaB;
    }
    public void setMonedaB(String monedaB) {
        this.monedaB = monedaB;
    }

    public String getMonedaC() {
        return monedaC;
    }
    public void setMonedaC(String monedaC) {
        this.monedaC = monedaC;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Moneda base='" + monedaB + '\'' +
                ", Moneda a convertir='" + monedaC + '\'' +
                ", Valor de conversión=" + valor;
    }
}
