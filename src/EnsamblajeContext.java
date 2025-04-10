import java.util.ArrayList;
import java.util.List;

/**
 * Contexto principal para el proceso de ensamblaje de computadoras
 * Controla el flujo de estados y mantiene los componentes seleccionados
 */
public class EnsamblajeContext {
    private EnsamblajeEstado estado;
    private ComputadoraBuilder builder;
    private boolean esPrearmado;
    private String sucursalActual;
    private String direccionEntrega;
    private List<SoftwareAdicional> softwareAdicional;

    /**
     * Constructor inicializa el contexto con estado inicial
     */
    public EnsamblajeContext(String sucursalActual) {
        this.estado = new SeleccionTipoEstado();
        this.builder = new ComputadoraBuilder();
        this.sucursalActual = sucursalActual;
        this.softwareAdicional = new ArrayList<>();
    }

    /**
     * Procesa el estado actual del ensamblaje
     */
    public void procesar() {
        estado.procesar(this);
    }

    /**
     * Maneja la configuración prearmada
     */
    public void manejarPrearmado() {
        if (esPrearmado) {
            ComponenteFactory factory = new IntelNvidiaFactory();
            builder.agregarCPU(factory.crearCPU("i5-13600K"))
                  .agregarRAM(factory.crearRAM("16GB", 1))
                  .agregarGPU(factory.crearGPU("RTX 3060"))
                  .agregarDisco(factory.crearDisco("500GB"))
                  .agregarFuentePoder(factory.crearFuentePoder("600W"));
        }
    }

    // Métodos para agregar componentes
    public void agregarCPU(CPU cpu) {
        builder.agregarCPU(cpu);
    }

    public void agregarRAM(RAM ram) {
        builder.agregarRAM(ram);
    }

    public void agregarSoftware(SoftwareAdicional software) {
        if (!softwareAdicional.contains(software)) {
            softwareAdicional.add(software);
        }
    }

    // Getters y Setters
    public ComputadoraBuilder getBuilder() {
        return builder;
    }

    public boolean esPrearmado() {
        return esPrearmado;
    }

    public void setPrearmado(boolean esPrearmado) {
        this.esPrearmado = esPrearmado;
    }

    public EnsamblajeEstado getEstado() {
        return estado;
    }

    public void setState(EnsamblajeEstado estado) {
        this.estado = estado;
    }

    public String getSucursalActual() {
        return sucursalActual;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public List<SoftwareAdicional> getSoftwareAdicional() {
        return softwareAdicional;
    }

    /**
     * Crea un nuevo pedido con la configuración actual
     */
    public Pedido crearPedido() {
        Computadora computadora = builder.build();
        computadora.setSoftware(softwareAdicional);
        return new Pedido(generarIdPedido(), sucursalActual, direccionEntrega, computadora);
    }

    private String generarIdPedido() {
        return "PED-" + System.currentTimeMillis();
    }
}