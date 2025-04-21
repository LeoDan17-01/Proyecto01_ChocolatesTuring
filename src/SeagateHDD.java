public class SeagateHDD extends Disco {
    public SeagateHDD(String nombre, double precio, String marca, int capacidadGB, String tipoAlmacenamiento) {
        super(nombre, precio, "Seagate Barracuda", capacidadGB, tipoAlmacenamiento);
    }

    @Override
    public String getDescripcion() {
        return String.format("Seagate %s - %dGB %s - $%.2f",
               nombre, capacidadGB, tipoAlmacenamiento, precio);

    }
}