import java.util.List;
import java.util.ArrayList;

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

    // Constructor principal
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

    // Getters
    public CPU getCpu() { return cpu; }
    public List<RAM> getRams() { return rams; }
    public GPU getGpu() { return gpu; }
    public List<Disco> getDiscos() { return discos; }
    public FuentePoder getFuente() { return fuente; }
    public Motherboard getMotherboard() { return motherboard; }
    public Gabinete getGabinete() { return gabinete; }
    public List<SoftwareAdicional> getSoftware() { return software; }
    public Pedido getPedido() { return pedido; }

    // Setters
    public void setCpu(CPU cpu) { this.cpu = cpu; }
    public void setRams(List<RAM> rams) { this.rams = (rams != null) ? rams : new ArrayList<>(); }
    public void setGpu(GPU gpu) { this.gpu = gpu; }
    public void setDiscos(List<Disco> discos) { this.discos = (discos != null) ? discos : new ArrayList<>(); }
    public void setFuente(FuentePoder fuente) { this.fuente = fuente; }
    public void setMotherboard(Motherboard motherboard) { this.motherboard = motherboard; }
    public void setGabinete(Gabinete gabinete) { this.gabinete = gabinete; }
    public void setSoftware(List<SoftwareAdicional> software) { 
        this.software = (software != null) ? software : new ArrayList<>(); 
    }

    /**
     * Calcula el precio total sumando todos los componentes y software.
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
     */
    public void crearPedido(String sucursalDestino, String direccionEntrega) {
        this.pedido = new Pedido("PED-" + System.currentTimeMillis(), 
                                sucursalDestino, 
                                direccionEntrega, 
                                this);
    }

    @Override
    public String toString() {
        return "Computadora [CPU=" + cpu.getDescripcion() + 
               ", Precio Total=$" + calcularPrecioTotal() + "]";
    }
}