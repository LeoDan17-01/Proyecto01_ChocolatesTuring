import java.util.ArrayList;
import java.util.List;

public class EnsamblajeContext {
    private EnsamblajeEstado estado;
    private ComputadoraBuilder builder;
    private boolean esPrearmado;
    private String sucursalActual;
    private String direccionEntrega;
    private List<SoftwareAdicional> softwareAdicional;
    private ComponenteFactory factory;

    public EnsamblajeContext(String sucursalActual) {
        this.estado = new SeleccionTipoEstado();
        this.builder = new ComputadoraBuilder();
        this.sucursalActual = sucursalActual;
        this.softwareAdicional = new ArrayList<>();
        this.factory = new IntelNvidiaFactory();
        this.esPrearmado = false;
    }

    public void procesar() {
        estado.procesar(this);
    }

    public void manejarPrearmado() {
        this.esPrearmado = true;
        this.factory = new IntelNvidiaFactory();
        
        // Configuración prearmada básica
        builder.agregarCPU(factory.crearCPU("i5-13600K"))
              .agregarRAM(factory.crearRAM("16GB", 1))
              .agregarGPU(factory.crearGPU("RTX 3060"))
              .agregarDisco(factory.crearDisco("500GB"))
              .agregarFuentePoder(factory.crearFuentePoder("600W"))
              .agregarMotherboard(factory.crearMotherboard("Z590"))
              .agregarGabinete(factory.crearGabinete("NZXT H510"));
    }

    public void iniciarPersonalizado() {
        this.esPrearmado = false;
        this.builder = new ComputadoraBuilder();
        this.estado = new EstadoSeleccionComponentes();
    }

    // Métodos para agregar componentes
    public void agregarCPU(CPU cpu) {
        builder.agregarCPU(cpu);
    }

    public void agregarRAM(RAM ram) {
        builder.agregarRAM(ram);
    }

    public void agregarGPU(GPU gpu) {
        builder.agregarGPU(gpu);
    }

    public void agregarDisco(Disco disco) {
        builder.agregarDisco(disco);
    }

    public void agregarFuentePoder(FuentePoder fuente) {
        builder.agregarFuentePoder(fuente);
    }

    public void agregarMotherboard(Motherboard motherboard) {
        builder.agregarMotherboard(motherboard);
    }

    public void agregarGabinete(Gabinete gabinete) {
        builder.agregarGabinete(gabinete);
    }

    // Métodos para software
    public void agregarSoftware(SoftwareAdicional software) {
        if (!softwareAdicional.contains(software)) {
            softwareAdicional.add(software);
        }
    }

    public Pedido crearPedido() {
        Computadora computadora = builder.build();
        computadora.setSoftware(softwareAdicional);
        return new Pedido(
            "PED-" + System.currentTimeMillis(),
            sucursalActual,
            direccionEntrega,
            computadora
        );
    }

    // Getters y Setters
    public EnsamblajeEstado getEstado() { return estado; }
    public void setEstado(EnsamblajeEstado estado) { this.estado = estado; }
    public boolean isEsPrearmado() { return esPrearmado; }
    public void setEsPrearmado(boolean esPrearmado) { this.esPrearmado = esPrearmado; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }
    public String getSucursalActual() { return sucursalActual; }
    public ComputadoraBuilder getBuilder() { return builder; }
    public List<SoftwareAdicional> getSoftwareAdicional() { return softwareAdicional; }
    public void setFactory(ComponenteFactory factory) { this.factory = factory; }
    public ComponenteFactory getFactory() { return this.factory; }
    
    // Método para verificar compatibilidad
    public boolean verificarCompatibilidad() {
        Computadora comp = builder.build();
        
        // CPU + Motherboard
        if (comp.getCpu() != null && comp.getMotherboard() != null) {
            if (!comp.getCpu().getSocket().equals(comp.getMotherboard().getTipoSocket())) {
                return false;
            }
        }
        
        // RAM + Motherboard
        if (!comp.getRams().isEmpty() && comp.getMotherboard() != null) {
            String tipoRamEsperado = comp.getMotherboard().getChipset().contains("DDR5") ? "DDR5" : "DDR4";
            for (RAM ram : comp.getRams()) {
                if (!ram.getTipoMemoria().equals(tipoRamEsperado)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // Método para adaptar componentes incompatibles
    public Componente adaptarComponente(Componente componente) {
        if (componente instanceof AMDCPU) {
            AMDCPU amdCpu = (AMDCPU) componente;
            return new IntelCPU(
                "Intel Equivalente",
                amdCpu.getPrecio() * 1.1,
                amdCpu.getNumNucleos(),
                "LGA1200"
            );
        }
        return componente;
    }
}