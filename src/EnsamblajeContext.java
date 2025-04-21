import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el contexto del proceso de ensamblaje de una computadora.
 * 
 * Gestiona el estado actual del ensamblaje, los componentes seleccionados,
 * el tipo de ensamblaje (prearmado o personalizado), y la informacion del pedido.
 */
public class EnsamblajeContext {
    private EnsamblajeEstado estado;
    private ComputadoraBuilder builder;
    private boolean esPrearmado;
    private String sucursalActual;
    private String direccionEntrega;
    private List<SoftwareAdicional> softwareAdicional;
    private ComponenteFactory factory;

    /**
     * Crea un nuevo contexto de ensamblaje con una sucursal especifica.
     * 
     * @param sucursalActual Sucursal donde se esta armando la computadora.
     */
    public EnsamblajeContext(String sucursalActual) {
        this.estado = new SeleccionTipoEstado();
        this.builder = new ComputadoraBuilder();
        this.sucursalActual = sucursalActual;
        this.softwareAdicional = new ArrayList<>();
        this.factory = new IntelNvidiaFactory();
        this.esPrearmado = false;
    }

    /**
     * Reinicia el ensamblaje actual para empezar desde cero.
     */
    public void reiniciar() {
        this.builder = new ComputadoraBuilder();
        this.softwareAdicional.clear();
        this.direccionEntrega = "";
        this.esPrearmado = false;
        this.estado = new SeleccionTipoEstado();
    }

    /**
     * Procesa el estado actual del ensamblaje.
     */
    public void procesar() {
        estado.procesar(this);
    }

    /**
     * Configura una computadora con componentes predefinidos (prearmado).
     */
    public void manejarPrearmado() {
        this.esPrearmado = true;
        this.factory = new IntelNvidiaFactory();
        
        builder.agregarCPU(factory.crearCPU("i5-13600K"))
              .agregarRAM(factory.crearRAM("16GB", 1))
              .agregarGPU(factory.crearGPU("RTX 3060"))
              .agregarDisco(factory.crearDisco("500GB"))
              .agregarFuentePoder(factory.crearFuentePoder("600W"))
              .agregarMotherboard(factory.crearMotherboard("Z590"))
              .agregarGabinete(factory.crearGabinete("NZXT H510"));
    }

    /**
     * Inicia el modo de configuracion personalizada de componentes.
     */
    public void iniciarPersonalizado() {
        this.esPrearmado = false;
        this.builder = new ComputadoraBuilder();
        this.estado = new EstadoSeleccionComponentes();
    }

    /**
     * Agrega una CPU al ensamblaje actual.
     * 
     * @param cpu la CPU que se desea agregar al sistema.
     */
    public void agregarCPU(CPU cpu) {
        builder.agregarCPU(cpu);
    }

    /**
     * Agrega una memoria RAM al ensamblaje actual.
     * 
     * @param ram modulo de memoria RAM a agregar.
     */
    public void agregarRAM(RAM ram) {
        builder.agregarRAM(ram);
    }

    /**
     * Agrega una tarjeta grafica (GPU) al ensamblaje actual.
     * 
     * @param gpu tarjeta grafica a agregar.
     */
    public void agregarGPU(GPU gpu) {
        builder.agregarGPU(gpu);
    }

    /**
     * Agrega un disco de almacenamiento (HDD o SSD) al ensamblaje actual.
     * 
     * @param disco unidad de almacenamiento a agregar.
     */
    public void agregarDisco(Disco disco) {
        builder.agregarDisco(disco);
    }

    /**
     * Agrega una fuente de poder al ensamblaje actual.
     * 
     * @param fuente fuente de poder a agregar.
     */
    public void agregarFuentePoder(FuentePoder fuente) {
        builder.agregarFuentePoder(fuente);
    }

    /**
     * Agrega una motherboard al ensamblaje actual.
     * 
     * @param motherboard la motherboard a agregar.
     */
    public void agregarMotherboard(Motherboard motherboard) {
        builder.agregarMotherboard(motherboard);
    }

