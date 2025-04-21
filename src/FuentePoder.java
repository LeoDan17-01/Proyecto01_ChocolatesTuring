/**
 * Clase abstracta que representa una fuente de poder para computadora.
 * Incluye atributos comunes como potencia, certificacion y marca.
 */
public abstract class FuentePoder {
    protected String nombre;
    protected double precio;
    protected String marca;
    protected int potenciaWatts;
    protected String certificacion;

    /**
     * Constructor para inicializar una fuente de poder.
     *
     * @param nombre         Nombre del modelo.
     * @param precio         Precio de la fuente.
     * @param marca          Marca del fabricante.
     * @param potenciaWatts  Potencia nominal en watts.
     * @param certificacion  Certificacion de eficiencia energetica (ej. 80+ Bronze).
     */
    public FuentePoder(String nombre, double precio, String marca, int potenciaWatts, String certificacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.potenciaWatts = potenciaWatts;
        this.certificacion = certificacion;
    }

    /**
     * Obtiene el nombre del modelo de la fuente de poder.
     *
     * @return nombre del modelo (por ejemplo, "EVGA 600W").
     */
    public String getNombre() { return nombre; }

    /**
     * Devuelve el precio de la fuente de poder.
     *
     * @return precio en moneda local.
     */
    public double getPrecio() { return precio; }

    /**
     * Obtiene la marca del fabricante de la fuente.
     *
     * @return nombre de la marca (por ejemplo, "EVGA", "Corsair").
     */
    public String getMarca() { return marca; }

    /**
     * Devuelve la potencia de la fuente en vatios (Watts).
     *
     * @return potencia de salida en W.
     */
    public int getPotenciaWatts() { return potenciaWatts; }

    /**
     * Devuelve la certificacion de eficiencia energetica.
     *
     * @return tipo de certificacion (por ejemplo, "80+ Bronze", "80+ Gold").
     */
    public String getCertificacion() { return certificacion; }

    /**
     * Metodo abstracto para retornar una descripcion completa.
     *
     * @return Cadena con la descripcion.
     */
    public abstract String getDescripcion();
}