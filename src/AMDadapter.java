public class AMDadapter implements Compatibilidad{
    @Override
    public boolean esCompatible(Componente componente1, Componente componente2) {
        // Lógica compleja de compatibilidad
        if (componente1 instanceof AMDCPU && componente2 instanceof NvidiaGPU) {
            return false; // Incompatibilidad conocida
        }
        return true;
    }

    @Override
    public Componente adaptarComponente(Componente componente) {
        if (componente instanceof AMDCPU) {
            AMDCPU amdCpu = (AMDCPU) componente;
            // Crear un CPU Intel equivalente
            return new IntelCPU("Intel equivalente", 
                              amdCpu.getPrecio() * 1.1, 
                              "Intel", 
                              amdCpu.getCantidadNucleos());
        }
        return componente;
    }
}