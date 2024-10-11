package org.example;

public class Tarea {
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;

    public Tarea(String descripcion, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.completada = false;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarComoCompletada() {
        this.completada = true;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return descripcion + " (Prioridad: " + prioridad + ") " + (completada ? "(Completada)" : "(Pendiente)");
    }
}
