/**
 * Clase abstracta que representa una CPU (procesador).
 */
public abstract class CPU extends Componente {
    protected int numNucleos;
    protected String socket;

    /**
     * Constructor de CPU.
     *
     * @param nombre     Nombre del modelo.
     * @param precio     Precio de la CPU.
     * @param marca      Marca del procesador.
     * @param numNucleos Número de núcleos.
     * @param socket     Tipo de socket compatible.
     */
    public CPU(String nombre, double precio, String marca, int numNucleos, String socket) {
        super(nombre, precio, marca);
        this.numNucleos = numNucleos;
        this.socket = socket;
    }

    /**
     * Obtiene el número de núcleos.
     * @return número de núcleos.
     */
    public int getNumNucleos() { return numNucleos; }

    /**
     * Obtiene el tipo de socket.
     * @return socket de la CPU.
     */
    public String getSocket() { return socket; }
}