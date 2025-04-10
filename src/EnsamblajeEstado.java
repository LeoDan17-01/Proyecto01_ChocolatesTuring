/**
 * INterfaz que procesa el ensamblaje en este estado
 */
public interface EnsamblajeEstado {
    void procesar(EnsamblajeContext context);
    String getDescripcion();
}