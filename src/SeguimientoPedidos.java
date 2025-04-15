import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class SeguimientoPedidos {
    private static SeguimientoPedidos instance;
    private Map<String, Pedido> pedidos;
    
    private SeguimientoPedidos() {
        pedidos = new HashMap<>();
    }
    
    public static SeguimientoPedidos getInstance() {
        if (instance == null) {
            instance = new SeguimientoPedidos();
        }
        return instance;
    }
    
    public void registrarPedido(Pedido pedido) {
        pedidos.put(pedido.getIdPedido(), pedido);
    }
    
    public Pedido consultarPedido(String idPedido) {
        return pedidos.get(idPedido);
    }
    
    public List<Pedido> obtenerPedidosPorSucursal(String sucursal) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos.values()) {
            if (pedido.getSucursalDestino().equals(sucursal)) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public void actualizarEstadoPedido(String idPedido, EstadoEnvio nuevoEstado) {
        Pedido pedido = pedidos.get(idPedido);
        if (pedido != null) {
            pedido.setEstadoActual(nuevoEstado);
        }
    }
}