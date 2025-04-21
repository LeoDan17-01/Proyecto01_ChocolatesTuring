/**
 * Representa una CPU de la marca AMD.
 */
public class AMDCPU extends CPU {
    /**
     * Crea una nueva CPU AMD con los parametros especificados.
     *
     * @param nombre     Nombre del modelo.
     * @param precio     Precio de la CPU.
     * @param numNucleos Numero de nucleos del procesador.
     * @param socket     Tipo de socket compatible.
     */
    public AMDCPU(String nombre, double precio, int numNucleos, String socket) {
        super(nombre, precio, "AMD", numNucleos, socket);
    }

    /**
     * Devuelve una descripcion detallada de la CPU AMD.
     *
     * @return Cadena con la descripcion.
     */
    @Override
    public String getDescripcion() {
        return String.format("CPU AMD %s - %d núcleos - $%.2f", 
               getNombre(), getNumNucleos(), getPrecio());
    }
}