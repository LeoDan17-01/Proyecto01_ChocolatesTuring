public abstract class Disco {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected int capacidadGB;
    protected String tipoAlmacenamiento;

    public Disco(String nombre, double precio, String marca, int capacidadGB, String tipoAlmacenamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.capacidadGB = capacidadGB;
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }
    public int getCapacidadGB() { return capacidadGB; }
    public String getTipoAlmacenamiento() { return tipoAlmacenamiento; }

    public abstract String getDescripcion();
}