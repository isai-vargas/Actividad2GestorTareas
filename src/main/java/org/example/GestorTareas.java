package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorTareas {
    private static List<Tarea> tareas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Gestor de Tareas");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Mostrar tareas");
            System.out.println("4. Modificar tarea");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    agregarTarea(descripcion);
                    break;
                case 2:
                    mostrarTareas();
                    System.out.print("Índice de la tarea a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    eliminarTarea(indiceEliminar);
                    break;
                case 3:
                    mostrarTareas();
                    break;
                case 4:
                    mostrarTareas();
                    System.out.print("Índice de la tarea a modificar: ");
                    int indiceModificar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    modificarTarea(indiceModificar, nuevaDescripcion);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
        System.out.println("Tarea agregada.");
    }

    public static void eliminarTarea(int index) {
        if (index >= 0 && index < tareas.size()) {
            tareas.remove(index);
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println(i + ": " + tareas.get(i));
            }
        }
    }

    public static void modificarTarea(int index, String nuevaDescripcion) {
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).setDescripcion(nuevaDescripcion);
            System.out.println("Tarea modificada.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
}
