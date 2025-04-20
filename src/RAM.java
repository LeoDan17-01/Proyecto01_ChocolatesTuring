/**
 * Clase abstracta que representa un módulo de memoria RAM.
 */
public abstract class RAM {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected int capacidadGB;
    protected String tipoMemoria;
    protected int velocidadMHz;

    /**
     * Constructor de RAM.
     *
     * @param nombre         Nombre del modelo.
     * @param precio         Precio del módulo.
     * @param marca          Marca.
     * @param capacidadGB    Capacidad en gigabytes.
     * @param tipoMemoria    Tipo (ej. DDR4, DDR5).
     * @param velocidadMHz   Velocidad de operación en MHz.
     */
    public RAM(String nombre, double precio, String marca, int capacidadGB, String tipoMemoria, int velocidadMHz) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.capacidadGB = capacidadGB;
        this.tipoMemoria = tipoMemoria;
        this.velocidadMHz = velocidadMHz;
    }

    /**
     * Devuelve el nombre del modelo de la memoria RAM.
     *
     * @return nombre del módulo RAM (ej. "ADATA 16GB").
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene el precio de la memoria RAM.
     *
     * @return precio del módulo en moneda local.
     */
    public double getPrecio() { return precio; }

    /**
     * Devuelve la marca del fabricante de la RAM.
     *
     * @return nombre de la marca (ej. "ADATA", "Corsair").
     */
    public String getMarca() { return marca; }

    /**
     * Devuelve la capacidad de la memoria RAM.
     *
     * @return capacidad en gigabytes (GB).
     */
    public int getCapacidadGB() { return capacidadGB; }

    /**
     * Devuelve el tipo de memoria RAM (ej. DDR4, DDR5).
     *
     * @return tipo de memoria como cadena.
     */
    public String getTipoMemoria() { return tipoMemoria; }

    /**
     * Devuelve la velocidad de la memoria en MHz.
     *
     * @return velocidad del módulo en megahercios.
     */
    public int getVelocidadMHz() { return velocidadMHz; }

    /**
     * Devuelve una descripción detallada del módulo RAM.
     *
     * @return Descripción textual.
     */
    public abstract String getDescripcion();
}
