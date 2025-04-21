/**
 * Representa un procesador de la marca Intel.
 * Extiende la clase abstracta CPU.
 */
public class IntelCPU extends CPU {

    /**
     * Crea una nueva instancia de un procesador Intel.
     *
     * @param nombre     Nombre del modelo (ej. "Core i7-13700K").
     * @param precio     Precio del procesador.
     * @param numNucleos Numero de nucleos.
     * @param socket     Tipo de socket compatible.
     */
    public IntelCPU(String nombre, double precio, int numNucleos, String socket) {
        super(nombre, precio, "Intel", numNucleos, socket);
    }

    /**
     * Devuelve una descripcion detallada del procesador Intel.
     *
     * @return descripcion con modelo, núcleos y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("CPU Intel %s - %d núcleos - $%.2f", 
               getNombre(), getNumNucleos(), getPrecio());
    }
}