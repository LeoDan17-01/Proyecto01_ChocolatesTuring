public class ComputadoraBuilder {
    private Computadora computadora;

    public ComputadoraBuilder() {
        this.computadora = new Computadora();
    }

    public ComputadoraBuilder agregarCPU(CPU cpu) {
        // Agregar CPU
        return this;
    }

    // Métodos para agregar otros componentes
    
    public Computadora build() {
        // Validar y retornar la computadora construida
    }
}