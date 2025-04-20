/**
 * Fábrica concreta que crea componentes de la combinación Intel + Nvidia.
 * Implementa la interfaz ComponenteFactory.
 */
public class IntelNvidiaFactory implements ComponenteFactory {

    /**
     * Crea una CPU Intel según el modelo solicitado.
     *
     * @param modelo Modelo de CPU a crear (por ejemplo, "i7-13700K").
     * @return Instancia de IntelCPU.
     * @throws IllegalArgumentException Si el modelo no es reconocido.
     */
    @Override
    public CPU crearCPU(String modelo) {
        switch(modelo) {
            case "i3-13100": 
                return new IntelCPU("Core i3-13100", 1200, 4, "LGA1700");
            case "i5-13600K": 
                return new IntelCPU("Core i5-13600K", 2500, 6, "LGA1700");
            case "i7-13700K":
                return new IntelCPU("Core i7-13700K", 3500, 8, "LGA1700");
            case "i9-13900K":
                return new IntelCPU("Core i9-13900K", 5000, 12, "LGA1700");
            default:
                throw new IllegalArgumentException("Modelo de CPU Intel no válido");
        }
    }

    /**
     * Crea una tarjeta gráfica Nvidia según el modelo solicitado.
     *
     * @param modelo Modelo de GPU (por ejemplo, "RTX 3060").
     * @return Instancia de NvidiaGPU.
     * @throws IllegalArgumentException Si el modelo no es válido.
     */
    @Override
    public GPU crearGPU(String modelo) {
        switch(modelo) {
            case "RTX 3060":
                return new NvidiaGPU("RTX 3060", 6000, "GDDR6", 12);
            case "RTX 4070":
                return new NvidiaGPU("RTX 4070", 12000, "GDDR6X", 16);
            default:
                throw new IllegalArgumentException("Modelo de GPU NVIDIA no válido");
        }
    }
    
    /**
     * Crea una memoria RAM ADATA con las características solicitadas.
     *
     * @param modelo   Modelo de RAM (por ejemplo, "16GB").
     * @param cantidad Cantidad no usada en esta implementación.
     * @return Instancia de AdataRAM.
     * @throws IllegalArgumentException Si el modelo no es válido.
     */
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

    /**
     * Crea un disco SSD Samsung de acuerdo al modelo proporcionado.
     *
     * @param modelo Modelo de disco (ej. "500GB").
     * @return Instancia de SSD.
     * @throws IllegalArgumentException Si el modelo no es válido.
     */
    @Override
    public Disco crearDisco(String modelo) {
        switch (modelo) {
            case "500GB":
                return new SSD("SSD 500GB", 60, "Samsung", 500, "NVMe");
            case "1TB":
                return new SSD("SSD 1TB", 100, "Samsung", 1000, "NVMe");
            default:
                throw new IllegalArgumentException("Modelo de Disco no válido");
        }
    }

    /**
     * Crea una fuente de poder predeterminada EVGA de 600W.
     *
     * @param modelo Ignorado en esta implementación.
     * @return Instancia de EVGAFuentePoder.
     */
    @Override
    public FuentePoder crearFuentePoder(String modelo) {
        switch (modelo) {
            case "600W":
                return new EVGAFuentePoder("EVGA 600W", 50, 600, "80+ Bronze");
            case "750W":
                return new EVGAFuentePoder("EVGA 750W", 80, 750, "80+ Gold");
            default:
                throw new IllegalArgumentException("Modelo de Fuente no válido");
        }
    }

    /**
     * Crea una motherboard ASUS compatible con Intel.
     *
     * @param modelo Modelo de motherboard (ej. "Z590").
     * @return Instancia de ASUSMotherboard.
     * @throws IllegalArgumentException Si el modelo no es válido.
     */
    @Override
    public Motherboard crearMotherboard(String modelo) {
        switch (modelo) {
            case "Z590":
                return new ASUSMotherboard("ASUS Z590", 250, "Z590", "LGA1200");
            case "Z690":
                return new ASUSMotherboard("ASUS Z690", 350, "Z690", "LGA1700");
            default:
                throw new IllegalArgumentException("Modelo de Motherboard Intel no válido");
        }
    }

    /**
     * Crea un gabinete predeterminado NZXT H510.
     *
     * @param modelo Ignorado en esta implementación.
     * @return Instancia de NZXTGabinete.
     */
    @Override
    public Gabinete crearGabinete(String modelo) {
        switch (modelo) {
            case "NZXT H510":
                return new NZXTGabinete("NZXT H510", 70, "ATX", true);
            case "Lian Li O11":
                return new NZXTGabinete("Lian Li O11", 150, "ATX", false);
            default:
                throw new IllegalArgumentException("Modelo de Gabinete no válido");
        }
    }
}