public abstract class CPU{
    protected String nombre;
    protected double precio;
    protected String marca;
    protected int numNucleos;


    public CPU(String nombre, double precio, String marca, int numNucleos){
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.numNucleos = numNucleos;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getMarca() { return marca; }
    public int getNumNucleos() { return numNucleos; }

    

    public abstract String getDescripcion();

}