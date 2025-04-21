/**
 * Representa una motherboard de la marca MSI.
 * 
 * Extiende la clase base Motherboard y proporciona una implementacion personalizada
 * del metodo de descripcion que incluye marca, chipset y tipo de socket.
 */
public class MSIMotherboard extends Motherboard{

    /**
     * Constructor para inicializar una motherboard MSI con sus caracteristicas tecnicas.
     *
     * @param nombre      Nombre del modelo de la motherboard.
     * @param precio      Precio en moneda local.
     * @param chipset     Chipset que utiliza la placa (ej. B550, Z690).
     * @param tipoSocket  Tipo de socket compatible con el procesador (ej. AM4, LGA1700).
     */
    public MSIMotherboard(String nombre, double precio, String chipset, String tipoSocket) {
        super(nombre, precio, "MSI", chipset, tipoSocket);
    }

    /**
     * Retorna una descripcion detallada de la motherboard MSI.
     *
     * @return Cadena con nombre, chipset, socket y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("Motherboard MSI %s - Chipset %s - Socket %s - $%.2f",
               getNombre(), getChipset(), getTipoSocket(), getPrecio());
    }
}