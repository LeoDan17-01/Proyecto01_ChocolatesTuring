/**
 * Interfaz del patron State para el flujo de envio del pedido.
 */
public interface EstadoEnvio {

    /**
     * Procesa la logica del estado para el pedido dado.
     * 
     * @param pedido Pedido a procesar.
     */
    void procesarEstado(Pedido pedido);

    /**
     * Devuelve la descripcion del estado de envio.
     * 
     * @return descripcion textual.
     */
    String getDescripcionEstado();

    /**
     * Devuelve instrucciones sobre el seguimiento del pedido en este estado.
     * 
     * @return instrucciones al cliente.
     */
    String getInstruccionesSeguimiento();
}