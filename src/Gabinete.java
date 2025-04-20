/**
 * Clase abstracta que representa un gabinete (chasis) de computadora.
 * Define las propiedades comunes como formato y si incluye ventiladores.
 */
public abstract class Gabinete {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected String tipoFactor;
    protected boolean incluyeVentiladores;

    /**
     * Constructor base para un gabinete.
     *
     * @param nombre              Nombre del modelo.
     * @param precio              Precio del gabinete.
     * @param formato             Formato compatible (ej. ATX, mATX).
     * @param incluyeVentiladores true si incluye ventiladores, false si no.
     */
    public Gabinete(String nombre, double precio, String marca, String tipoFactor, boolean incluyeVentiladores) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.tipoFactor = tipoFactor;
        this.incluyeVentiladores = incluyeVentiladores;
    }

    /**
     * Obtiene el nombre del modelo de gabinete.
     *
     * @return nombre del gabinete.
     */
    public String getNombre() { return nombre; }

    /**
     * Devuelve el precio del gabinete.
     *
     * @return precio en moneda local.
     */
    public double getPrecio() { return precio; }

    /**
     * Obtiene la marca del gabinete.
     *
     * @return nombre del fabricante del gabinete.
     */
    public String getMarca() { return marca; }

    /**
     * Devuelve el tipo de factor de forma del gabinete.
     *
     * @return tipo de factor de forma del gabinete.
     */
    public String getTipoFactor() { return tipoFactor; }

    /**
     * Indica si el gabinete incluye ventiladores.
     *
     * @return true si incluye, false si no.
     */
    public boolean isIncluyeVentiladores() { return incluyeVentiladores; }

    /**
     * Retorna una descripción textual del gabinete.
     *
     * @return descripción detallada.
     */
    public abstract String getDescripcion();
}