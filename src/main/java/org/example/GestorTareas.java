package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorTareas {
    private static List<Tarea> tareas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = solicitarIndice(scanner, "Elige una opcion: ");

            switch (opcion) {
                case 1:
                    System.out.print("Descripcion de la tarea: ");
                    String descripcion = scanner.nextLine();
                    Prioridad prioridad = solicitarPrioridad(scanner);
                    agregarTarea(descripcion, prioridad);
                    break;
                case 2:
                    mostrarTareas();
                    int indiceEliminar = solicitarIndice(scanner, "Elige el numero de la tarea a eliminar: ");
                    eliminarTarea(indiceEliminar);
                    break;
                case 3:
                    mostrarTareas();
                    break;
                case 4:
                    mostrarTareas();
                    int indiceModificar = solicitarIndice(scanner, "Elige el numero de la tarea a modificar: ");
                    modificarTarea(indiceModificar, scanner);
                    break;
                case 5:
                    mostrarTareasPorPrioridad();
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del gestor de tareas.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nGestor de Tareas");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Eliminar tarea");
        System.out.println("3. Mostrar tareas");
        System.out.println("4. Modificar tarea");
        System.out.println("5. Mostrar tareas por prioridad");
        System.out.println("6. Salir");
    }

    public static int solicitarIndice(Scanner scanner, String mensaje) {
        int indice = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                indice = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un numero valido.");
            }
        }
        return indice;
    }

    public static Prioridad solicitarPrioridad(Scanner scanner) {
        System.out.println("Prioridad de la tarea (1: Baja, 2: Media, 3: Alta): ");
        int opcion = solicitarIndice(scanner, "Elige una opcion de prioridad: ");
        switch (opcion) {
            case 1:
                return Prioridad.BAJA;
            case 2:
                return Prioridad.MEDIA;
            case 3:
                return Prioridad.ALTA;
            default:
                System.out.println("Prioridad no valida. Se asignara prioridad Baja.");
                return Prioridad.BAJA;
        }
    }

    public static void agregarTarea(String descripcion, Prioridad prioridad) {
        tareas.add(new Tarea(descripcion, prioridad));
        System.out.println("Tarea agregada con prioridad " + prioridad + ".");
    }

    public static void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Indice no valido.");
        }
    }

    public static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println(i + ". " + tareas.get(i));
            }
        }
    }

    public static void modificarTarea(int indice, Scanner scanner) {
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            System.out.print("Nueva descripcion de la tarea: ");
            String nuevaDescripcion = scanner.nextLine();
            Prioridad nuevaPrioridad = solicitarPrioridad(scanner);
            tarea.setPrioridad(nuevaPrioridad);
            System.out.println("Tarea modificada.");
        } else {
            System.out.println("Indice no valido.");
        }
    }

    public static void mostrarTareasPorPrioridad() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            tareas.stream()
                    .sorted((t1, t2) -> t2.getPrioridad().compareTo(t1.getPrioridad()))
                    .forEach(System.out::println);
        }
    }
}