public class MSIMotherboard extends Motherboard{
    public MSIMotherboard(String nombre, double precio, String chipset, String tipoSocket) {
        super(nombre, precio, "MSI", chipset, tipoSocket);
    }

    @Override
    public String getDescripcion() {
        return String.format("Motherboard MSI %s - Chipset %s - Socket %s - $%.2f",
               getNombre(), getChipset(), getTipoSocket(), getPrecio());
    }
}