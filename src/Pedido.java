import java.time.LocalDate;

public class Pedido {
    private String idPedido;
    private EstadoEnvio estadoActual;
    private String sucursalDestino;
    private String direccionEntrega;
    private Computadora computadora;
    private LocalDate fechaCreacion;
    private double precioTotal;

    public Pedido(String idPedido, String sucursalDestino, String direccionEntrega, Computadora computadora) {
        this.idPedido = idPedido;
        this.estadoActual = new EstadoProceso();
        this.sucursalDestino = sucursalDestino;
        this.direccionEntrega = direccionEntrega;
        this.computadora = computadora;
        this.fechaCreacion = LocalDate.now();
        this.precioTotal = computadora.calcularPrecioTotal();
    }

    // Métodos para avanzar el estado
    public void avanzarEstado() {
        estadoActual.procesarEstado(this);
    }

    // Getters
    public String getIdPedido() {
        return idPedido;
    }

    public EstadoEnvio getEstadoActual() {
        return estadoActual;
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

    // Setters
    public void setEstadoActual(EstadoEnvio estadoActual) {
        this.estadoActual = estadoActual;
        System.out.println("Estado del pedido actualizado a: " + estadoActual.getDescripcionEstado());
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    @Override
    public String toString() {
        return String.format(
            "Pedido #%s [Estado: %s]%n" +
            "Sucursal: %s%n" +
            "Destino: %s%n" +
            "Total: $%.2f%n" +
            "Fecha: %s",
            idPedido, estadoActual.getDescripcionEstado(),
            sucursalDestino, direccionEntrega,
            precioTotal, fechaCreacion
        );
    }
}