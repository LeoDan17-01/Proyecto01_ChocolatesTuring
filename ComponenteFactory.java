public interface ComponenteFactory{

    CPU creaCPU(String modelo);
    GPU creaGPU(String modelo);
    RAM creaRAM(String modelo, int cantidad);
    Disco creaDisco(String modelo);
    FuentePoder creaFuentePoder(String modelo);
    Motherboard creaMotherboard(String modelo);
    Gabinete creaGabinete(String modelo);

}