public class AMDCPU extends CPU {
    public AMDCPU(String nombre, double precio, int numNucleos, String socket) {
        super(nombre, precio, "AMD", numNucleos, socket);
    }

    @Override
    public String getDescripcion() {
        return String.format("CPU AMD %s - %d núcleos - $%.2f", 
               getNombre(), getNumNucleos(), getPrecio());
    }
}