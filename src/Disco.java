/**
 * Clase abstracta que representa un disco de almacenamiento.
 */
public abstract class Disco {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected int capacidadGB;
    protected String tipoAlmacenamiento;

    /**
     * Constructor de disco.
     *
     * @param nombre             Nombre del disco.
     * @param precio             Precio.
     * @param marca              Marca.
     * @param capacidadGB        Capacidad en GB.
     * @param tipoAlmacenamiento Tipo de almacenamiento (SATA, NVMe, etc).
     */
    public Disco(String nombre, double precio, String marca, int capacidadGB, String tipoAlmacenamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.capacidadGB = capacidadGB;
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }

    /**
     * Obtiene el nombre del disco.
     *
     * @return el nombre del modelo de disco (por ejemplo, "Samsung 1TB").
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene el precio del disco.
     *
     * @return el precio del disco en formato decimal.
     */
    public double getPrecio() { return precio; }

    /**
     * Obtiene la marca del disco.
     *
     * @return la marca del fabricante (por ejemplo, "Samsung", "Adata").
     */
    public String getMarca() { return marca; }

    /**
     * Obtiene la capacidad de almacenamiento del disco.
     *
     * @return la capacidad del disco en gigabytes (GB).
     */
    public int getCapacidadGB() { return capacidadGB; }

    /**
     * Obtiene el tipo de tecnología de almacenamiento utilizada.
     *
     * @return el tipo de almacenamiento (por ejemplo, "SATA", "NVMe").
     */
    public String getTipoAlmacenamiento() { return tipoAlmacenamiento; }

    /**
     * Devuelve una descripción del disco.
     * @return descripción completa.
     */
    public abstract String getDescripcion();
}