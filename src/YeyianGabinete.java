/**
 * Representa un gabinete de la marca Yeyian.
 * 
 * Hereda de la clase base Gabinete y proporciona una descripcion especifica
 * que incluye el factor de forma y si incluye ventiladores.
 */
public class YeyianGabinete extends Gabinete {

    /**
     * Crea una nueva instancia de un gabinete Yeyian con las caracteristicas proporcionadas.
     *
     * @param nombre              Nombre del modelo del gabinete.
     * @param precio              Precio del gabinete en moneda local.
     * @param tipoFactor          Tipo de factor de forma (ej. ATX, MicroATX).
     * @param incluyeVentiladores true si incluye ventiladores, false si no.
     */
    public YeyianGabinete(String nombre, double precio, String tipoFactor, boolean incluyeVentiladores) {
        super(nombre, precio, "Yeyian", tipoFactor, incluyeVentiladores);
    }

    /**
     * Retorna una descripcion detallada del gabinete Yeyian.
     *
     * @return Cadena con nombre, factor de forma, ventiladores incluidos y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("Gabinete Yeyian %s - Factor %s - %s - $%.2f",
               nombre, tipoFactor, 
               incluyeVentiladores ? "Con ventiladores" : "Sin ventiladores",
               precio);
    }
}