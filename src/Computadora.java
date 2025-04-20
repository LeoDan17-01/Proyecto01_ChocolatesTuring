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

    // Getters y Setters
    public CPU getCpu() { return cpu; }
    public void setCpu(CPU cpu) { this.cpu = cpu; }

    public List<RAM> getRams() { return rams; }
    public void setRams(List<RAM> rams) { this.rams = rams; }

    public GPU getGpu() { return gpu; }
    public void setGpu(GPU gpu) { this.gpu = gpu; }

    public List<Disco> getDiscos() { return discos; }
    public void setDiscos(List<Disco> discos) { this.discos = discos; }

    public FuentePoder getFuente() { return fuente; }
    public void setFuente(FuentePoder fuente) { this.fuente = fuente; }

    public Motherboard getMotherboard() { return motherboard; }
    public void setMotherboard(Motherboard motherboard) { this.motherboard = motherboard; }

    public Gabinete getGabinete() { return gabinete; }
    public void setGabinete(Gabinete gabinete) { this.gabinete = gabinete; }

    public List<SoftwareAdicional> getSoftware() { return software; }
    public void setSoftware(List<SoftwareAdicional> software) { this.software = software; }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    /**
     * Crea un nuevo pedido asociado a esta computadora.
     *
     * @param nombreSucursal   Nombre de la sucursal destino.
     * @param direccionEntrega Dirección de entrega.
     */
    public void crearPedido(String nombreSucursal, String direccionEntrega) {
        // Buscar la sucursal real del Distribuidor
        Sucursal sucursal = Distribuidor.getInstance().getSucursales().stream()
            .filter(s -> s.getNombre().equalsIgnoreCase(nombreSucursal))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Sucursal no encontrada: " + nombreSucursal));
        
        this.pedido = new Pedido(
            "PED-" + System.currentTimeMillis(),
            sucursal,  // Pasamos el objeto Sucursal, no el String
            direccionEntrega,
            this
        );
    }

    /**
     * Calcula el precio total de la computadora.
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

    @Override
    public String toString() {
        return "Computadora [CPU=" + cpu.getDescripcion() + 
               ", Precio Total=$" + calcularPrecioTotal() + "]";
    }
}