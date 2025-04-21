/**
 * Representa una fuente de poder de la marca EVGA.
 */
public class EVGAFuentePoder extends FuentePoder {

    /**
     * Constructor de fuente de poder EVGA.
     *
     * @param nombre        Nombre del modelo.
     * @param precio        Precio en moneda local.
     * @param potenciaWatts Potencia en vatios.
     * @param certificacion Certificacion de eficiencia (ej. 80+ Bronze).
     */
    public EVGAFuentePoder(String nombre, double precio, int potenciaWatts, String certificacion) {
        super(nombre, precio, "EVGA", potenciaWatts, certificacion);
    }

    /**
     * Devuelve una descripcion detallada de la fuente EVGA.
     *
     * @return descripcion en texto plano.
     */
    @Override
    public String getDescripcion() {
        return String.format("Fuente EVGA %s - %dW %s - $%.2f",
               nombre, potenciaWatts, certificacion, precio);
    }
}