public abstract class RAM{
    protected String nombre;
    protected double precio;
    protected String marca;
    protected int capacidad;

    public RAM(String nombre, double precio, String marca, int capacidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.capacidad = capacidad;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }
    public int getCapacidad() { return capacidad; }

    public abstract String getDescripcion();
}