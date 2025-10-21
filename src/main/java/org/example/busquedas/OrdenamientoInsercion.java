package org.example.busquedas;

public class OrdenamientoInsercion {
    public void ordenar(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int clave = arreglo[i];
            int j = i - 1;

            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = clave;
        }
    }
}
