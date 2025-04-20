/**
 * Clase que representa un disco duro mecánico (HDD).
 * Extiende la clase Disco y añade velocidad en RPM.
 */
public class HDD extends Disco {
    private int velocidadRPM;

    /**
     * Constructor de disco HDD.
     *
     * @param nombre        Nombre del modelo.
     * @param precio        Precio del disco.
     * @param marca         Marca del disco.
     * @param capacidadGB   Capacidad total en GB.
     * @param velocidadRPM  Velocidad de rotación en revoluciones por minuto.
     */
    public HDD(String nombre, double precio, String marca, int capacidadGB, int velocidadRPM) {
        super(nombre, precio, marca, capacidadGB, "HDD");
        this.velocidadRPM = velocidadRPM;
    }

    /**
     * Devuelve la velocidad del disco en revoluciones por minuto.
     *
     * @return velocidad en RPM.
     */
    public int getVelocidadRPM() { return velocidadRPM; }

    /**
     * Devuelve una descripción detallada del HDD.
     *
     * @return descripción como texto.
     */
    @Override
    public String getDescripcion() {
        return String.format("HDD %s %dGB - %d RPM - $%.2f",
               marca, capacidadGB, velocidadRPM, precio);
    }
}