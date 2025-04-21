/**
 * Representa una tarjeta grafica (GPU) de la marca NVIDIA.
 * Hereda de la clase abstracta GPU.
 */
public class NvidiaGPU extends GPU {

    /**
     * Constructor de una GPU NVIDIA.
     *
     * @param nombre      Nombre del modelo (ej. RTX 3060).
     * @param precio      Precio de la tarjeta.
     * @param tipoMemoria Tipo de memoria (GDDR6, GDDR6X, etc).
     * @param vramGB      Cantidad de memoria de video (VRAM) en GB.
     */
    public NvidiaGPU(String nombre, double precio, String tipoMemoria, int vramGB) {
        super(nombre, precio, "NVIDIA", tipoMemoria, vramGB);
    }

    /**
     * Devuelve una descripcion completa de la GPU.
     *
     * @return Descripcion con nombre, memoria y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("GPU NVIDIA %s - %dGB %s - $%.2f",
               getNombre(), getVramGB(), getTipoMemoria(), getPrecio());
    }
}