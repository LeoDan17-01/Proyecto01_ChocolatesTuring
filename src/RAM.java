public abstract class RAM {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected int capacidadGB;
    protected String tipoMemoria;
    protected int velocidadMHz;

    public RAM(String nombre, double precio, String marca, int capacidadGB, String tipoMemoria, int velocidadMHz) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.capacidadGB = capacidadGB;
        this.tipoMemoria = tipoMemoria;
        this.velocidadMHz = velocidadMHz;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }
    public int getCapacidadGB() { return capacidadGB; }
    public String getTipoMemoria() { return tipoMemoria; }
    public int getVelocidadMHz() { return velocidadMHz; }

    public abstract String getDescripcion();
}
