package org.example.busquedas;

public class BusquedaLineal {
    private int comparaciones;

    public BusquedaLineal() {
        this.comparaciones = 0;
    }

    public ResultadoBusqueda buscar(int[] arreglo, int numero) {
        this.comparaciones = 0;
        for (int i = 0; i < arreglo.length; i++) {
            comparaciones++;
            if (arreglo[i] == numero) {
                return new ResultadoBusqueda(true, i, comparaciones);
            }
        }
        return new ResultadoBusqueda(false, -1, comparaciones);
    }
}
