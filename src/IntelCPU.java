public class IntelCPU extends CPU {
    public IntelCPU(String nombre, double precio, String marca, int cantidadNucleos) {
        super(nombre, precio, marca, cantidadNucleos);
    }
    
    @Override
    public String getDescripcion() {
        return String.format("CPU Intel %s - %d núcleos - $%.2f", 
               nombre, numNucleos, precio);
    }
    
    public boolean esCompatibleCon(Motherboard motherboard) {
        return motherboard.getTipoSocket().contains("LGA") && 
               motherboard.getMarca().equals("ASUS");
    }
}