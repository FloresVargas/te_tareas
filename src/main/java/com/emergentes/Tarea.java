
package com.emergentes;

public class Tarea {
     private int Id;
     private String tarea;
    private String completado;

    public Tarea() {
    }

    public Tarea(int Id, String tarea, String completado) {
        this.Id = Id;
        this.tarea = tarea;
        this.completado = completado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getCompletado() {
        return completado;
    }

    public void setCompletado(String completado) {
        this.completado = completado;
    }
    
}
   