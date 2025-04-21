import java.util.List;
import java.util.ArrayList;

/**
 * Representa una computadora personalizada compuesta por diferentes componentes de hardware
 * y software adicional, asi como su respectivo pedido de envio.
 * 
 * Esta clase forma parte del modelo dentro de una arquitectura MVC.
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
     * Crea una nueva instancia de una computadora con los componentes principales.
     *
     * @param cpu        Procesador seleccionado.
     * @param rams       Lista de modulos de memoria RAM.
     * @param gpu        Tarjeta grafica.
     * @param discos     Lista de unidades de almacenamiento (HDD o SSD).
     * @param fuente     Fuente de poder.
     * @param motherboard Placa base utilizada.
     * @param gabinete   Gabinete fisico de la computadora.
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
     * Obtiene el procesador actual de la computadora.
     * 
     * @return El objeto CPU asignado.
     */
    public CPU getCpu() { return cpu; }

    /**
     * Asigna un nuevo procesador a la computadora.
     * 
     * @param cpu Objeto CPU que se desea instalar.
     */
    public void setCpu(CPU cpu) { this.cpu = cpu; }

    /**
     * Obtiene la lista de modulos de memoria RAM instalados.
     * 
     * @return Lista de objetos RAM.
     */
    public List<RAM> getRams() { return rams; }

    /**
     * Asigna una nueva lista de modulos de memoria RAM.
     * 
     * @param rams Lista de objetos RAM a instalar.
     */
    public void setRams(List<RAM> rams) { this.rams = rams; }

    /**
     * Obtiene la tarjeta grafica instalada en la computadora.
     * 
     * @return Objeto GPU actual.
     */
    public GPU getGpu() { return gpu; }

    /**
     * Establece una nueva tarjeta grafica.
     * 
     * @param gpu Objeto GPU a asignar.
     */
    public void setGpu(GPU gpu) { this.gpu = gpu; }

    /**
     * Obtiene la lista de discos (SSD o HDD) instalados.
     * 
     * @return Lista de objetos Disco.
     */
    public List<Disco> getDiscos() { return discos; }

    /**
     * Asigna una nueva lista de discos a la computadora.
     * 
     * @param discos Lista de objetos Disco.
     */
    public void setDiscos(List<Disco> discos) { this.discos = discos; }

    /**
     * Obtiene la fuente de poder de la computadora.
     * 
     * @return Objeto FuentePoder actual.
     */
    public FuentePoder getFuente() { return fuente; }

    /**
     * Establece una nueva fuente de poder.
     * 
     * @param fuente Objeto FuentePoder a instalar.
     */
    public void setFuente(FuentePoder fuente) { this.fuente = fuente; }

    /**
     * Obtiene la motherboard instalada.
     * 
     * @return Objeto Motherboard.
     */
    public Motherboard getMotherboard() { return motherboard; }

    /**
     * Establece una nueva motherboard.
     * 
     * @param motherboard Objeto Motherboard a instalar.
     */
    public void setMotherboard(Motherboard motherboard) { this.motherboard = motherboard; }

    /**
     * Obtiene el gabinete de la computadora.
     * 
     * @return Objeto Gabinete actual.
     */
    public Gabinete getGabinete() { return gabinete; }

    /**
     * Asigna un nuevo gabinete fisico.
     * 
     * @param gabinete Objeto Gabinete a instalar.
     */

    public void setGabinete(Gabinete gabinete) { this.gabinete = gabinete; }

    /**
     * Obtiene la lista de software adicional instalado.
     * 
     * @return Lista de objetos SoftwareAdicional.
     */
    public List<SoftwareAdicional> getSoftware() { return software; }

    /**
     * Establece la lista de software adicional.
     * 
     * @param software Lista de objetos SoftwareAdicional.
     */
    public void setSoftware(List<SoftwareAdicional> software) { this.software = software; }

    /**
     * Obtiene el pedido asociado a esta computadora.
     * 
     * @return Objeto Pedido actual.
     */
    public Pedido getPedido() { return pedido; }

    /**
     * Asigna un pedido a esta computadora.
     * 
     * @param pedido Objeto Pedido que representa la orden de compra.
     */
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    /**
     * Crea un nuevo pedido asociado a esta computadora.
     *
     * @param nombreSucursal   Nombre de la sucursal destino.
     * @param direccionEntrega Direccion de entrega.
     */
    public void crearPedido(String nombreSucursal, String direccionEntrega) {
        Sucursal sucursal = Distribuidor.getInstance().getSucursales().stream()
            .filter(s -> s.getNombre().equalsIgnoreCase(nombreSucursal))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Sucursal no encontrada: " + nombreSucursal));
        
        this.pedido = new Pedido(
            "PED-" + System.currentTimeMillis(),
            sucursal,  
            direccionEntrega,
            this
        );
    }

    /**
     * Calcula el precio total de todos los componentes y software instalado.
     *
     * @return El precio final de la computadora.
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
     * Retorna una descripcion breve de la computadora, incluyendo CPU y precio total.
     *
     * @return Descripcion resumida en formato String.
     */
    @Override
    public String toString() {
        return "Computadora [CPU=" + cpu.getDescripcion() + 
               ", Precio Total=$" + calcularPrecioTotal() + "]";
    }
}