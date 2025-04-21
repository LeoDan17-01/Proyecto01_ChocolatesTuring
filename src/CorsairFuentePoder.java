/**
 * Representa una fuente de poder de la marca Corsair.
 * 
 * Extiende la clase base FuentePoder e implementa su propia
 * descripcion personalizada incluyendo marca, potencia y certificacion.
 */
public class CorsairFuentePoder extends FuentePoder {

    /**
     * Constructor que inicializa una fuente de poder Corsair con sus especificaciones.
     *
     * @param nombre        Nombre del modelo de la fuente.
     * @param precio        Precio en moneda local.
     * @param potenciaWatts Potencia maxima que soporta la fuente (en vatios).
     * @param certificacion Certificacion de eficiencia energetica (ej. 80+ Bronze, 80+ Gold).
     */
    public CorsairFuentePoder(String nombre, double precio, int potenciaWatts, String certificacion) {
        super(nombre, precio, "Corsair", potenciaWatts, certificacion);
    }

    /**
     * Devuelve una descripcion detallada de la fuente Corsair.
     *
     * @return Cadena formateada con nombre, potencia, certificacion y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("Fuente Corsair %s - %dW %s - $%.2f",
               nombre, potenciaWatts, certificacion, precio);
    }
}