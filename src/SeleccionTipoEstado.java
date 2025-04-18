/**
 * Clase con la lógica para seleccionar el tipo de estado del pedido.
 */
public class SeleccionTipoEstado implements EnsamblajeEstado {
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

    @Override
    public String getDescripcion() {
        return "Estado de selección de tipo de ensamblaje";
    }
}