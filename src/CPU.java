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

    //Agregar getters porfa

    public abstract String getDescripcion();

}