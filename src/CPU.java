public abstract class CPU extends Componente {
    protected int numNucleos;
    protected String socket;

    public CPU(String nombre, double precio, String marca, int numNucleos, String socket) {
        super(nombre, precio, marca);
        this.numNucleos = numNucleos;
        this.socket = socket;
    }

    // Añade estos getters
    public int getNumNucleos() { return numNucleos; }
    public String getSocket() { return socket; }
}