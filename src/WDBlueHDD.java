public class WDBlueHDD extends Disco {
    public WDBlueHDD(String nombre, double precio, String marca, int capacidadGB, String tipoAlmacenamiento) {
        super(nombre, precio, "Western Digital Blue", capacidadGB, tipoAlmacenamiento);
    }

    @Override
    public String getDescripcion() {
        return String.format("WD Blue %s - %dGB %s - $%.2f",
               nombre, capacidadGB, tipoAlmacenamiento, precio);

    }
}