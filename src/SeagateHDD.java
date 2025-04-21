/**
 * Representa un disco duro mecanico (HDD) de la serie Seagate Barracuda.
 * 
 * Hereda de la clase base Disco y redefine el metodo de descripcion para incluir
 * detalles especificos del fabricante y del tipo de almacenamiento.
 */
public class SeagateHDD extends Disco {

    /**
     * Crea una nueva instancia de un HDD Seagate Barracuda con los datos especificados.
     *
     * @param nombre              Nombre del modelo.
     * @param precio              Precio del disco en moneda local.
     * @param marca               Marca del fabricante (sobrescrito como "Seagate Barracuda").
     * @param capacidadGB         Capacidad de almacenamiento en gigabytes.
     * @param tipoAlmacenamiento  Tipo de tecnologia (por ejemplo, SATA).
     */
    public SeagateHDD(String nombre, double precio, String marca, int capacidadGB, String tipoAlmacenamiento) {
        super(nombre, precio, "Seagate Barracuda", capacidadGB, tipoAlmacenamiento);
    }

    /**
     * Retorna una descripcion detallada del HDD Seagate.
     *
     * @return Cadena con nombre, capacidad, tipo de almacenamiento y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("Seagate %s - %dGB %s - $%.2f",
               nombre, capacidadGB, tipoAlmacenamiento, precio);

    }
}