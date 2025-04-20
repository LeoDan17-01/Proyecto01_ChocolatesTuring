/**
 * Representa una motherboard de la marca ASUS.
 */
public class ASUSMotherboard extends Motherboard {

    /**
     * Crea una nueva instancia de motherboard ASUS.
     *
     * @param nombre     Nombre del modelo.
     * @param precio     Precio de la motherboard.
     * @param chipset    Chipset utilizado.
     * @param tipoSocket Tipo de socket compatible.
     */
    public ASUSMotherboard(String nombre, double precio, String chipset, String tipoSocket) {
        super(nombre, precio, "ASUS", chipset, tipoSocket);
    }

    /**
     * Devuelve una descripción detallada de la motherboard ASUS.
     *
     * @return Cadena con la descripción.
     */
    @Override
    public String getDescripcion() {
        return String.format("Motherboard ASUS %s - Chipset %s - Socket %s - $%.2f",
               getNombre(), getChipset(), getTipoSocket(), getPrecio());
    }
}