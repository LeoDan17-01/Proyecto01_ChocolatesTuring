public class EstadoProceso implements EstadoEnvio {

    /**
     * Clase que representa un estado específico de un pedido.
     */
    private String descripcionEstado;

    public EstadoProceso(){
        this.descripcionEstado = "En proceso";
    }

    /**
     * Método que cambia el estado el pedido dependiendo su estado actual.
     */
    @Override
    public void procesarEstado(Pedido pedido) {
        if (pedido != null) {
          // Aquí el pedido pasa del estado "En proceso" a "En ensamblaje"
          System.out.println("El pedido " + pedido.getIdPedido() + " está en proceso.");
          pedido.setEstadoActual(new EstadoEnsamblaje());  // Cambiar a "En ensamblaje"
        }
    }


    @Override
    public String getDescripcionEstado() {
        return this.descripcionEstado;
    }

    @Override
    public String getInstruccionesSeguimiento() {
        return "El pedido está en proceso de ensamblaje.";
    }
    
}