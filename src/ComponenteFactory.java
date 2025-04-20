/**
 * Interfaz que define los métodos para crear los distintos
 * componentes de una computadora mediante el patrón Abstract Factory.
 */
public interface ComponenteFactory {

    /**
     * Crea una CPU con el modelo especificado.
     *
     * @param modelo Modelo de CPU.
     * @return Instancia de CPU.
     */
    CPU crearCPU(String modelo);

    /**
     * Crea una GPU con el modelo especificado.
     *
     * @param modelo Modelo de GPU.
     * @return Instancia de GPU.
     */
    GPU crearGPU(String modelo);

    /**
     * Crea una RAM con el modelo y cantidad especificados.
     *
     * @param modelo   Modelo de RAM.
     * @param cantidad Cantidad o capacidad de la RAM.
     * @return Instancia de RAM.
     */
    RAM crearRAM(String modelo, int cantidad);

    /**
     * Crea un disco con el modelo especificado.
     *
     * @param modelo Modelo de disco.
     * @return Instancia de Disco.
     */
    Disco crearDisco(String modelo);

    /**
     * Crea una fuente de poder con el modelo especificado.
     *
     * @param modelo Modelo de fuente de poder.
     * @return Instancia de FuentePoder.
     */
    FuentePoder crearFuentePoder(String modelo);

    /**
     * Crea una motherboard con el modelo especificado.
     *
     * @param modelo Modelo de motherboard.
     * @return Instancia de Motherboard.
     */
    Motherboard crearMotherboard(String modelo);

    /**
     * Crea un gabinete con el modelo especificado.
     *
     * @param modelo Modelo de gabinete.
     * @return Instancia de Gabinete.
     */
    Gabinete crearGabinete(String modelo);
}