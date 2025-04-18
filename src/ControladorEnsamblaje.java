import java.util.ArrayList;
import java.util.List;

public class ControladorEnsamblaje {
    private VistaTerminal vista;
    private EnsamblajeContext ensamblaje;
    private List<Pedido> pedidos;
    
    public ControladorEnsamblaje() {
        this.vista = new VistaTerminal();
        this.pedidos = new ArrayList<>();
        this.ensamblaje = new EnsamblajeContext("CDMX");
    }
    
    public void iniciar() {
        boolean seguirComprando = true;
        
        while (seguirComprando) {
            vista.mostrarMenuPrincipal();
            int opcion = vista.leerOpcion();
            
            switch (opcion) {
                case 1:
                    manejarPrearmado();
                    break;
                case 2:
                    manejarPersonalizado();
                    break;
                case 3:
                    mostrarResumenes();
                    break;
                case 4:
                    seguirComprando = false;
                    vista.mostrarMensaje("Gracias por usar nuestro sistema. ¡Hasta pronto!");
                    break;
                default:
                    vista.mostrarError("Opción inválida. Intente de nuevo.");
            }
        }
    }
    
    private void manejarPrearmado() {
        ensamblaje.manejarPrearmado();
        finalizarPedido();
    }
    
    private void manejarPersonalizado() {
        ensamblaje.iniciarPersonalizado();
        seleccionarComponentes();
        agregarSoftwareOpcional();
        finalizarPedido();
    }
    
    private void seleccionarComponentes() {
        seleccionarCPU();
        seleccionarRAM();
        seleccionarGPU();
        seleccionarDisco();
        seleccionarFuente();
        seleccionarMotherboard();
        seleccionarGabinete();
    }
    
    private void seleccionarCPU() {
        vista.mostrarMenuCPU();
        int opcion = vista.leerOpcion();
        CPU cpu = null;
        
        try {
            switch (opcion) {
                case 1:
                    cpu = new IntelCPU("Core i5-13600K", 2500, 6, "LGA1700");
                    break;
                case 2:
                    cpu = new IntelCPU("Core i7-13700K", 3500, 8, "LGA1700");
                    break;
                case 3:
                    cpu = new IntelCPU("Core i9-13900K", 5000, 12, "LGA1700");
                    break;
                default:
                    vista.mostrarError("Opción inválida");
                    return;
            }
            ensamblaje.agregarCPU(cpu);
            vista.mostrarComponenteAgregado(cpu.getDescripcion());
        } catch (Exception e) {
            vista.mostrarError("Error al agregar CPU: " + e.getMessage());
        }
    }
    
    private void seleccionarRAM() {
        vista.mostrarMenuRAM();
        int opcion = vista.leerOpcion();
        RAM ram = null;
        
        try {
            switch (opcion) {
                case 1:
                    ram = new AdataRAM("ADATA 16GB", 100, 16, "DDR4", 3200);
                    break;
                case 2:
                    ram = new AdataRAM("ADATA 32GB", 180, 32, "DDR4", 3200);
                    break;
                default:
                    vista.mostrarError("Opción inválida");
                    return;
            }
            ensamblaje.agregarRAM(ram);
            vista.mostrarComponenteAgregado(ram.getDescripcion());
        } catch (Exception e) {
            vista.mostrarError("Error al agregar RAM: " + e.getMessage());
        }
    }
    
    private void seleccionarGPU() {
        vista.mostrarMenuGPU();
        int opcion = vista.leerOpcion();
        GPU gpu = null;
        
        try {
            switch (opcion) {
                case 1:
                    gpu = new NvidiaGPU("RTX 3060", 6000, "GDDR6", 12);
                    break;
                case 2:
                    gpu = new NvidiaGPU("RTX 4070", 12000, "GDDR6X", 16);
                    break;
                default:
                    vista.mostrarError("Opción inválida");
                    return;
            }
            ensamblaje.agregarGPU(gpu);
            vista.mostrarComponenteAgregado(gpu.getDescripcion());
        } catch (Exception e) {
            vista.mostrarError("Error al agregar GPU: " + e.getMessage());
        }
    }
    
    private void seleccionarDisco() {
        vista.mostrarMenuDisco();
        int opcion = vista.leerOpcion();
        Disco disco = null;
        
        try {
            switch (opcion) {
                case 1:
                    disco = new SSD("Samsung 500GB", 60, "Samsung", 500, "NVMe");
                    break;
                case 2:
                    disco = new SSD("Samsung 1TB", 100, "Samsung", 1000, "NVMe");
                    break;
                default:
                    vista.mostrarError("Opción inválida");
                    return;
            }
            ensamblaje.agregarDisco(disco);
            vista.mostrarComponenteAgregado(disco.getDescripcion());
        } catch (Exception e) {
            vista.mostrarError("Error al agregar disco: " + e.getMessage());
        }
    }
    
