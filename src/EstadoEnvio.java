public interface EstadoEnvio {
    void procesarEstado(Pedido pedido);
    String getDescripcionEstado();
    String getInstruccionesSeguimiento();
    
    // Nuevo método default para transiciones
    default void avanzarEstado(Pedido pedido, EstadoEnvio siguienteEstado) {
        pedido.setEstadoActual(siguienteEstado);
        System.out.println("Estado cambiado a: " + siguienteEstado.getDescripcionEstado());
    }
}