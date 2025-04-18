public class NvidiaGPU extends GPU {
    public NvidiaGPU(String nombre, double precio, String tipoMemoria, int vramGB) {
        super(nombre, precio, "NVIDIA", tipoMemoria, vramGB);
    }

    @Override
    public String getDescripcion() {
        return String.format("GPU NVIDIA %s - %dGB %s - $%.2f",
               getNombre(), getVramGB(), getTipoMemoria(), getPrecio());
    }
}