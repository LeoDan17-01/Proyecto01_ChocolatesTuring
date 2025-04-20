/**
 * Interfaz del patrón Estado para el ensamblaje.
 * Define el comportamiento que debe tener cada estado del proceso.
 */
public interface EnsamblajeEstado {

    /**
     * Procesa el estado actual con el contexto provisto.
     * @param context Contexto del ensamblaje.
     */
    void procesar(EnsamblajeContext context);

    /**
     * Devuelve la descripción del estado actual.
     * @return descripción textual del estado.
     */
    String getDescripcion();
}