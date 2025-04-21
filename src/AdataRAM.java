/**
 * Representa un modulo de memoria RAM de la marca Adata.
 */
public class AdataRAM extends RAM {

     /**
     * Crea una nueva instancia de AdataRAM con los parametros especificados.
     *
     * @param nombre       Nombre del componente.
     * @param precio       Precio de la RAM.
     * @param capacidadGB  Capacidad de la memoria en GB.
     * @param tipoMemoria  Tipo de memoria (DDR4, DDR5, etc).
     * @param velocidadMHz Velocidad de la memoria en MHz.
     */
    public AdataRAM(String nombre, double precio, int capacidadGB, String tipoMemoria, int velocidadMHz) {
        super(nombre, precio, "Adata", capacidadGB, tipoMemoria, velocidadMHz);
    }

    /**
     * Devuelve una descripcion detallada de la RAM Adata.
     *
     * @return Cadena con la descripcion.
     */
    @Override
    public String getDescripcion() {
        return String.format("RAM Adata %s - %dGB %s %dMHz - $%.2f",
               nombre, capacidadGB, tipoMemoria, velocidadMHz, precio);
    }
}