public class AMDCPU extends CPU {
    public AMDCPU(String nombre, double precio, String marca, int cantidadNucleos) {
        super(nombre, precio, marca, cantidadNucleos);
        
    }
    
    @Override
    public String getDescripcion() {
        return String.format("CPU AMD %s - %d núcleos - $%.2f", nombre, numNucleos, precio);
    }
}