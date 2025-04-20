import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Singleton que gestiona el seguimiento de pedidos realizados.
 * Permite registrar, consultar, filtrar y actualizar estados de pedidos.
 */

public class SeguimientoPedidos {
    private static SeguimientoPedidos instance;
    private Map<String, Pedido> pedidos;
    
    /**
     * Constructor privado del singleton.
     */
    private SeguimientoPedidos() {
        pedidos = new HashMap<>();
    }
    
    /**
     * Devuelve la instancia única de seguimiento.
     *
     * @return Instancia singleton.
     */
    public static SeguimientoPedidos getInstance() {
        if (instance == null) {
            instance = new SeguimientoPedidos();
        }
        return instance;
    }
    
    /**
     * Registra un nuevo pedido.
     *
     * @param pedido Pedido a registrar.
     */
    public void registrarPedido(Pedido pedido) {
        pedidos.put(pedido.getIdPedido(), pedido);
    }
    
    /**
     * Consulta un pedido según su ID.
     *
     * @param idPedido ID del pedido.
     * @return Pedido encontrado o null.
     */
    public Pedido consultarPedido(String idPedido) {
        return pedidos.get(idPedido);
    }
    
    /**
     * Obtiene todos los pedidos realizados en una sucursal específica.
     *
     * @param sucursal Nombre de la sucursal.
     * @return Lista de pedidos de esa sucursal.
     */
    public List<Pedido> obtenerPedidosPorSucursal(String sucursal) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos.values()) {
            if (pedido.getSucursalDestino().equals(sucursal)) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    /**
     * Cambia el estado de un pedido específico.
     *
     * @param idPedido    ID del pedido.
     * @param nuevoEstado Nuevo estado a asignar.
     */
    public void actualizarEstadoPedido(String idPedido, EstadoEnvio nuevoEstado) {
        Pedido pedido = pedidos.get(idPedido);
        if (pedido != null) {
            pedido.setEstadoActual(nuevoEstado);
        }
    }
}