/**
 * Estado de envío en el que el pedido está siendo preparado para ensamblaje.
 */
public class EstadoProceso implements EstadoEnvio {

    /**
     * Procesa el pedido en el estado "En proceso".
     * Muestra mensajes de preparación y cambia al estado de ensamblaje.
     *
     * @param pedido El pedido que se va a procesar.
     */
    @Override
    public void procesarEstado(Pedido pedido) {
        if (pedido != null) {
            System.out.println("Procesando pedido " + pedido.getIdPedido() + 
                             " en sucursal: " + pedido.getSucursalDestino());
            
            if (!pedido.getSucursalDestino().equals("CDMX")) {
                System.out.println("Derivando a CDMX para ensamblaje");
            }
            
            avanzarEstado(pedido, new EstadoEnsamblaje());
        }
    }

    /**
     * Devuelve la descripción textual del estado actual.
     *
     * @return Descripción del estado.
     */
    @Override
    public String getDescripcionEstado() {
        return "En proceso de preparación";
    }

    /**
     * Proporciona instrucciones sobre el seguimiento del pedido en este estado.
     *
     * @return Instrucciones para el usuario.
     */
    @Override
    public String getInstruccionesSeguimiento() {
        return "El pedido está siendo verificado y preparado para ensamblaje";
    }

    /**
     * Avanza el pedido al siguiente estado.
     *
     * @param pedido          Pedido actual.
     * @param siguienteEstado Estado al que debe pasar.
     */
    private void avanzarEstado(Pedido pedido, EstadoEnvio siguienteEstado) {
        pedido.setEstadoActual(siguienteEstado);
        System.out.println("Estado cambiado a: " + siguienteEstado.getDescripcionEstado());
    }
}