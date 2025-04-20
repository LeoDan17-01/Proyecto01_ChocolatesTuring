import java.util.ArrayList;
import java.util.List;

/**
 * Builder para la construcción paso a paso de una Computadora.
 */
public class ComputadoraBuilder {
    private Computadora computadora;
    private List<RAM> rams = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();

    /**
     * Constructor que inicializa una computadora vacía con listas por defecto.
     */
    public ComputadoraBuilder() {
        this.computadora = new Computadora(null, null, null, null, null, null, null);
    }

    /**
     * Agrega una CPU a la computadora.
     *
     * @param cpu CPU a agregar.
     * @return Instancia del builder.
     */
    public ComputadoraBuilder agregarCPU(CPU cpu) {
        computadora.setCpu(cpu);
        return this;
    }

    /**
     * Agrega una memoria RAM a la computadora.
     *
     * @param ram RAM a agregar.
     * @return Instancia del builder.
     */
    public ComputadoraBuilder agregarRAM(RAM ram) {
        rams.add(ram);
        return this;
    }

    /**
     * Agrega un disco de almacenamiento a la computadora.
     *
     * @param disco Disco a agregar.
     * @return Instancia del builder.
     */
    public ComputadoraBuilder agregarDisco(Disco disco) {
        discos.add(disco);
        return this;
    }

    /**
     * Agrega una tarjeta gráfica a la computadora.
     *
     * @param gpu GPU a agregar.
     * @return Instancia del builder.
     */
    public ComputadoraBuilder agregarGPU(GPU gpu) {
        computadora.setGpu(gpu);
        return this;
    }

    /**
     * Agrega una fuente de poder.
     *
     * @param fuente Fuente de poder a agregar.
     * @return Instancia del builder.
     */
    public ComputadoraBuilder agregarFuentePoder(FuentePoder fuente) {
        computadora.setFuente(fuente);
        return this;
    }

    /**
     * Agrega una placa madre.
     *
     * @param motherboard Motherboard a agregar.
     * @return Instancia del builder.
     */
    public ComputadoraBuilder agregarMotherboard(Motherboard motherboard) {
        computadora.setMotherboard(motherboard);
        return this;
    }

    /**
     * Agrega un gabinete.
     *
     * @param gabinete Gabinete a agregar.
     * @return Instancia del builder.
     */
    public ComputadoraBuilder agregarGabinete(Gabinete gabinete) {
        computadora.setGabinete(gabinete);
        return this;
    }

    /**
     * Construye y retorna la Computadora.
     *
     * @return Instancia construida de Computadora.
     * @throws IllegalStateException si no se ha configurado al menos la CPU o la RAM.
     */
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