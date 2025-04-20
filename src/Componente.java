/**
 * Clase abstracta que representa un componente genérico de una computadora.
 */
public abstract class Componente {
    protected String nombre;
    protected double precio;
    protected String marca;

    /**
     * Crea un nuevo componente con los datos especificados.
     *
     * @param nombre Nombre del componente.
     * @param precio Precio del componente.
     * @param marca  Marca del componente.
     */
    public Componente(String nombre, double precio, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }

    /**
     * Obtiene el nombre del componente.
     *
     * @return Nombre del componente.
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene el precio del componente.
     *
     * @return Precio del componente.
     */
    public double getPrecio() { return precio; }

    /**
     * Obtiene la marca del componente.
     *
     * @return Marca del componente.
     */
    public String getMarca() { return marca; }


    /**
     * Retorna una descripción detallada del componente.
     *
     * @return Descripción como cadena.
     */
    public abstract String getDescripcion();
}