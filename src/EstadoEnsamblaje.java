/**
 * Estado del proceso de envío en el que la computadora está siendo ensamblada.
 * 
 * Este estado representa el momento en que los técnicos están montando los componentes
 * seleccionados por el cliente en la computadora.
 */
public class EstadoEnsamblaje implements EstadoEnvio {

    /**
     * Procesa el pedido en el estado de ensamblaje.
     * Simula el armado de la computadora y avanza al siguiente estado.
     *
     * @param pedido El pedido que se está procesando.
     */
    @Override
    public void procesarEstado(Pedido pedido) {
        System.out.println("\n=== ENSAMBLAJE DE COMPONENTES ===");
        
        try {
            Computadora computadora = pedido.getComputadora();
            System.out.println("Ensamblando componentes...");
            
            // Proceso de ensamblaje
            System.out.println("- CPU: " + computadora.getCpu().getDescripcion());
            System.out.println("- GPU: " + computadora.getGpu().getDescripcion());
            System.out.println("- Ensamblaje completado");
            
            // Transición al siguiente estado
            pedido.setEstadoActual(new EstadoVerificacion());
            
        } catch (Exception e) {
            System.err.println("Error en ensamblaje: " + e.getMessage());
            pedido.setEstadoActual(new EstadoProceso());
        }
    }

    /**
     * Devuelve una descripción corta del estado actual.
     *
     * @return Texto descriptivo del estado "En ensamblaje".
     */
    @Override
    public String getDescripcionEstado() {
        return "En proceso de ensamblaje físico";
    }

    /**
     * Proporciona instrucciones al usuario sobre el estado actual del pedido.
     *
     * @return Instrucciones para el cliente.
     */
    @Override
    public String getInstruccionesSeguimiento() {
        return "Los componentes están siendo ensamblados por nuestros técnicos";
    }
}