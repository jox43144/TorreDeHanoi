/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author zaqui
 */
public class Torres {

    private NodoPila inicio;
    private int tamano = 0;

    public int getTamano() {
        return tamano;
    }

    public NodoPila getInicio() {
        return inicio;
    }

    public boolean esVacia() {
        return this.inicio == null;
    }

    public void apilar(NodoPila disco) {
        if (this.esVacia()) {
            this.inicio = disco;
        } else {
            disco.setSiguiente(this.inicio);
            this.inicio = disco;
        }
        this.tamano++;
    }

    public void remover() {
        if (this.esVacia()) {
            System.out.println("La pila está vacia");
        } else {
            if (this.inicio.getSiguiente() != null) {
                this.inicio = this.inicio.getSiguiente();

            } else {
                this.inicio = null;
            }
            this.tamano--;
        }
    }

    public String cima() {
        if (this.esVacia()) {
            return "";
        } else {
            return this.inicio.getdisco();
        }
    }


   

}
