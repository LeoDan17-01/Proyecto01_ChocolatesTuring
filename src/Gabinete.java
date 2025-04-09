public abstract class Gabinete {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected String tipoFactor;
    protected boolean incluyeVentiladores;

    public Gabinete(String nombre, double precio, String marca, String tipoFactor, boolean incluyeVentiladores) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.tipoFactor = tipoFactor;
        this.incluyeVentiladores = incluyeVentiladores;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }
    public String getTipoFactor() { return tipoFactor; }
    public boolean isIncluyeVentiladores() { return incluyeVentiladores; }

    public abstract String getDescripcion();
}