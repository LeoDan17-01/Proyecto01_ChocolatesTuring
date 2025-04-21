public class KingstonSSD extends Disco {
    public KingstonSSD(String nombre, double precio, String marca, int capacidadGB, String tipoAlmacenamiento) {
        super(nombre, precio, "Kingston", capacidadGB, tipoAlmacenamiento);

    }

    @Override
    public String getDescripcion() {
        return String.format("Kingston SSD %s - %dGB %s - $%.2f",
               nombre, capacidadGB, tipoAlmacenamiento, precio);
    }
}