import java.util.Scanner;

public class EstadoSeleccionComponentes implements EnsamblajeEstado {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void procesar(EnsamblajeContext context) {
        System.out.println("\n=== MODO SELECCIÓN DE COMPONENTES ===");
        
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = obtenerOpcionUsuario();
            
            switch (opcion) {
                case 1:
                    agregarCPU(context);
                    break;
                case 2:
                    agregarRAM(context);
                    break;
                case 3:
                    agregarGPU(context);
                    break;
                case 4:
                    agregarDisco(context);
                    break;
                case 5:
                    agregarFuentePoder(context);
                    break;
                case 6:
                    agregarMotherboard(context);
                    break;
                case 7:
                    agregarGabinete(context);
                    break;
                case 8:
                    continuar = false;
                    System.out.println("Configuración de componentes completada.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    @Override
    public String getDescripcion() {
        return "Estado de selección personalizada de componentes";
    }

    private void mostrarMenu() {
        System.out.println("\n1. Agregar CPU");
        System.out.println("2. Agregar RAM");
        System.out.println("3. Agregar GPU");
        System.out.println("4. Agregar Disco");
        System.out.println("5. Agregar Fuente de Poder");
        System.out.println("6. Agregar Motherboard");
        System.out.println("7. Agregar Gabinete");
        System.out.println("8. Finalizar selección");
        System.out.print("Seleccione una opción: ");
    }

    private int obtenerOpcionUsuario() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void agregarCPU(EnsamblajeContext context) {
        System.out.println("\n=== SELECCIÓN DE CPU ===");
        System.out.println("1. Intel Core i5-13600K");
        System.out.println("2. AMD Ryzen 7 5800X");
        System.out.print("Seleccione CPU: ");
        
        int opcion = obtenerOpcionUsuario();
        CPU cpu = null;
        
        try {
            switch (opcion) {
                case 1:
                    cpu = new IntelCPU("Core i5-13600K", 2500, 6, "LGA1700");
                    break;
                case 2:
                    cpu = new AMDCPU("Ryzen 7 5800X", 2200, 8, "AM4");
                    break;
                default:
                    System.out.println("Opción inválida");
                    return;
            }
            context.agregarCPU(cpu);
        } catch (Exception e) {
            System.err.println("Error al agregar CPU: " + e.getMessage());
        }
    }

    private void agregarRAM(EnsamblajeContext context) {
        System.out.println("\n=== SELECCIÓN DE RAM ===");
        System.out.print("Ingrese cantidad de GB (16/32): ");
        int gb = obtenerOpcionUsuario();
        
        try {
            RAM ram = new AdataRAM("ADATA DDR4", gb == 16 ? 100 : 180, gb, "DDR4", 3200);
            context.agregarRAM(ram);
        } catch (Exception e) {
            System.err.println("Error al agregar RAM: " + e.getMessage());
        }
    }

    private void agregarGPU(EnsamblajeContext context) {
        System.out.println("\n=== SELECCIÓN DE GPU ===");
        System.out.println("1. NVIDIA RTX 3060");
        System.out.println("2. NVIDIA RTX 4070");
        System.out.print("Seleccione GPU: ");
        
        int opcion = obtenerOpcionUsuario();
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
                    System.out.println("Opción inválida");
                    return;
            }
            context.agregarGPU(gpu);
        } catch (Exception e) {
            System.err.println("Error al agregar GPU: " + e.getMessage());
        }
    }

    private void agregarDisco(EnsamblajeContext context) {
        System.out.println("\n=== SELECCIÓN DE DISCO ===");
        System.out.println("1. SSD 500GB");
        System.out.println("2. SSD 1TB");
        System.out.print("Seleccione disco: ");
        
        int opcion = obtenerOpcionUsuario();
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
                    System.out.println("Opción inválida");
                    return;
            }
            context.agregarDisco(disco);
        } catch (Exception e) {
            System.err.println("Error al agregar disco: " + e.getMessage());
        }
    }

    private void agregarFuentePoder(EnsamblajeContext context) {
        System.out.println("\n=== SELECCIÓN DE FUENTE ===");
        System.out.println("1. EVGA 600W 80+ Bronze");
        System.out.println("2. Corsair 750W 80+ Gold");
        System.out.print("Seleccione fuente: ");
        
        int opcion = obtenerOpcionUsuario();
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
                    System.out.println("Opción inválida");
                    return;
            }
            context.agregarFuentePoder(fuente);
        } catch (Exception e) {
            System.err.println("Error al agregar fuente: " + e.getMessage());
        }
    }

    private void agregarMotherboard(EnsamblajeContext context) {
        System.out.println("\n=== SELECCIÓN DE MOTHERBOARD ===");
        System.out.println("1. ASUS Z590 (Intel)");
        System.out.println("2. ASUS B550 (AMD)");
        System.out.print("Seleccione motherboard: ");
        
        int opcion = obtenerOpcionUsuario();
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
                    System.out.println("Opción inválida");
                    return;
            }
            context.agregarMotherboard(motherboard);
        } catch (Exception e) {
            System.err.println("Error al agregar motherboard: " + e.getMessage());
        }
    }

    private void agregarGabinete(EnsamblajeContext context) {
        System.out.println("\n=== SELECCIÓN DE GABINETE ===");
        System.out.println("1. NZXT H510");
        System.out.println("2. Lian Li O11 Dynamic");
        System.out.print("Seleccione gabinete: ");
        
        int opcion = obtenerOpcionUsuario();
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
                    System.out.println("Opción inválida");
                    return;
            }
            context.agregarGabinete(gabinete);
        } catch (Exception e) {
            System.err.println("Error al agregar gabinete: " + e.getMessage());
        }
    }
}