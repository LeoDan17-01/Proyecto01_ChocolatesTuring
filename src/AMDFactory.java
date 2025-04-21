/**
 * Fabrica concreta para la creacion de componentes AMD.
 * Implementa la interfaz ComponenteFactory.
 */
public class AMDFactory implements ComponenteFactory {
    /**
     * Crea una CPU AMD segun el modelo especificado.
     *
     * @param modelo Modelo de CPU deseado.
     * @return Instancia de AMDCPU.
     * @throws IllegalArgumentException si el modelo no es valido.
     */
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

    /**
     * Lanza una excepcion porque AMD no provee GPU en este sistema.
     *
     * @param modelo Modelo de GPU.
     * @return Nunca retorna, siempre lanza excepcion.
     * @throws UnsupportedOperationException Indica que no se soporta esta operacion.
     */
    @Override
    public GPU crearGPU(String modelo) {
        throw new UnsupportedOperationException("AMD no provee GPUs en este sistema");
    }
    
    /**
     * Crea una RAM de Adata para AMD.
     *
     * @param modelo Modelo de RAM (ej. "16GB").
     * @param cantidad No utilizado directamente.
     * @return Instancia de AdataRAM.
     * @throws IllegalArgumentException si el modelo no es valido.
     */
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

    /**
     * Crea un disco de almacenamiento para AMD.
     *
     * @param modelo Modelo del disco.
     * @return Instancia de SSD.
     * @throws IllegalArgumentException si el modelo no es valido.
     */
    @Override
    public Disco crearDisco(String modelo) {
        switch (modelo) {
            case "1TB":
                return new SSD("SSD 1TB", 100, "Adata", 1024, "SATA");
            default:
                throw new IllegalArgumentException("Modelo de Disco no válido");
        }
    }

    /**
     * Crea una fuente de poder generica para AMD.
     *
     * @param modelo Modelo de fuente.
     * @return Instancia de EVGAFuentePoder.
     */
    @Override
    public FuentePoder crearFuentePoder(String modelo) {
        return new EVGAFuentePoder("EVGA 600W", 50, 600, "80+ Bronze");
    }

    /**
     * Crea una motherboard ASUS compatible con AMD.
     *
     * @param modelo Modelo de motherboard.
     * @return Instancia de ASUSMotherboard.
     * @throws IllegalArgumentException si el modelo no es valido.
     */
    @Override
    public Motherboard crearMotherboard(String modelo) {
        switch (modelo) {
            case "B550":
                return new ASUSMotherboard("ASUS B550", 150, "B550", "AM4");
            default:
                throw new IllegalArgumentException("Modelo de Motherboard AMD no válido");
        }
    }

    /**
     * Crea un gabinete para la computadora.
     *
     * @param modelo Modelo del gabinete.
     * @return Instancia de NZXTGabinete.
     */
    @Override
    public Gabinete crearGabinete(String modelo) {
        return new NZXTGabinete("NZXT H510", 70, "ATX", true);
    }
}