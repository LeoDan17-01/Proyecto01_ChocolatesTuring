import java.util.List;
import java.util.ArrayList;

/**
 * Representa una computadora armada con sus respectivos componentes y software adicional.
 */
public class Computadora {
    private CPU cpu;
    private List<RAM> rams;
    private GPU gpu;
    private List<Disco> discos;
    private FuentePoder fuente;
    private Motherboard motherboard;
    private Gabinete gabinete;
    private List<SoftwareAdicional> software;
    private Pedido pedido;

    /**
     * Constructor principal de Computadora.
     *
     * @param cpu         CPU instalada.
     * @param rams        Lista de memorias RAM.
     * @param gpu         Tarjeta gráfica.
     * @param discos      Lista de discos de almacenamiento.
     * @param fuente      Fuente de poder.
     * @param motherboard Placa madre.
     * @param gabinete    Gabinete.
     */
    public Computadora(CPU cpu, List<RAM> rams, GPU gpu, List<Disco> discos,
                      FuentePoder fuente, Motherboard motherboard, Gabinete gabinete) {
        this.cpu = cpu;
        this.rams = (rams != null) ? rams : new ArrayList<>();
        this.gpu = gpu;
        this.discos = (discos != null) ? discos : new ArrayList<>();
        this.fuente = fuente;
        this.motherboard = motherboard;
        this.gabinete = gabinete;
        this.software = new ArrayList<>();
    }

    /**
     * Obtiene la CPU instalada.
     * @return CPU actual.
     */
    public CPU getCpu() { return cpu; }

    /**
     * Obtiene la lista de memorias RAM instaladas.
     * @return Lista de RAM.
     */
    public List<RAM> getRams() { return rams; }

    /**
     * Obtiene la tarjeta gráfica.
     * @return GPU instalada.
     */
    public GPU getGpu() { return gpu; }

    /**
     * Obtiene los discos de almacenamiento.
     * @return Lista de discos.
     */
    public List<Disco> getDiscos() { return discos; }

    /**
     * Obtiene la fuente de poder.
     * @return Fuente de poder.
     */
    public FuentePoder getFuente() { return fuente; }

    /**
     * Obtiene la motherboard.
     * @return Motherboard instalada.
     */
    public Motherboard getMotherboard() { return motherboard; }

    /**
     * Obtiene el gabinete.
     * @return Gabinete.
     */
    public Gabinete getGabinete() { return gabinete; }

    /**
     * Obtiene la lista de software adicional instalado.
     * @return Lista de software.
     */
    public List<SoftwareAdicional> getSoftware() { return software; }

    /**
     * Obtiene el pedido asociado a esta computadora.
     * @return Pedido actual.
     */
    public Pedido getPedido() { return pedido; }

    /**
     * Establece la CPU.
     * @param cpu CPU a instalar.
     */
    public void setCpu(CPU cpu) { this.cpu = cpu; }

    /**
     * Establece las memorias RAM.
     * @param rams Lista de RAM.
     */
    public void setRams(List<RAM> rams) { this.rams = (rams != null) ? rams : new ArrayList<>(); }
    
    /**
     * Establece la GPU.
     * @param gpu Tarjeta gráfica.
     */
    public void setGpu(GPU gpu) { this.gpu = gpu; }

    /**
     * Establece los discos de almacenamiento.
     * @param discos Lista de discos.
     */
    public void setDiscos(List<Disco> discos) { this.discos = (discos != null) ? discos : new ArrayList<>(); }

    /**
     * Establece la fuente de poder.
     * @param fuente Fuente a utilizar.
     */
    public void setFuente(FuentePoder fuente) { this.fuente = fuente; }

    /**
     * Establece la motherboard.
     * @param motherboard Placa madre.
     */
    public void setMotherboard(Motherboard motherboard) { this.motherboard = motherboard; }

    /**
     * Establece el gabinete.
     * @param gabinete Gabinete.
     */
    public void setGabinete(Gabinete gabinete) { this.gabinete = gabinete; }

    /**
     * Establece el software adicional.
     * @param software Lista de software.
     */
    public void setSoftware(List<SoftwareAdicional> software) { 
        this.software = (software != null) ? software : new ArrayList<>(); 
    }

    /**
     * Calcula el precio total de la computadora, sumando todos los componentes y software adicional.
     *
     * @return Precio total en formato decimal.
     */
    public double calcularPrecioTotal() {
        double total = 0;
        total += (cpu != null) ? cpu.getPrecio() : 0;
        
        for (RAM ram : rams) {
            total += ram.getPrecio();
        }
        
        total += (gpu != null) ? gpu.getPrecio() : 0;
        
        for (Disco disco : discos) {
            total += disco.getPrecio();
        }
        
        total += (fuente != null) ? fuente.getPrecio() : 0;
        total += (motherboard != null) ? motherboard.getPrecio() : 0;
        total += (gabinete != null) ? gabinete.getPrecio() : 0;
        
        for (SoftwareAdicional soft : software) {
            total += soft.getPrecio();
        }
        
        return total;
    }

    /**
     * Crea un nuevo pedido asociado a esta computadora.
     *
     * @param sucursalDestino     Sucursal donde se entregará.
     * @param direccionEntrega    Dirección de entrega.
     */
    public void crearPedido(String sucursalDestino, String direccionEntrega) {
        this.pedido = new Pedido("PED-" + System.currentTimeMillis(), 
                                sucursalDestino, 
                                direccionEntrega, 
                                this);
    }

    /**
     * Devuelve una representación textual de la computadora.
     *
     * @return Cadena con descripción y precio total.
     */
    @Override
    public String toString() {
        return "Computadora [CPU=" + cpu.getDescripcion() + 
               ", Precio Total=$" + calcularPrecioTotal() + "]";
    }
}