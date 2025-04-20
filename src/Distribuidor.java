import java.util.ArrayList;
import java.util.List;

public class Distribuidor {
    private static Distribuidor instance;
    private List<Sucursal> sucursales;
    
    private Distribuidor() {
        sucursales = new ArrayList<>();
    }
    
    public static Distribuidor getInstance() {
        if (instance == null) {
            instance = new Distribuidor();
        }
        return instance;
    }
    
    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }
    
    public List<Sucursal> getSucursales() {
        return sucursales;
    }
}