    /**
     * Agrega un gabinete al ensamblaje actual.
     * 
     * @param gabinete el gabinete a instalar.
     */
    public void agregarGabinete(Gabinete gabinete) {
        builder.agregarGabinete(gabinete);
    }

    /**
     * Agrega software adicional al pedido si no ha sido agregado antes.
     * 
     * @param software Software a agregar.
     */
    public void agregarSoftware(SoftwareAdicional software) {
        if (!softwareAdicional.contains(software)) {
            softwareAdicional.add(software);
        }
    }

    /**
     * Crea un objeto Pedido a partir de la configuracion actual de la computadora.
     * 
     * @return El pedido generado.
     */
    public Pedido crearPedido() {
        Computadora computadora = builder.build();
        computadora.setSoftware(softwareAdicional);
        
        Sucursal sucursal = Distribuidor.getInstance().getSucursales().stream()
            .filter(s -> s.getNombre().equalsIgnoreCase(sucursalActual))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        
        return new Pedido(
            "PED-" + System.currentTimeMillis(),
            sucursal,
            direccionEntrega,
            computadora
        );
    }

    /**
     * Verifica la compatibilidad basica entre CPU, motherboard y RAM.
     * 
     * @return true si todos los componentes son compatibles, false si hay conflicto.
     */
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
    
    /**
     * Adapta un componente incompatible a uno equivalente.
     * Actualmente solo convierte AMDCPU a IntelCPU.
     * @param componente Componente original.
     * @return Componente adaptado o el mismo si no aplica.
     */
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

    /**
     * Obtiene el estado actual del ensamblaje.
     *
     * @return Objeto que representa el estado actual del proceso de ensamblaje.
     */
    public EnsamblajeEstado getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del ensamblaje.
     *
     * @param estado Nuevo estado que se asignará.
     */
    public void setEstado(EnsamblajeEstado estado) {
        this.estado = estado;
    }

    /**
     * Indica si el ensamblaje es de tipo prearmado.
     *
     * @return true si es un prearmado, false si es personalizado.
     */
    public boolean isEsPrearmado() {
        return esPrearmado;
    }

    /**
     * Define si el ensamblaje sera prearmado o personalizado.
     *
     * @param esPrearmado true para prearmado, false para personalizado.
     */
    public void setEsPrearmado(boolean esPrearmado) {
        this.esPrearmado = esPrearmado;
    }

    /**
     * Obtiene la direccion de entrega asociada al pedido.
     *
     * @return Cadena de texto con la direccion de entrega.
     */
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    /**
     * Establece la direccion de entrega para el pedido actual.
     *
     * @param direccionEntrega Direccion donde se enviara la computadora.
     */
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    /**
     * Devuelve el nombre de la sucursal actual asociada al ensamblaje.
     *
     * @return Nombre de la sucursal como cadena de texto.
     */
    public String getSucursalActual() {
        return sucursalActual;
    }

    /**
     * Obtiene el builder actual que se esta utilizando para construir la computadora.
     *
     * @return Instancia de ComputadoraBuilder.
     */
    public ComputadoraBuilder getBuilder() {
        return builder;
    }

    /**
     * Retorna la lista de software adicional seleccionado para instalar.
     *
     * @return Lista de objetos SoftwareAdicional.
     */
    public List<SoftwareAdicional> getSoftwareAdicional() {
        return softwareAdicional;
    }

    /**
     * Devuelve la fabrica de componentes asignada para este ensamblaje.
     *
     * @return Instancia de ComponenteFactory utilizada.
     */
    public ComponenteFactory getFactory() {
        return this.factory;
    }

    /**
     * Establece la fabrica de componentes que se utilizara para generar los objetos.
     *
     * @param factory Fabrica de componentes especifica.
     */
    public void setFactory(ComponenteFactory factory) {
        this.factory = factory;
    }
}