public class EstadoEnsamblaje implements EstadoEnvio {
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

    @Override
    public String getDescripcionEstado() {
        return "En proceso de ensamblaje físico";
    }

    @Override
    public String getInstruccionesSeguimiento() {
        return "Los componentes están siendo ensamblados por nuestros técnicos";
    }
}