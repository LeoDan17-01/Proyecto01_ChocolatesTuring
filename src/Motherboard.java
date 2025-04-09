public abstract class Motherboard {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected String chipset;
    protected String tipoSocket;

    public Motherboard(String nombre, double precio, String marca, String chipset, String tipoSocket) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.chipset = chipset;
        this.tipoSocket = tipoSocket;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }
    public String getChipset() { return chipset; }
    public String getTipoSocket() { return tipoSocket; }

    public abstract String getDescripcion();
}