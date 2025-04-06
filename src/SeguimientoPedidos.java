import java.util.HashMap;
import java.util.Map;

public class SeguimientoPedidos {
    private static SeguimientoPedidos instance;
    private Map<String, Pedido> pedidos;
    
    private SeguimientoPedidos() {
        // Inicialización privada
    }
    
    public static SeguimientoPedidos getInstance() {
        // Implementación Singleton
    }
    
    // Métodos para registrar y consultar pedidos
}