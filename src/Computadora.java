import java.util.List;

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

    // Constructor, getters y setters
    
    public Computadora(CPU cpu, List<RAM> rams, GPU gpu, List<Disco> discos, FuentePoder fuente, Motherboard motherboard, Gabinete gabinete) {
        this.cpu = cpu;
        this.rams = rams;
        this.gpu = gpu;
        this.discos = discos;
        this.fuente = fuente;
        this.motherboard = motherboard;
        this.gabinete = gabinete;
        this.software = software;
    }
    public CPU getCpu() {
        return cpu;
    }

    public List<RAM> getRams() {
        return rams;
    }

    public GPU getGpu() {
        return gpu;
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public FuentePoder getFuente() {
        return fuente;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public Gabinete getGabinete() {
        return gabinete;
    }

    public List<SoftwareAdicional> getSoftware() {
        return software;
    }

    public void setSoftware(List<SoftwareAdicional> software) {
        this.software = software;
    }

    public double calcularPrecioTotal() {
        double total = 0;
        total += cpu.getPrecio();
        for (RAM ram : rams) {
            total += ram.getPrecio();
        }
        total += gpu.getPrecio();
        for (Disco disco : discos) {
            total += disco.getPrecio();
        }
        total += fuente.getPrecio();
        total += motherboard.getPrecio();
        total += gabinete.getPrecio();
        for (SoftwareAdicional soft : software) {
            total += soft.getPrecio();
        }
        return total;
    }
    
    
    public void crearPedido(String sucursalDestino, String direccionEntrega) {
        pedido = new Pedido("PED-" + System.currentTimeMillis(), sucursalDestino, direccionEntrega, this);
    }

    @Override
    public String toString() {
        return "Computadora: " + cpu.getDescripcion() + ", Precio Total: $" + calcularPrecioTotal();
    }
}