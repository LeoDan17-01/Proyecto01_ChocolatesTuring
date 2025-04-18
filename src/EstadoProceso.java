public class EstadoProceso implements EstadoEnvio {
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

    @Override
    public String getDescripcionEstado() {
        return "En proceso de preparación";
    }

    @Override
    public String getInstruccionesSeguimiento() {
        return "El pedido está siendo verificado y preparado para ensamblaje";
    }

    private void avanzarEstado(Pedido pedido, EstadoEnvio siguienteEstado) {
        pedido.setEstadoActual(siguienteEstado);
        System.out.println("Estado cambiado a: " + siguienteEstado.getDescripcionEstado());
    }
}