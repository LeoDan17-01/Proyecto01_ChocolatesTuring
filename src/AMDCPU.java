/**
 * Representa una CPU de la marca AMD.
 */
public class AMDCPU extends CPU {
    /**
     * Crea una nueva CPU AMD con los parámetros especificados.
     *
     * @param nombre     Nombre del modelo.
     * @param precio     Precio de la CPU.
     * @param numNucleos Número de núcleos del procesador.
     * @param socket     Tipo de socket compatible.
     */
    public AMDCPU(String nombre, double precio, int numNucleos, String socket) {
        super(nombre, precio, "AMD", numNucleos, socket);
    }

    /**
     * Devuelve una descripción detallada de la CPU AMD.
     *
     * @return Cadena con la descripción.
     */
    @Override
    public String getDescripcion() {
        return String.format("CPU AMD %s - %d núcleos - $%.2f", 
               getNombre(), getNumNucleos(), getPrecio());
    }
}