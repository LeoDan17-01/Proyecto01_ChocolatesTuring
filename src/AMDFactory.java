public class AMDFactory implements ComponenteFactory {
    @Override
    public CPU crearCPU(String modelo) {
        switch(modelo) {
            case "Ryzen 5 5600G": 
                return new AMDCPU("Ryzen 5 5600G", 1800, 6, "AM4");
            case "Ryzen 5 7600X":
                return new AMDCPU("Ryzen 5 7600X", 2200, 6, "AM5");
            case "Ryzen 7 7700X":
                return new AMDCPU("Ryzen 7 7700X", 3200, 8, "AM5");
            case "Ryzen 9 7950X3D":
                return new AMDCPU("Ryzen 9 7950X3D", 5800, 16, "AM5");
            default:
                throw new IllegalArgumentException("Modelo de CPU AMD no válido");
        }
    }

    @Override
    public GPU crearGPU(String modelo) {
        throw new UnsupportedOperationException("AMD no provee GPUs en este sistema");
    }
    
    @Override
    public RAM crearRAM(String modelo, int cantidad) {
        switch (modelo) {
            case "16GB":
                return new AdataRAM("Adata 16GB", 100, 16, "DDR4", 3200);
            case "32GB":
                return new AdataRAM("Adata 32GB", 180, 32, "DDR4", 3200);
            default:
                throw new IllegalArgumentException("Modelo de RAM AMD no válido");
        }
    }

    @Override
    public Disco crearDisco(String modelo) {
        switch (modelo) {
            case "1TB":
                return new SSD("SSD 1TB", 100, "Adata", 1024, "SATA");
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
            case "B550":
                return new ASUSMotherboard("ASUS B550", 150, "B550", "AM4");
            default:
                throw new IllegalArgumentException("Modelo de Motherboard AMD no válido");
        }
    }

    @Override
    public Gabinete crearGabinete(String modelo) {
        return new NZXTGabinete("NZXT H510", 70, "ATX", true);
    }
}