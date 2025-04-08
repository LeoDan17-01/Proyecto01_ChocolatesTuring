/**
 * Clase con la lógica para seleccionar el tipo de estado del pedido.
 */
public class SeleccionTipoEstado implements EnsamblajeEstado {
    @Override
    public void procesar(EnsamblajeContext context) {
        
           // Aquí se maneja la lógica de selección del tipo de ensamblaje (pre-armado o personalizado)
            System.out.println("Seleccionando tipo de ensamblaje...");
            if (context.esPrearmado()) {
                // Lógica para ensamblaje pre-armado
                System.out.println("Seleccionado ensamblaje pre-armado.");
            } else {
                // Lógica para ensamblaje personalizado
                System.out.println("Seleccionado ensamblaje personalizado.");
            }
        }      
    }
}