public class IntelCPU extends CPU {
    public IntelCPU(String nombre, double precio, int numNucleos, String socket) {
        super(nombre, precio, "Intel", numNucleos, socket);
    }

    @Override
    public String getDescripcion() {
        return String.format("CPU Intel %s - %d núcleos - $%.2f", 
               getNombre(), getNumNucleos(), getPrecio());
    }
}