    private void seleccionarFuente() {
        vista.mostrarMenuFuente();
        int opcion = vista.leerOpcion();
        FuentePoder fuente = null;
        
        try {
            switch (opcion) {
                case 1:
                    fuente = new EVGAFuentePoder("EVGA 600W", 50, 600, "80+ Bronze");
                    break;
                case 2:
                    fuente = new EVGAFuentePoder("Corsair 750W", 80, 750, "80+ Gold");
                    break;
                default:
                    vista.mostrarError("Opción inválida");
                    return;
            }
            ensamblaje.agregarFuentePoder(fuente);
            vista.mostrarComponenteAgregado(fuente.getDescripcion());
        } catch (Exception e) {
            vista.mostrarError("Error al agregar fuente: " + e.getMessage());
        }
    }
    
    private void seleccionarMotherboard() {
        vista.mostrarMenuMotherboard();
        int opcion = vista.leerOpcion();
        Motherboard motherboard = null;
        
        try {
            switch (opcion) {
                case 1:
                    motherboard = new ASUSMotherboard("ASUS Z590", 250, "Z590", "LGA1200");
                    break;
                case 2:
                    motherboard = new ASUSMotherboard("ASUS B550", 150, "B550", "AM4");
                    break;
                default:
                    vista.mostrarError("Opción inválida");
                    return;
            }
            ensamblaje.agregarMotherboard(motherboard);
            vista.mostrarComponenteAgregado(motherboard.getDescripcion());
        } catch (Exception e) {
            vista.mostrarError("Error al agregar motherboard: " + e.getMessage());
        }
    }
    
    private void seleccionarGabinete() {
        vista.mostrarMenuGabinete();
        int opcion = vista.leerOpcion();
        Gabinete gabinete = null;
        
        try {
            switch (opcion) {
                case 1:
                    gabinete = new NZXTGabinete("NZXT H510", 70, "ATX", true);
                    break;
                case 2:
                    gabinete = new NZXTGabinete("Lian Li O11", 150, "ATX", false);
                    break;
                default:
                    vista.mostrarError("Opción inválida");
                    return;
            }
            ensamblaje.agregarGabinete(gabinete);
            vista.mostrarComponenteAgregado(gabinete.getDescripcion());
        } catch (Exception e) {
            vista.mostrarError("Error al agregar gabinete: " + e.getMessage());
        }
    }
    
    private void agregarSoftwareOpcional() {
        vista.mostrarMensaje("\n--- Software Adicional ---");
        vista.mostrarMensaje("¿Desea agregar software? (S/N)");
        String respuesta = vista.leerLinea();
        
        if (respuesta.equalsIgnoreCase("S")) {
            boolean continuar = true;
            while (continuar) {
                vista.mostrarMensaje("\nOpciones de software:");
                vista.mostrarMensaje("1. Windows 11 Pro - $300");
                vista.mostrarMensaje("2. Office 365 - $250");
                vista.mostrarMensaje("3. Adobe Photoshop - $500");
                vista.mostrarMensaje("4. Finalizar selección");
                vista.mostrarMensaje("Seleccione: ");
                
                int opcion = vista.leerOpcion();
                
                switch (opcion) {
                    case 1:
                        ensamblaje.agregarSoftware(new SoftwareAdicional("Windows 11 Pro", 300));
                        break;
                    case 2:
                        ensamblaje.agregarSoftware(new SoftwareAdicional("Office 365", 250));
                        break;
                    case 3:
                        ensamblaje.agregarSoftware(new SoftwareAdicional("Adobe Photoshop", 500));
                        break;
                    case 4:
                        continuar = false;
                        break;
                    default:
                        vista.mostrarError("Opción inválida");
                }
            }
        }
    }
    
    private void finalizarPedido() {
        String direccion = vista.leerDireccion();
        ensamblaje.setDireccionEntrega(direccion);
        
        Pedido pedido = ensamblaje.crearPedido();
        pedidos.add(pedido);
        
        vista.mostrarMensaje("\n¡Pedido creado exitosamente!");
        vista.mostrarResumenPedido(pedido);
    }
    
    private void mostrarResumenes() {
        vista.mostrarMensaje("\n--- Resumen de Pedidos ---");
        if (pedidos.isEmpty()) {
            vista.mostrarMensaje("No hay pedidos registrados.");
        } else {
            for (Pedido pedido : pedidos) {
                vista.mostrarResumenPedido(pedido);
            }
        }
    }
} 