import java.util.ArrayList;
import java.util.List;

public class ComputadoraBuilder {
    private Computadora computadora;
    private List<RAM> rams = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();

    public ComputadoraBuilder() {
        // Inicializamos con valores por defecto o null
        this.computadora = new Computadora(null, null, null, null, null, null, null);
    }

    public ComputadoraBuilder agregarCPU(CPU cpu) {
        computadora.setCpu(cpu);
        return this;
    }

    public ComputadoraBuilder agregarRAM(RAM ram) {
        rams.add(ram);
        return this;
    }

    public ComputadoraBuilder agregarDisco(Disco disco) {
        discos.add(disco);
        return this;
    }

    public ComputadoraBuilder agregarGPU(GPU gpu) {
        computadora.setGpu(gpu);
        return this;
    }

    public ComputadoraBuilder agregarFuentePoder(FuentePoder fuente) {
        computadora.setFuente(fuente);
        return this;
    }

    public ComputadoraBuilder agregarMotherboard(Motherboard motherboard) {
        computadora.setMotherboard(motherboard);
        return this;
    }

    public ComputadoraBuilder agregarGabinete(Gabinete gabinete) {
        computadora.setGabinete(gabinete);
        return this;
    }

    public Computadora build() throws IllegalStateException {
        if (computadora.getCpu() == null) {
            throw new IllegalStateException("CPU no seleccionado");
        }
        if (rams.isEmpty()) {
            throw new IllegalStateException("RAM no seleccionada");
        }
        
        computadora.setRams(rams);
        computadora.setDiscos(discos);
        return computadora;
    }
}