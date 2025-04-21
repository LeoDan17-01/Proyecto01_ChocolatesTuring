/**
 * Adaptador de compatibilidad para componentes AMD.
 * Implementa la interfaz Compatibilidad.
 */
public class AMDAdapter implements Compatibilidad {

    /**
     * Verifica si dos componentes son compatibles entre si.
     * En este caso, se considera que un AMDCPU no es compatible con una NvidiaGPU.
     *
     * @param componente1 Primer componente.
     * @param componente2 Segundo componente.
     * @return true si son compatibles, false si no.
     */
    @Override
    public boolean esCompatible(Componente componente1, Componente componente2) {
        if (componente1 instanceof AMDCPU && componente2 instanceof NvidiaGPU) {
            return false;
        }
        return true;
    }

    /**
     * Adapta un componente AMD a su equivalente Intel.
     *
     * @param componente Componente a adaptar.
     * @return Componente adaptado, o el mismo si no requiere adaptacion.
     */
    @Override
    public Componente adaptarComponente(Componente componente) {
        if (componente instanceof AMDCPU) {
            AMDCPU amdCpu = (AMDCPU) componente;
            return new IntelCPU(
                "Intel Equivalente",
                amdCpu.getPrecio() * 1.1,  
                amdCpu.getNumNucleos(),
                "LGA1200"
            );
        }
        return componente;
    }
}