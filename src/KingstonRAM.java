/**
 * Representa un modulo de memoria RAM de la marca Kingston.
 * 
 * Hereda de la clase base RAM y define una descripcion especifica para este fabricante.
 */
public class KingstonRAM extends RAM {

    /**
     * Constructor que crea una instancia de memoria RAM Kingston con sus atributos especificos.
     *
     * @param nombre        Nombre del modelo.
     * @param precio        Precio del modulo de memoria.
     * @param capacidadGB   Capacidad en gigabytes.
     * @param tipoMemoria   Tipo de memoria (por ejemplo, DDR4, DDR5).
     * @param velocidadMHz  Velocidad en MHz.
     */
    public KingstonRAM(String nombre, double precio, int capacidadGB, String tipoMemoria, int velocidadMHz) {
        super(nombre, precio, "Kingston", capacidadGB, tipoMemoria, velocidadMHz);
    }

    /**
     * Retorna una descripcion formateada del modulo de memoria RAM Kingston.
     *
     * @return Cadena con nombre, capacidad, tipo, velocidad y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("RAM Kingston %s - %dGB %s %dMHz - $%.2f",
               nombre, capacidadGB, tipoMemoria, velocidadMHz, precio);

    }
}

