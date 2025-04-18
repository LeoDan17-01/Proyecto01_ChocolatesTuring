public class AMDAdapter implements Compatibilidad {
    @Override
    public boolean esCompatible(Componente componente1, Componente componente2) {
        if (componente1 instanceof AMDCPU && componente2 instanceof NvidiaGPU) {
            return false;
        }
        return true;
    }

    @Override
    public Componente adaptarComponente(Componente componente) {
        if (componente instanceof AMDCPU) {
            AMDCPU amdCpu = (AMDCPU) componente;
            return new IntelCPU(
                "Intel Equivalente",
                amdCpu.getPrecio() * 1.1,  // Ahora funcionará
                amdCpu.getNumNucleos(),
                "LGA1200"
            );
        }
        return componente;
    }
}