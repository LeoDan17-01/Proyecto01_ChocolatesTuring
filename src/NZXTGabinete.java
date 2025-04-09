public class NZXTGabinete extends Gabinete {
    public NZXTGabinete(String nombre, double precio, String tipoFactor, boolean incluyeVentiladores) {
        super(nombre, precio, "NZXT", tipoFactor, incluyeVentiladores);
    }

    @Override
    public String getDescripcion() {
        return String.format("Gabinete NZXT %s - Factor %s - %s - $%.2f",
               nombre, tipoFactor, 
               incluyeVentiladores ? "Con ventiladores" : "Sin ventiladores",
               precio);
    }
}