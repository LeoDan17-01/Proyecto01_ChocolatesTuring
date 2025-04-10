import java.time.LocalDate;

/**
 * Clase que representa un pedido en el sistema de MonosChinos MX
 * Mantiene el estado actual del pedido y su información asociada
 */
public class Pedido {
    private String idPedido;
    private EstadoEnvio estadoActual;
    private String sucursalDestino;
    private String direccionEntrega;
    private Computadora computadora;
    private LocalDate fechaCreacion;
    private double precioTotal;

    /**
     * Constructor completo para un pedido
     */
    public Pedido(String idPedido, String sucursalDestino, String direccionEntrega, Computadora computadora) {
        this.idPedido = idPedido;
        this.estadoActual = new EstadoProceso();
        this.sucursalDestino = sucursalDestino;
        this.direccionEntrega = direccionEntrega;
        this.computadora = computadora;
        this.fechaCreacion = LocalDate.now();
        this.precioTotal = computadora.calcularPrecioTotal();
    }

    /**
     * Avanza el estado del pedido al siguiente estado lógico
     */
    public void avanzarEstado() {
        estadoActual.procesarEstado(this);
    }

    // Getters y Setters
    public String getIdPedido() {
        return idPedido;
    }

    public EstadoEnvio getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoEnvio estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getSucursalDestino() {
        return sucursalDestino;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public Computadora getComputadora() {
        return computadora;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Genera un resumen del pedido en formato String
     */
    @Override
    public String toString() {
        return "Pedido #" + idPedido + 
               "\nEstado: " + estadoActual.getDescripcionEstado() +
               "\nSucursal: " + sucursalDestino +
               "\nTotal: $" + precioTotal +
               "\nFecha: " + fechaCreacion;
    }
}