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
            case "GTX 1660":
                return new NvidiaGPU("NVIDIA GTX 1660", 2500, "GDDR6", 12);
            case "RTX 3060":
                return new NvidiaGPU("NVIDIA RTX 3060", 3000, "GDDR6", 16);
            case "RTX 4070":
                return new NvidiaGPU("NVIDIA RTX 4070", 4500, "GDDR6", 18);
            case "RTX 4080":
                return new NvidiaGPU("NVIDIA RTX 4080", 6000, "GDDR6", 19);
            case "RTX 4090":
                return new NvidiaGPU("NVIDIA RTX 4090", 8000, "GDDR6", 20);
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
            case "8GB":
                return new AdataRAM("Adata 8GB", 800, 8, "DDR4", 3200);
            case "16GB":
                return new AdataRAM("Adata 16GB", 1500, 16, "DDR4", 3200);
            case "32GB":
                return new AdataRAM("Adata 32GB", 2800, 32, "DDR4", 3200);
            case "8GB-K":
                return new KingstonRAM("Kingston 8GB", 850, 8, "DDR4", 3200);
            case "16GB-K":
                return new KingstonRAM("Kingston 16GB", 1600, 16, "DDR4", 3200);
            case "32GB-K":
                return new KingstonRAM("Kingston 32GB", 3000, 32, "DDR4", 3200);
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
            case "500GB-WDB":
                return new WDBlueHDD("Western Digital Blue 500GB", 700, "Samsung", 500, "NVMe");
            case "1TB-WDB":
                return new WDBlueHDD("Western Digital Blue 1TB", 1000, "Samsung", 1000, "NVMe");
            case "1TB-S":
                return new SeagateHDD("Seagate Barracuda 1TB", 1100, "Samsung", 1000, "NVMe");
            case "2TB-S":
                return new SeagateHDD("Seagate Barracuda 2TB", 1600, "Samsung", 2000, "NVMe");
            case "500GB-K":
                return new KingstonSSD("Kingston SSD 500GB", 1200, "Samsung", 500, "NVMe");
            case "1TB-K":
                return new KingstonSSD("Kingston SSD 1TB", 1800, "Samsung", 1000, "NVMe");
            case "2TB-K":
                return new KingstonSSD("Kingston SSD 2TB", 2500, "Samsung", 2000, "NVMe");
            case "4TB-K":
                return new KingstonSSD("Kingston SSD 4TB", 4000, "Samsung", 4000, "NVMe");
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
            case "800W":
                return new EVGAFuentePoder("EVGA 800W", 1000, 800, "80+ Bronze");
            case "1000W":
                return new EVGAFuentePoder("EVGA 750W", 1300, 1000, "80+ Gold");
            case "1500W":
                return new EVGAFuentePoder("EVGA 1500W", 1800, 1500, "80+ Gold");
            case "800W-C":
                return new CorsairFuentePoder("Corsair 800W", 1050, 800, "80+ Bronze");
            case "1200W-C":
                return new CorsairFuentePoder("Corsair 1200W", 1600, 1200, "80+ Gold");
            case "1500W-C":
                return new CorsairFuentePoder("Corsair 1500W", 1900, 1500, "80+ Gold");
            case "500W-X":
                return new XPGFuentePoder("XPG 700W", 1000, 500, "80+ Bronze");
            case "700W-X":
                return new XPGFuentePoder("XPG 900W", 1300, 700, "80+ Gold");
            case "1000W-X":
                return new XPGFuentePoder("XPG 1300W", 1900, 1000, "80+ Gold");
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
            case "Z790":
                return new ASUSMotherboard("ASUS ROG Maximus Z790 Hero", 5000, "Z790", "LGA1200");
            case "B760":
                return new ASUSMotherboard("ASUS TUF Gaming B760-Plus WIFI D4", 3200, "B760", "LGA1700");
            case "MEG":
                return new MSIMotherboard("MSI MEG Godlike", 6000, "Z790", "LGA3000");
            case "B760-MAG":
                return new MSIMotherboard("MSI MAG B760 Tomahawk WIFI DDR4", 3500, "B760", "LGA1800");
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
            case "NZXT":
                return new NZXTGabinete("NZXT H6 Flow ATX", 2000, "ATX", true);
            case "Yeyian":
                return new YeyianGabinete("Yeyian Lancer ATX", 1800, "ATX", false);
            default:
                throw new IllegalArgumentException("Modelo de Gabinete no válido");
        }
    }
}