import java.util.ArrayList;
import java.util.List;

/**
 * Clase Singleton que representa al distribuidor principal del sistema.
 * 
 * Administra una lista unica de sucursales disponibles para realizar envios o compras.
 */
public class Distribuidor {
    private static Distribuidor instance;
    private List<Sucursal> sucursales;
    
    /**
     * Constructor privado que impide la creacion de multiples instancias.
     * Inicializa la lista de sucursales.
     */
    private Distribuidor() {
        sucursales = new ArrayList<>();
    }
    
    /**
     * Retorna la unica instancia de Distribuidor.
     * Si no existe, se crea una nueva.
     *
     * @return Instancia unica de Distribuidor.
     */
    public static Distribuidor getInstance() {
        if (instance == null) {
            instance = new Distribuidor();
        }
        return instance;
    }
    
    /**
     * Agrega una nueva sucursal a la lista del distribuidor.
     *
     * @param sucursal Objeto Sucursal a registrar.
     */
    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }
    
    /**
     * Obtiene la lista de todas las sucursales registradas.
     *
     * @return Lista de objetos Sucursal.
     */
    public List<Sucursal> getSucursales() {
        return sucursales;
    }
}