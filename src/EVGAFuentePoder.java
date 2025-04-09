public class EVGAFuentePoder extends FuentePoder {
    public EVGAFuentePoder(String nombre, double precio, int potenciaWatts, String certificacion) {
        super(nombre, precio, "EVGA", potenciaWatts, certificacion);
    }

    @Override
    public String getDescripcion() {
        return String.format("Fuente EVGA %s - %dW %s - $%.2f",
               nombre, potenciaWatts, certificacion, precio);
    }
}