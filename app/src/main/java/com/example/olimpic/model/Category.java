package com.example.olimpic.model;

public enum Category {
    ONEVSONEMAN(1),
    ONEVSONEWOMAN(2),
    TWOVSTWO(3),
    FIVEVSFIVE(4);
    private final int valor;

    Category(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
