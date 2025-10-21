package org.example.busquedas;

public class BusquedaBinaria {
    private int comparaciones;

    public BusquedaBinaria() {
        this.comparaciones = 0;
    }

    public ResultadoBusqueda buscar(int[] arreglo, int numero) {
        this.comparaciones = 0;
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            comparaciones++;

            if (arreglo[medio] == numero) {
                return new ResultadoBusqueda(wtrue, medio, comparaciones);
            }

            if (arreglo[medio] < numero) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return new ResultadoBusqueda(false, -1, comparaciones);
    }
}
