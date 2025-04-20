/**
 * Interfaz que define los métodos necesarios para verificar
 * y adaptar la compatibilidad entre componentes.
 */
public interface Compatibilidad {
    /**
     * Verifica si dos componentes son compatibles entre sí.
     *
     * @param componente1 Primer componente.
     * @param componente2 Segundo componente.
     * @return true si son compatibles, false en caso contrario.
     */
    boolean esCompatible(Componente componente1, Componente componente2);

    /**
     * Adapta un componente a una forma compatible.
     *
     * @param componente Componente original.
     * @return Componente adaptado o el mismo si no se requiere adaptación.
     */
    Componente adaptarComponente(Componente componente);
}