/**
 * Interfaz del patrón Estado para el flujo de envío del pedido.
 */
public interface EstadoEnvio {

    /**
     * Procesa la lógica del estado para el pedido dado.
     * @param pedido Pedido a procesar.
     */
    void procesarEstado(Pedido pedido);

    /**
     * Devuelve la descripción del estado de envío.
     * @return descripción textual.
     */
    String getDescripcionEstado();

    /**
     * Devuelve instrucciones sobre el seguimiento del pedido en este estado.
     * @return instrucciones al cliente.
     */
    String getInstruccionesSeguimiento();
}