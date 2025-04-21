public class CorsairFuentePoder extends FuentePoder {

    /**
     * Constructor de fuente de poder EVGA.
     *
     * @param nombre        Nombre del modelo.
     * @param precio        Precio en moneda local.
     * @param potenciaWatts Potencia en vatios.
     * @param certificacion Certificación de eficiencia (ej. 80+ Bronze).
     */
    public CorsairFuentePoder(String nombre, double precio, int potenciaWatts, String certificacion) {
        super(nombre, precio, "Corsair", potenciaWatts, certificacion);
    }

    /**
     * Devuelve una descripción detallada de la fuente EVGA.
     *
     * @return descripción en texto plano.
     */
    @Override
    public String getDescripcion() {
        return String.format("Fuente Corsair %s - %dW %s - $%.2f",
               nombre, potenciaWatts, certificacion, precio);
    }
}