import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private static Inventario instance;
    private Map<String, Componente> componentes;
    
    private Inventario() {
        componentes = new HashMap<>();
    }
    
    public static Inventario getInstance() {
        if (instance == null){
            instance = new Inventario();
        }
        return instance;
    }
    
    public void agregarComponente(Componente componente) {
        componentes.put(componente.getNombre(), componente);
    }

    public Componente obtenerComponente(String nombre) {
        return componentes.get(nombre);
    }
}