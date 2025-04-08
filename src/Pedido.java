/**
 * Clase con los datos del pedido del cliente.
 */
public class Pedido {

    private String idPedido;
    private EstadoEnvio estadoActual;
    private String sucursalDestino;
    private String direccionEntrega;

    public Pedido(String idPedido, String sucursalDestino, String direccionEntrega) {
        this.idPedido = idPedido;
        this.sucursalDestino = sucursalDestino;
        this.direccionEntrega = direccionEntrega;
        this.estadoActual = new EstadoProceso();
    }

    public void avanzarEstado() {
        estadoActual.procesarEstado(this);// Lógica para cambiar de estado
    }


    public String getIdPedido() {
        return idPedido;
    }

    public EstadoEnvio getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoEnvio estadoActual) {
        this.estadoActual = estadoActual;
    }

}