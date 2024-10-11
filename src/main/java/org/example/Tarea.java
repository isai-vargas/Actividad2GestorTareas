package org.example;

public class Tarea {
    private String descripcion;
    private boolean completada;

    // Constructor
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    // Método para marcar la tarea como completada
    public void marcarComoCompletada() {
        this.completada = true;
    }

    // Método para modificar la descripción de la tarea
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion + (completada ? " (Completada)" : " (Pendiente)");
    }
}
