
/**
 * Clase abstracta que representa una tarjeta grafica (GPU).
 * Incluye especificaciones como tipo de memoria y VRAM.
 */
public abstract class GPU extends Componente {
    protected String tipoMemoria;
    protected int vramGB;

    /**
     * Constructor base para una GPU.
     *
     * @param nombre       Nombre del modelo.
     * @param precio       Precio de la GPU.
     * @param marca        Marca del fabricante.
     * @param tipoMemoria  Tipo de memoria utilizada (GDDR6, GDDR6X, etc).
     * @param vramGB       Cantidad de VRAM en GB.
     */
    public GPU(String nombre, double precio, String marca, String tipoMemoria, int vramGB) {
        super(nombre, precio, marca);
        this.tipoMemoria = tipoMemoria;
        this.vramGB = vramGB;
    }

    /**
     * Devuelve el tipo de memoria usada por la GPU.
     *
     * @return tipo de memoria (ej. GDDR6).
     */
    public String getTipoMemoria() { return tipoMemoria; }

    /**
     * Devuelve la cantidad de VRAM disponible en la GPU.
     *
     * @return VRAM en gigabytes.
     */
    public int getVramGB() { return vramGB; }
}