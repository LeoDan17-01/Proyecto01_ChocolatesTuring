public class KingstonRAM extends RAM {
    public KingstonRAM(String nombre, double precio, int capacidadGB, String tipoMemoria, int velocidadMHz) {
        super(nombre, precio, "Kingston", capacidadGB, tipoMemoria, velocidadMHz);
    }

    @Override
    public String getDescripcion() {
        return String.format("RAM Kingston %s - %dGB %s %dMHz - $%.2f",
               nombre, capacidadGB, tipoMemoria, velocidadMHz, precio);

    }
}

