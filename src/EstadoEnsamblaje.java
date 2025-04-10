public class EstadoEnsamblaje implements EnsamblajeEstado {
    @Override
    public void procesar(EnsamblajeContext context) {
        try {
            Computadora computadora = context.getBuilder().build();
            System.out.println("Ensamblaje físico completado exitosamente");
            
            // Verificación de compatibilidad AMD/NVIDIA
            if (computadora.getCpu() instanceof AMDCPU && 
                computadora.getGpu() instanceof NvidiaGPU) {
                System.out.println("Advertencia: CPU AMD con GPU NVIDIA detectado");
            }
            
            context.setState(new EstadoVerificacion());
        } catch (IllegalStateException e) {
            System.out.println("Error en ensamblaje: " + e.getMessage());
            context.setState(new EstadoSeleccionComponentes());
        }
    }
}