public class IntelNvidiaFactory implements ComponenteFactory {
    @Override
    public CPU crearCPU(String modelo) {
        switch(modelo) {
            case "i3-13100": return new IntelCPU("Core i3-13100", 1200, "Intel", 4);
            case "i5-13600K": return new IntelCPU("Core i5-13600K", 2500, "Intel", 6);
            // ... otros modelos Intel
            default: throw new IllegalArgumentException("Modelo de CPU no válido");
        }
    }

    @Override
    public GPU crearGPU(String modelo) {
        switch(modelo) {
            case "RTX 3060": return new NvidiaGPU("RTX 3060", 6000, "NVIDIA", "GDDR6");
            // ... otros modelos NVIDIA
            default: throw new IllegalArgumentException("Modelo de GPU no válido");
        }
    }
    
    // Implementaciones para otros componentes...
}