/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author zaqui
 */
public class Registros {

    private NodoCola inicio;
    private NodoCola finalCola;
    String cola = "";

    public Registros() {
        inicio = null;
        finalCola = null;

    }

    public boolean esVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(String nombre, int variable) {
        NodoCola nodo = new NodoCola(nombre, variable);

        if (finalCola == null) {
            inicio = nodo;
            finalCola = nodo;
        } else {
            finalCola.siguiente = nodo;
            finalCola = nodo;

        }
    }

    public void remover() {
        if (inicio != null) {
            inicio = inicio.siguiente;
            if (inicio == null) {
                finalCola = null;
            }
        }

    }

    public String imprimir() {
        NodoCola auxiliar = inicio;
        String cadena = "";
        while (auxiliar != null) {
            cadena += "Jugador: " + auxiliar.nombre + "   movimientos: " + auxiliar.puntuacion + "\n";
            auxiliar = auxiliar.getSiguiente();
        }
        return cadena;
    }
    public void ordenarNombres(){
        boolean intercambiar;
        do {
            intercambiar = false;
            NodoCola auxiliar = inicio;
            NodoCola auxiliar2 = inicio.siguiente;
            while(auxiliar2 != null){
                if (auxiliar.nombre.compareTo(auxiliar2.nombre)>0) {
                    String tempNombre= auxiliar.nombre;
                    int tempPuntos = auxiliar.puntuacion;
                    auxiliar.nombre = auxiliar2.nombre;
                    auxiliar.puntuacion = auxiliar2.puntuacion;
                    auxiliar2.nombre =tempNombre;
                    auxiliar2.puntuacion = tempPuntos;
                    intercambiar = true;
                    
                }
                auxiliar= auxiliar2;
                auxiliar2 = auxiliar2.siguiente;
            }
        } while (intercambiar);
    }
    public void ordenarPuntos(){
        boolean intercambiar;
        do {
            intercambiar = false;
            NodoCola auxiliar = inicio;
            NodoCola auxiliar2 = inicio.siguiente;
            while(auxiliar2 != null){
                if (auxiliar.puntuacion > auxiliar2.puntuacion) {
                    String tempNombre= auxiliar.nombre;
                    int tempPuntos = auxiliar.puntuacion;
                    auxiliar.nombre = auxiliar2.nombre;
                    auxiliar.puntuacion = auxiliar2.puntuacion;
                    auxiliar2.nombre =tempNombre;
                    auxiliar2.puntuacion = tempPuntos;
                    intercambiar = true;
                    
                }
                auxiliar= auxiliar2;
                auxiliar2 = auxiliar2.siguiente;
            }
        } while (intercambiar);
    }
}
