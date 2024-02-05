
package modelo;

/**
 *
 * @author zaqui
 */
public class NodoPila {

    private String disco;
    private NodoPila siguiente;
    private NodoPila anterior;
 
    public NodoPila getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPila anterior) {
        this.anterior = anterior;
    }
    
    public String getdisco() {
        return disco;
    }

    public void setdisco(String disco) {
        this.disco = disco;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

}
