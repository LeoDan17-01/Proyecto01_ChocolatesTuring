public abstract class Motherboard extends Componente {
    protected String chipset;
    protected String tipoSocket;

    public Motherboard(String nombre, double precio, String marca, String chipset, String tipoSocket) {
        super(nombre, precio, marca);
        this.chipset = chipset;
        this.tipoSocket = tipoSocket;
    }

    // Añade estos getters
    public String getChipset() { return chipset; }
    public String getTipoSocket() { return tipoSocket; }
}