/**
 * Clase principal que inicia la aplicacion de ensamblaje de computadoras.
 * Lanza el flujo de interaccion con el usuario a traves del controlador.
 */
public class Main {

    /**
     * Metodo principal que se ejecuta al iniciar el programa.
     *
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Distribuidor distribuidor = Distribuidor.getInstance();
        distribuidor.agregarSucursal(new Sucursal("CDMX", "Av.Principal 321", true));
        distribuidor.agregarSucursal(new Sucursal("Chihuahua", "Calle Zacapa 87", false));
        distribuidor.agregarSucursal(new Sucursal("Jalisco", "Calle Prados del Nilo 75", false));
        distribuidor.agregarSucursal(new Sucursal("Yucatán", "Circuito Colinas 194B", false));

        ControladorEnsamblaje controlador = new ControladorEnsamblaje("CDMX");
        controlador.iniciar();
    }
}