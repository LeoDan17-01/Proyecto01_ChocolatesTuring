public abstract class GPU extends Componente {
    protected String tipoMemoria;
    protected int vramGB;

    public GPU(String nombre, double precio, String marca, String tipoMemoria, int vramGB) {
        super(nombre, precio, marca);
        this.tipoMemoria = tipoMemoria;
        this.vramGB = vramGB;
    }

    // Getters
    public String getTipoMemoria() { return tipoMemoria; }
    public int getVramGB() { return vramGB; }
}