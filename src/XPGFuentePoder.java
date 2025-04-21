/**
 * Representa una fuente de poder de la marca XPG.
 * 
 * Extiende la clase base FuentePoder y define una descripcion especifica para esta marca.
 */
public class XPGFuentePoder extends FuentePoder {

    /**
     * Constructor que inicializa una fuente de poder XPG con sus características.
     *
     * @param nombre        Nombre del modelo de la fuente.
     * @param precio        Precio en moneda local.
     * @param potenciaWatts Potencia maxima en vatios que entrega la fuente.
     * @param certificacion Certificacion de eficiencia energetica (por ejemplo, 80+ Bronze).
     */
    public XPGFuentePoder(String nombre, double precio, int potenciaWatts, String certificacion) {
        super(nombre, precio, "XPG", potenciaWatts, certificacion);
    }

    /**
     * Retorna una descripcion formateada de la fuente de poder XPG.
     *
     * @return Cadena con nombre, potencia, certificacion y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("Fuente XPG %s - %dW %s - $%.2f",
               nombre, potenciaWatts, certificacion, precio);
    }
}