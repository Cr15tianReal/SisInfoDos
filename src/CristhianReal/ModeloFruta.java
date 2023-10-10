
package CristhianReal;

public class ModeloFruta {
    private String nombre;
    private int precio;

    public ModeloFruta(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }
}