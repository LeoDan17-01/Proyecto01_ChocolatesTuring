public class EstadoEnsamblaje implements EnsamblajeEstado {
    @Override
    public void procesar(EnsamblajeContext context) {
        // Lógica para el ensamblaje de la computadora
        System.out.println("La computadora está siendo ensamblada...");
        // Supongamos que después de ensamblar, avanzamos al siguiente estado (Verificación, Enviado, etc.)
        context.setState(new EstadoVerificacion());  // Cambiar a un nuevo estado, por ejemplo, "Verificación"
    }
    
}
