/**
 * Representa un software opcional que puede agregarse a una computadora.
 */
public class SoftwareAdicional {
    private String nombre;
    private double precio;
    
    /**
     * Crea un nuevo software adicional.
     *
     * @param nombre Nombre del software.
     * @param precio Precio del software.
     */
    public SoftwareAdicional(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del software adicional.
     *
     * @return nombre del software (ej. "Windows 11 Pro", "Adobe Photoshop").
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del software adicional.
     *
     * @return precio en formato decimal.
     */
    public double getPrecio() {
        return precio;
    }
}