public class ASUSMotherboard extends Motherboard {
    public ASUSMotherboard(String nombre, double precio, String chipset, String tipoSocket) {
        super(nombre, precio, "ASUS", chipset, tipoSocket);
    }

    @Override
    public String getDescripcion() {
        return String.format("Motherboard ASUS %s - Chipset %s - Socket %s - $%.2f",
               getNombre(), getChipset(), getTipoSocket(), getPrecio());
    }
}