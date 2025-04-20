public class Sucursal {
    private String nombre;
    private String direccion;
    private boolean esCentral;
    private Inventario inventario;

    public Sucursal(String nombre, String direccion, boolean esCentral) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.esCentral = esCentral;
        this.inventario = Inventario.getInstance();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public boolean isCentral() {
        return esCentral;
    }

    public Inventario getInventario() {
        return inventario;
    }

    @Override 
    public String toString() {
        return nombre + (esCentral ? " (Central)" : "");
    }
}