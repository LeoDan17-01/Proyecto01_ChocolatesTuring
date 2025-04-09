public class HDD extends Disco {
    private int velocidadRPM;

    public HDD(String nombre, double precio, String marca, int capacidadGB, int velocidadRPM) {
        super(nombre, precio, marca, capacidadGB, "HDD");
        this.velocidadRPM = velocidadRPM;
    }

    // Getter específico
    public int getVelocidadRPM() { return velocidadRPM; }

    @Override
    public String getDescripcion() {
        return String.format("HDD %s %dGB - %d RPM - $%.2f",
               marca, capacidadGB, velocidadRPM, precio);
    }
}