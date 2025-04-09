public abstract class FuentePoder {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected int potenciaWatts;
    protected String certificacion;

    public FuentePoder(String nombre, double precio, String marca, int potenciaWatts, String certificacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.potenciaWatts = potenciaWatts;
        this.certificacion = certificacion;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }
    public int getPotenciaWatts() { return potenciaWatts; }
    public String getCertificacion() { return certificacion; }

    public abstract String getDescripcion();
}