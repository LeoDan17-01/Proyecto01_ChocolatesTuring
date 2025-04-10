public class ComputadoraBuilder {
    private Computadora computadora = new Computadora();
    private List<RAM> rams = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();

    public ComputadoraBuilder agregarCPU(CPU cpu) {
        computadora.setCpu(cpu);
        return this;
    }

    public ComputadoraBuilder agregarRAM(RAM ram) {
        rams.add(ram);
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