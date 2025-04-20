/**
 * Clase principal que inicia la aplicación de ensamblaje de computadoras.
 * Lanza el flujo de interacción con el usuario a través del controlador.
 */
public class Main {

    /**
     * Método principal que se ejecuta al iniciar el programa.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        ControladorEnsamblaje controlador = new ControladorEnsamblaje();
        controlador.iniciar();
    }
}