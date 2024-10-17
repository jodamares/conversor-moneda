package com.alura.conversorMonedas.modelos;

public class Conversor {

    /*Metodo para realizar la conversión de moneda*/
    public double convertir(moneda miMoneda, int cantidad) {
        return miMoneda.getValor() * cantidad; // Multiplicamos la tasa de cambio por la cantidad
    }
}
