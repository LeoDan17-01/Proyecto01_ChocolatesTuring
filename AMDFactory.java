public class AMDFactory implements ComponenteFactory {
    @Override
    public CPU crearCPU(String modelo) {
        switch(modelo) {
            case "Ryzen 5 5600G": return new AMDCPU("Ryzen 5 5600G", 1800, "AMD", 6);
            // ... otros modelos AMD
            default: throw new IllegalArgumentException("Modelo de CPU no válido");
        }
    }
    
    // AMD no tiene GPU en este contexto, pero podríamos lanzar excepción o retornar null
    @Override
    public GPU crearGPU(String modelo) {
        throw new UnsupportedOperationException("AMD no provee GPUs en este sistema");
    }
    
    // Implementaciones para otros componentes...
}