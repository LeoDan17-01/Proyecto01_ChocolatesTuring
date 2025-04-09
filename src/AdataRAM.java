public class AdataRAM extends RAM {
    public AdataRAM(String nombre, double precio, int capacidadGB, String tipoMemoria, int velocidadMHz) {
        super(nombre, precio, "Adata", capacidadGB, tipoMemoria, velocidadMHz);
    }

    @Override
    public String getDescripcion() {
        return String.format("RAM Adata %s - %dGB %s %dMHz - $%.2f",
               nombre, capacidadGB, tipoMemoria, velocidadMHz, precio);
    }
}