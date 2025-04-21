/**
 * Representa un gabinete de la marca NZXT.
 * Extiende la clase abstracta Gabinete.
 */
public class NZXTGabinete extends Gabinete {

    /**
     * Crea un nuevo gabinete NZXT con sus especificaciones.
     *
     * @param nombre              Nombre del modelo.
     * @param precio              Precio del gabinete.
     * @param tipoFactor          Tipo de factor de forma (ATX, mATX...).
     * @param incluyeVentiladores Indica si incluye ventiladores de fábrica.
     */
    public NZXTGabinete(String nombre, double precio, String tipoFactor, boolean incluyeVentiladores) {
        super(nombre, precio, "NZXT", tipoFactor, incluyeVentiladores);
    }

    /**
     * Devuelve una descripcion completa del gabinete.
     *
     * @return Descripcion textual con detalles del modelo.
     */
    @Override
    public String getDescripcion() {
        return String.format("Gabinete NZXT %s - Factor %s - %s - $%.2f",
               nombre, tipoFactor, 
               incluyeVentiladores ? "Con ventiladores" : "Sin ventiladores",
               precio);
    }
}