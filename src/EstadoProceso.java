public class EstadoProceso implements EstadoEnvio {
    @Override
    public void procesarEstado(Pedido pedido) {
        if (pedido != null) {
            System.out.println("Procesando pedido " + pedido.getIdPedido() + 
                             " en sucursal: " + pedido.getSucursal());
            
            if (!pedido.getSucursal().equals("CDMX")) {
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
}