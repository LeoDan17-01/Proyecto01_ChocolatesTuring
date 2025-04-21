/**
 * Representa una sucursal del distribuidor donde se pueden realizar pedidos y gestionar inventario.
 * 
 * Cada sucursal tiene un nombre, direccion, y una indicacion de si es central. 
 * Comparte una unica instancia del Inventario, ya que es Singleton.
 */
public class Sucursal {
    private String nombre;
    private String direccion;
    private boolean esCentral;
    private Inventario inventario;

    /**
     * Constructor para crear una nueva sucursal.
     *
     * @param nombre     Nombre identificador de la sucursal.
     * @param direccion  Direccion fisica de la sucursal.
     * @param esCentral  Indica si esta sucursal es la central.
     */
    public Sucursal(String nombre, String direccion, boolean esCentral) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.esCentral = esCentral;
        this.inventario = Inventario.getInstance();
    }

    /**
     * Obtiene el nombre de la sucursal.
     *
     * @return Cadena con el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la direccion de la sucursal.
     *
     * @return Cadena con la direccion.
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * Indica si la sucursal es la sede central.
     *
     * @return true si es central, false en caso contrario.
     */
    public boolean isCentral() {
        return esCentral;
    }

    /**
     * Retorna la instancia de inventario asociada a la sucursal.
     *
     * @return Objeto Inventario.
     */
    public Inventario getInventario() {
        return inventario;
    }

    /**
     * Representacion en texto de la sucursal.
     *
     * @return Nombre con sufijo "(Central)" si aplica.
     */
    @Override 
    public String toString() {
        return nombre + (esCentral ? " (Central)" : "");
    }
}