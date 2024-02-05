
package modelo;

public class NodoCola {
    String nombre;
    int puntuacion;
    NodoCola siguiente;
    
    public NodoCola(String nombre, int puntuacion){
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    
           
}
