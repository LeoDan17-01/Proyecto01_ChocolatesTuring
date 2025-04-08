/**
 * Interfaz que define la estructura básica para los estados del pedido.
 */
public interface EstadoEnvio {
    void procesarEstado(Pedido pedido);
    String getDescripcionEstado();
    String getInstruccionesSeguimiento();
}