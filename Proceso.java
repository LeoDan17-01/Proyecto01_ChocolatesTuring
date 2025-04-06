public class Pedido {
    private String idPedido;
    private EstadoEnvio estadoActual;
    private String sucursalDestino;
    private String direccionEntrega;

    public Pedido(String idPedido, String sucursalDestino, String direccionEntrega) {
        // Inicialización
    }

    public void avanzarEstado() {
        // Lógica para cambiar de estado
    }
    
    // Getters y otros métodos
}