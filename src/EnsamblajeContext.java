public class EnsamblajeContext {
    private EnsamblajeState state;
    private ComputadoraBuilder builder;
    private boolean esPrearmado;
    private ComponenteFactory currentFactory;
    
    public EnsamblajeContext(){
        this.state = new SeleccionTipoEstado();
        this.builder = new ComputadoraBuilder();
        this.esPrearmado = false;
    }

    //public void setState(EnsamblajeEstado state){
      //  this.state = state;
    //}

    /**
     * Método que porcesa el estado actual.
     */
    //public void procesar(){
      //  this.state.procesar(this); 

    //}
    //Métodos para manejar la configuracion de la computadora y el ensamblaje
    public void agregarCPU (CPU cpu){
        builder.agregaarCPU(cpu);
    }

    public void agregarRAM(RAM ram){
        builder.agregarRAM(ram);
    }

    public void agregarGPU(GPU gpu){
        builder.agregarGPU(gpu);
    }
    public void agregarDisco(Disco disco) {
        builder.agregarDisco(disco);
    }

    public void agregarFuentePoder(FuentePoder fuente) {
        builder.agregarFuentePoder(fuente);
    }

    public void agregarMotherboard(Motherboard motherboard) {
        builder.agregarMotherboard(motherboard);
    }

    public void agregarGabinete(Gabinete gabinete) {
        builder.agregarGabinete(gabinete);
    }

    public void agregarSoftware(SoftwareAdicional software) {
        builder.agregarSoftware(software);
    }

    /**
     * Método para verificar la compatibilidad de los componentes antes del
     * ensamblaje.
     */
    public boolean verificarCompatibilidad(){
        //
        return true;

    }

    /**
     * Método para realizar el ensamblaje de la computadora
     */
    public void ensamblarComputadora(){
        if(verificarCompatibilidad()){
            Computadora computadora = builder.build();
            System.out.println("La computadora ha sido ensamblada correctamente. ");
        } else{
            System.out.println("Los componentes no son compatibles, no se puede ensamblar la computadora.");
        }
    }

    //Cambiar el estado de ensamblaje
    public void setState(EnsamblajeEstado state ){
        this.state = state;
    }

    //Ejecutar el procesamiento del ensamblaje
    public void procesar(){
        this.state.procesar(this);
    }

    //Método para acceder el atributo esPrearmado
    public boolean esPrearmado(){
        return esPrearmado;
    }

    //Método para cambiar el valor de esPrearmado
    public void setPrearmado(boolean esPrearmado){
        this.esPrearmado = esPrearmado;
    }

    //Metodos adicionales para obtener los componentes si es necesario
    public Computadora getComputadora(){
        return builder.build();
    }
    

}