/**
 * Representa una unidad de estado solido (SSD) de la marca Kingston.
 * 
 * Hereda de la clase base Disco y proporciona una implementación especifica
 * del metodo de descripcion para este tipo de almacenamiento.
 */
public class KingstonSSD extends Disco {

    /**
     * Crea una nueva instancia de un SSD Kingston con las especificaciones indicadas.
     *
     * @param nombre              Nombre del modelo del SSD.
     * @param precio              Precio de la unidad en moneda local.
     * @param marca               Marca del fabricante (sobrescrito a "Kingston").
     * @param capacidadGB         Capacidad de almacenamiento en gigabytes.
     * @param tipoAlmacenamiento  Tipo de tecnologia de almacenamiento (ej. SATA, NVMe).
     */
    public KingstonSSD(String nombre, double precio, String marca, int capacidadGB, String tipoAlmacenamiento) {
        super(nombre, precio, "Kingston", capacidadGB, tipoAlmacenamiento);

    }

    /**
     * Retorna una descripcion detallada del SSD Kingston.
     *
     * @return Cadena con nombre, capacidad, tipo y precio.
     */
    @Override
    public String getDescripcion() {
        return String.format("Kingston SSD %s - %dGB %s - $%.2f",
               nombre, capacidadGB, tipoAlmacenamiento, precio);
    }
}