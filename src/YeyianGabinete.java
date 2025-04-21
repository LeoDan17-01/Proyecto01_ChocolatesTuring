public class YeyianGabinete extends Gabinete {

    /**
     * Crea un nuevo gabinete NZXT con sus especificaciones.
     *
     * @param nombre              Nombre del modelo.
     * @param precio              Precio del gabinete.
     * @param tipoFactor          Tipo de factor de forma (ATX, mATX...).
     * @param incluyeVentiladores Indica si incluye ventiladores de fábrica.
     */
    public YeyianGabinete(String nombre, double precio, String tipoFactor, boolean incluyeVentiladores) {
        super(nombre, precio, "Yeyian", tipoFactor, incluyeVentiladores);
    }

    /**
     * Devuelve una descripción completa del gabinete.
     *
     * @return Descripción textual con detalles del modelo.
     */
    @Override
    public String getDescripcion() {
        return String.format("Gabinete Yeyian %s - Factor %s - %s - $%.2f",
               nombre, tipoFactor, 
               incluyeVentiladores ? "Con ventiladores" : "Sin ventiladores",
               precio);
    }
}