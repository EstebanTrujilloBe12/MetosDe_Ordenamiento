package org.example.busquedas;

public class ResultadoBusqueda {
    private final boolean encontrado;
    private final int posicion;
    private final int comparaciones;

    public ResultadoBusqueda(boolean encontrado, int posicion, int comparaciones) {
        this.encontrado = encontrado;
        this.posicion = posicion;
        this.comparaciones = comparaciones;
    }

    public boolean isEncontrado() {
        return encontrado;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getComparaciones() {
        return comparaciones;
    }
}
