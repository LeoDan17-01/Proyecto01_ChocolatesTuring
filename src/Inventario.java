import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un inventario simple de componentes disponibles.
 */
public class Inventario {
    private static Inventario instance;
    private Map<String, Componente> componentes;
    
    /**
     * Inicializa el inventario con una estructura vacía.
     */
    private Inventario() {
        componentes = new HashMap<>();
    }
    
    /**
     * Devuelve la unica instancia de la clase Inventario.
     *
     * @return instancia única de Inventario.
     */
    public static Inventario getInstance() {
        if (instance == null){
            instance = new Inventario();
        }
        return instance;
    }
    
    /**
     * Agrega un componente al inventario.
     *
     * @param componente Componente que se desea almacenar.
     */
    public void agregarComponente(Componente componente) {
        componentes.put(componente.getNombre(), componente);
    }

    /**
     * Obtiene un componente del inventario segun su nombre.
     *
     * @param nombre Nombre del componente a buscar.
     * @return Componente correspondiente, o null si no se encuentra.
     */
    public Componente obtenerComponente(String nombre) {
        return componentes.get(nombre);
    }
}