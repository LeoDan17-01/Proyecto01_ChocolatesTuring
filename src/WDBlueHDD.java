/**
 * Representa un disco duro mecanico (HDD) de la linea Western Digital Blue.
 * 
 * Extiende la clase base Disco y redefine su descripcion especifica para esta marca.
 */
public class WDBlueHDD extends Disco {

    /**
     * Crea una instancia de un disco duro Western Digital Blue con los parametros especificados.
     *
     * @param nombre              Nombre del modelo del disco.
     * @param precio              Precio del disco en moneda local.
     * @param marca               Marca del disco (sobrescrito como "Western Digital Blue").
     * @param capacidadGB         Capacidad de almacenamiento en gigabytes.
     * @param tipoAlmacenamiento  Tipo de tecnologia (por ejemplo, SATA).
     */
    public WDBlueHDD(String nombre, double precio, String marca, int capacidadGB, String tipoAlmacenamiento) {
        super(nombre, precio, "Western Digital Blue", capacidadGB, tipoAlmacenamiento);
    }

    /**
     * Retorna una descripcion detallada del disco WD Blue.
     *
     * @return Cadena con nombre, capacidad, tipo de almacenamiento y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("WD Blue %s - %dGB %s - $%.2f",
               nombre, capacidadGB, tipoAlmacenamiento, precio);

    }
}