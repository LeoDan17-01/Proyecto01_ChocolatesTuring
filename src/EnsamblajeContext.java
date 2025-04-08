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
    //public boolean verificarCompatibilidad(){
        //
      //  return true;

    //}

    /**
     * Método para realizar el ensamblaje de la computadora
     */
    public void ensamblarComputadora(){
       
        CPU cpu = builder.getCpu();
        GPU gpu = builder.getGpu();
        
        // Verificación superficial de compatibilidad (solo mensaje, como dijo el profe)
        if (cpu instanceof AMDCPU && gpu instanceof NvidiaGPU) {
            System.out.println(" Advertencia: El CPU AMD y la GPU Nvidia podrían no ser compatibles.");
        }
        
        Computadora computadora = builder.build();
        System.out.println("Computadora ensamblada exitosamente.");
        
        if (esPrearmado) {
            System.out.println("Ensamblaje pre-armado completo.");
        } else {
            System.out.println(" Ensamblaje personalizado completado.");
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
    
    /**
     * Metodo para la computadora prearmada.
     */

     public void manejarPrearmado(){
        System.out.println("Has seleccionado la opción de computadora pre-armada, componentes predeterminados.");
        builder.agregarCPU(new IntelCPU("Core i5-13600K", 2500, "Intel", 6));
        builder.agregarRAM(new RAM("Corsair Vengeance 16GB", 100, "Corsair", 16));
        builder.agregarGPU(new NvidiaGPU("RTX 3060", 3500, "NVIDIA", "GDDR6"));
        builder.agregarDisco(new Disco("Samsung SSD 500GB", 600, "Samsung"));
        builder.agregarFuentePoder(new FuentePoder("EVGA 600W", 80, "EVGA"));
        builder.agregarMotherboard(new Motherboard("Asus Z590", 300, "Asus"));
        builder.agregarGabinete(new Gabinete("NZXT H510", 70, "NZXT"));

        ensamblarComputadora();
     }

}