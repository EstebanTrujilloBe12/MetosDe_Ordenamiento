package org.example.busquedas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class BusquedasApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BusquedasApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Generar arreglo aleatorio
        int[] arreglo = generarArregloAleatorio(20);

        // Mostrar arreglo original
        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(arreglo));

        // Ordenar el arreglo
        OrdenamientoInsercion ordenamiento = new OrdenamientoInsercion();
        int[] arregloOrdenado = arreglo.clone();
        ordenamiento.ordenar(arregloOrdenado);

        System.out.println("\nArreglo ordenado:");
        System.out.println(Arrays.toString(arregloOrdenado));

        // Solicitar número a buscar
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el número a buscar: ");
        int numeroBuscar = scanner.nextInt();

        // Realizar búsqueda lineal
        BusquedaLineal busquedaLineal = new BusquedaLineal();
        ResultadoBusqueda resultadoLineal = busquedaLineal.buscar(arregloOrdenado, numeroBuscar);

        // Realizar búsqueda binaria
        BusquedaBinaria busquedaBinaria = new BusquedaBinaria();
        ResultadoBusqueda resultadoBinaria = busquedaBinaria.buscar(arregloOrdenado, numeroBuscar);

        // Mostrar resultados
        System.out.println("\nResultados de la búsqueda:");
        System.out.println("\nBúsqueda Lineal:");
        mostrarResultado(resultadoLineal);

        System.out.println("\nBúsqueda Binaria:");
        mostrarResultado(resultadoBinaria);

        // Comparar métodos
        System.out.println("\nComparación de métodos:");
        System.out.println("La búsqueda lineal realizó " + resultadoLineal.getComparaciones() + " comparaciones");
        System.out.println("La búsqueda binaria realizó " + resultadoBinaria.getComparaciones() + " comparaciones");

        String masEficiente = resultadoLineal.getComparaciones() < resultadoBinaria.getComparaciones() ?
            "lineal" : "binaria";
        System.out.println("Para este caso, la búsqueda " + masEficiente + " fue más eficiente.");
    }

    private int[] generarArregloAleatorio(int tamano) {
        Random random = new Random();
        int[] arreglo = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = random.nextInt(100) + 1;
        }
        return arreglo;
    }

    private void mostrarResultado(ResultadoBusqueda resultado) {
        if (resultado.isEncontrado()) {
            System.out.println("Número encontrado en la posición: " + resultado.getPosicion());
        } else {
            System.out.println("Número no encontrado");
        }
        System.out.println("Número de comparaciones realizadas: " + resultado.getComparaciones());
    }
}
