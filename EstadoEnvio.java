public interface EstadoEnvio {
    void procesarEstado(Pedido pedido);
    String getDescripcionEstado();
    String getInstruccionesSeguimiento();
}