public abstract class GPU {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected String tipoMemoria;
    protected int vramGB;

    public GPU(String nombre, double precio, String marca, String tipoMemoria, int vramGB) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.tipoMemoria = tipoMemoria;
        this.vramGB = vramGB;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }
    public String getTipoMemoria() { return tipoMemoria; }
    public int getVramGB() { return vramGB; }

    public abstract String getDescripcion();
}