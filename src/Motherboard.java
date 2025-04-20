/**
 * Clase abstracta que representa una placa base (motherboard).
 * Incluye propiedades como chipset y tipo de socket.
 */
public abstract class Motherboard extends Componente {
    protected String chipset;
    protected String tipoSocket;

    /**
     * Constructor base para una motherboard.
     *
     * @param nombre     Nombre del modelo.
     * @param precio     Precio.
     * @param marca      Marca del fabricante.
     * @param chipset    Chipset utilizado (ej. Z590, B550).
     * @param tipoSocket Tipo de socket compatible (LGA1200, AM4, etc).
     */
    public Motherboard(String nombre, double precio, String marca, String chipset, String tipoSocket) {
        super(nombre, precio, marca);
        this.chipset = chipset;
        this.tipoSocket = tipoSocket;
    }

    /**
     * Devuelve el chipset de la motherboard.
     *
     * @return nombre del chipset.
     */
    public String getChipset() { return chipset; }

    /**
     * Devuelve el tipo de socket de la motherboard.
     *
     * @return tipo de socket (ej. "LGA1700", "AM4").
     */
    public String getTipoSocket() { return tipoSocket; }
}