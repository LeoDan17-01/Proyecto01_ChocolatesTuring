public interface ComponenteFactory {
    CPU crearCPU(String modelo);
    GPU crearGPU(String modelo);
    RAM crearRAM(String modelo, int cantidad);
    Disco crearDisco(String modelo);
    FuentePoder crearFuentePoder(String modelo);
    Motherboard crearMotherboard(String modelo);
    Gabinete crearGabinete(String modelo);
}