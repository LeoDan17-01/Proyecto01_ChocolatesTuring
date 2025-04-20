/**
 * Representa una unidad SSD (estado sólido).
 * Hereda de la clase Disco.
 */
public class SSD extends Disco {
    private String tipoInterfaz;

    /**
     * Crea un disco SSD con su interfaz.
     *
     * @param nombre        Nombre del modelo.
     * @param precio        Precio.
     * @param marca         Marca del fabricante.
     * @param capacidadGB   Capacidad en GB.
     * @param tipoInterfaz  Tipo de interfaz (ej. NVMe, SATA).
     */
    public SSD(String nombre, double precio, String marca, int capacidadGB, String tipoInterfaz) {
        super(nombre, precio, marca, capacidadGB, "SSD");
        this.tipoInterfaz = tipoInterfaz;
    }

    /**
     * Devuelve el tipo de interfaz (ej. NVMe, SATA).
     *
     * @return Tipo de interfaz.
     */
    public String getTipoInterfaz() { return tipoInterfaz; }

    /**
     * Descripción detallada del disco SSD.
     *
     * @return Cadena con los detalles del SSD.
     */
    @Override
    public String getDescripcion() {
        return String.format("SSD %s %dGB - %s - $%.2f",
               marca, capacidadGB, tipoInterfaz, precio);
    }
}