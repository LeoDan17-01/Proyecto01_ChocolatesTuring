import java.time.LocalDate;

/**
 * Representa un pedido realizado por el cliente.
 * Contiene la computadora ensamblada, direccion de entrega y estado del envio.
 */
public class Pedido {
    private String idPedido;
    private EstadoEnvio estadoActual;
    private Sucursal sucursalOrigen;
    private Sucursal sucursalDestino;
    private String direccionEntrega;
    private Computadora computadora;
    private LocalDate fechaCreacion;
    private double precioTotal;

    /**
     * Crea un nuevo pedido con los datos iniciales.
     *
     * @param idPedido          ID unico del pedido.
     * @param sucursalOrigen    Sucursal de origen.
     * @param direccionEntrega  Direccion de entrega del pedido.
     * @param computadora       Computadora asociada al pedido.
     */
    public Pedido(String idPedido, Sucursal sucursalOrigen, String direccionEntrega, Computadora computadora) {
        this.idPedido = idPedido;
        this.estadoActual = new EstadoProceso();
        this.sucursalOrigen = sucursalOrigen;
        this.direccionEntrega = direccionEntrega;
        this.computadora = computadora;
        this.fechaCreacion = LocalDate.now();
        this.precioTotal = computadora.calcularPrecioTotal();
        
        // Determinar la sucursal destino
        if(!sucursalOrigen.isCentral()) {
            this.sucursalDestino = Distribuidor.getInstance().getSucursales().stream()
                .filter(Sucursal::isCentral)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró sucursal central"));
        } else {
            this.sucursalDestino = sucursalOrigen;
        }
    }

    /**
     * Avanza el estado del pedido al siguiente estado del flujo.
     */
    public void avanzarEstado() {
        estadoActual.procesarEstado(this);
    }

    /**
     * Obtiene el ID unico del pedido.
     *
     * @return Identificador del pedido (ej. "PED-123456").
     */
    public String getIdPedido() {
        return idPedido;
    }

    /**
     * Devuelve el estado actual del pedido dentro del proceso de envio.
     *
     * @return Estado actual como objeto EstadoEnvio.
     */
    public EstadoEnvio getEstadoActual() {
        return estadoActual;
    }

    /**
     * Devuelve la sucursal de origen del pedido.
     *
     * @return Objeto Sucursal de origen.
     */
    public Sucursal getSucursalOrigen() {
        return sucursalOrigen;
    }

    /**
     * Devuelve la sucursal de destino del pedido.
     *
     * @return Objeto Sucursal de destino.
     */
    public Sucursal getSucursalDestino() {
        return sucursalDestino;
    }

    /**
     * Devuelve la direccion de entrega del pedido.
     *
     * @return Direccion completa del cliente.
     */
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    /**
     * Obtiene la computadora asociada a este pedido.
     *
     * @return Objeto Computadora ensamblada.
     */ 
    public Computadora getComputadora() {
        return computadora;
    }

    /**
     * Obtiene la fecha en que se creo el pedido.
     *
     * @return Fecha de creacion como LocalDate.
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Obtiene el precio total del pedido, incluyendo hardware y software.
     *
     * @return Precio total como valor decimal.
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Establece un nuevo estado para el pedido.
     *
     * @param estadoActual Estado actual a asignar.
     */
    public void setEstadoActual(EstadoEnvio estadoActual) {
        this.estadoActual = estadoActual;
        System.out.println("Estado del pedido actualizado a: " + estadoActual.getDescripcionEstado());
    }

    /**
     * Establece la direccion de entrega para el pedido.
     *
     * @param direccionEntrega Direccion completa donde se entregara la computadora.
     */
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    /**
     * Devuelve el resumen textual del pedido.
     *
     * @return Informacion completa del pedido.
     */
    @Override
    public String toString() {
        return String.format(
            "Pedido #%s [Origen: %s, Destino: %s]%n" +
            "Total: $%.2f%n" +
            "Fecha: %s%n" +
            "Estado: %s",
            idPedido, 
            sucursalOrigen.getNombre(),
            sucursalDestino.getNombre(), 
            precioTotal, 
            fechaCreacion,
            estadoActual.getDescripcionEstado());
    }
}