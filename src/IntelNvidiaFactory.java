public class IntelNvidiaFactory implements ComponenteFactory {
    @Override
    public CPU crearCPU(String modelo) {
        switch(modelo) {
            case "i3-13100": 
                return new IntelCPU("Core i3-13100", 1200, "Intel", 4);
            case "i5-13600K": 
                return new IntelCPU("Core i5-13600K", 2500, "Intel", 6);
            case "i7-13700K":
                return new IntelCPU("Core i7-13700K", 3500, "Intel", 8);
            case "i9-13900K":
                return new IntelCPU("Core i9-13900K", 5000, "Intel", 12);
            default:
                throw new IllegalArgumentException("Modelo de CPU Intel no válido");
        }
    }

    @Override
    public GPU crearGPU(String modelo) {
        switch(modelo) {
            case "RTX 3060":
                return new NvidiaGPU("RTX 3060", 6000, "NVIDIA", "GDDR6");
            case "RTX 4070":
                return new NvidiaGPU("RTX 4070", 12000, "GDDR6X", 16);
            default:
                throw new IllegalArgumentException("Modelo de GPU NVIDIA no válido");
        }
    }
    
    @Override
    public RAM crearRAM(String modelo, int cantidad) {
        switch (modelo) {
            case "16GB":
                return new AdataRAM("Adata 16GB", 100, 16, "DDR4", 3200);
            case "32GB":
                return new AdataRAM("Adata 32GB", 180, 32, "DDR4", 3200);
            default:
                throw new IllegalArgumentException("Modelo de RAM Intel no válido");
        }
    }

    @Override
    public Disco crearDisco(String modelo) {
        switch (modelo) {
            case "500GB":
                return new SSD("SSD 500GB", 60, "Samsung", 500, "NVMe");
            default:
                throw new IllegalArgumentException("Modelo de Disco no válido");
        }
    }

    @Override
    public FuentePoder crearFuentePoder(String modelo) {
        return new EVGAFuentePoder("EVGA 600W", 50, 600, "80+ Bronze");
    }

    @Override
    public Motherboard crearMotherboard(String modelo) {
        switch (modelo) {
            case "Z590":
                return new ASUSMotherboard("ASUS Z590", 250, "Intel", "Z590", "LGA 1200");
            default:
                throw new IllegalArgumentException("Modelo de Motherboard Intel no válido");
        }
    }

    @Override
    public Gabinete crearGabinete(String modelo) {
        return new NZXTGabinete("NZXT H510", 70, "ATX", true);
    }

}