public class SSD extends Disco {
    private String tipoInterfaz;

    public SSD(String nombre, double precio, String marca, int capacidadGB, String tipoInterfaz) {
        super(nombre, precio, marca, capacidadGB, "SSD");
        this.tipoInterfaz = tipoInterfaz;
    }

    // Getter específico
    public String getTipoInterfaz() { return tipoInterfaz; }

    @Override
    public String getDescripcion() {
        return String.format("SSD %s %dGB - %s - $%.2f",
               marca, capacidadGB, tipoInterfaz, precio);
    }
}