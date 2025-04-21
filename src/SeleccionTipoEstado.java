/**
 * Estado inicial del proceso de ensamblaje, donde se selecciona
 * si el ensamblaje sera pre-armado o personalizado.
 */
public class SeleccionTipoEstado implements EnsamblajeEstado {

    /**
     * Procesa la seleccion de tipo de ensamblaje segun la configuracion actual.
     *
     * @param context Contexto del ensamblaje.
     */
    @Override
    public void procesar(EnsamblajeContext context) {
        System.out.println("Seleccionando tipo de ensamblaje...");
        if (context.isEsPrearmado()) {
            System.out.println("Seleccionado ensamblaje pre-armado.");
            context.manejarPrearmado();
        } else {
            System.out.println("Seleccionado ensamblaje personalizado.");
            context.iniciarPersonalizado();
        }
    }

    /**
     * Devuelve la descripcion del estado actual.
     *
     * @return Descripcion del estado.
     */
    @Override
    public String getDescripcion() {
        return "Estado de selección de tipo de ensamblaje";
    }
}