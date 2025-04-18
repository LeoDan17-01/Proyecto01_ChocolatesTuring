public abstract class Componente {
    protected String nombre;
    protected double precio;
    protected String marca;

    public Componente(String nombre, double precio, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }

    // Añade estos getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }

    public abstract String getDescripcion();
}