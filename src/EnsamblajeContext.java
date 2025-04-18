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
        System.out.println("Cargando configuración prearmada...");
        builder.agregarCPU(factory.crearCPU("i5-13600K"))
              .agregarRAM(factory.crearRAM("16GB", 1))
              .agregarGPU(factory.crearGPU("RTX 3060"))
              .agregarDisco(factory.crearDisco("500GB"))
              .agregarFuentePoder(factory.crearFuentePoder("600W"))
              .agregarMotherboard(factory.crearMotherboard("Z590"))
              .agregarGabinete(factory.crearGabinete("NZXT H510"));
        this.esPrearmado = true;
    }

    public void iniciarPersonalizado() {
        System.out.println("Iniciando configuración personalizada...");
        this.esPrearmado = false;
        this.builder = new ComputadoraBuilder();
        this.estado = new EstadoSeleccionComponentes();
    }

    // Métodos para agregar componentes (TODOS implementados)
    public void agregarCPU(CPU cpu) {
        builder.agregarCPU(cpu);
        System.out.println("CPU agregado: " + cpu.getDescripcion());
    }

    public void agregarRAM(RAM ram) {
        builder.agregarRAM(ram);
        System.out.println("RAM agregada: " + ram.getDescripcion());
    }

    public void agregarGPU(GPU gpu) {
        builder.agregarGPU(gpu);
        System.out.println("GPU agregada: " + gpu.getDescripcion());
    }

    public void agregarDisco(Disco disco) {
        builder.agregarDisco(disco);
        System.out.println("Disco agregado: " + disco.getDescripcion());
    }

    public void agregarFuentePoder(FuentePoder fuente) {
        builder.agregarFuentePoder(fuente);
        System.out.println("Fuente agregada: " + fuente.getDescripcion());
    }

    public void agregarMotherboard(Motherboard motherboard) {
        builder.agregarMotherboard(motherboard);
        System.out.println("Motherboard agregada: " + motherboard.getDescripcion());
    }

    public void agregarGabinete(Gabinete gabinete) {
        builder.agregarGabinete(gabinete);
        System.out.println("Gabinete agregado: " + gabinete.getDescripcion());
    }

    // Métodos para software
    public void agregarSoftware(SoftwareAdicional software) {
        if (!softwareAdicional.contains(software)) {
            softwareAdicional.add(software);
            System.out.println("Software agregado: " + software.getNombre());
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

    // Getters y Setters completos
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
    public ComponenteFactory getFactory() {
        return this.factory;
    }
}