import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa el menú principal de la aplicación PC Builder.
 * Permite al usuario elegir entre computadoras prearmadas, personalizadas,
 * ver sus pedidos o salir del sistema.
 */
public class Menu {
    private EnsamblajeContext ensamblaje;
    private List<Pedido> pedidos;
    private Scanner scanner;

    /**
     * Constructor del menú.
     * Inicializa el ensamblaje, la lista de pedidos y lanza el menú principal.
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.pedidos = new ArrayList<>();
        this.ensamblaje = new EnsamblajeContext("CDMX");
        inicializarMenu();
    }

    /**
     * Muestra el menú principal y gestiona la interacción con el usuario.
     * El usuario puede seleccionar entre diferentes modos de compra.
     */
    private void inicializarMenu() {
        boolean seguirComprando = true;
        System.out.println("-----------------------------------------------------------");
        System.out.println("                PC Builder - Ensamblaje de Computadoras");
        System.out.println("-----------------------------------------------------------\n");

        while (seguirComprando) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Comprar PC prearmada");
            System.out.println("2. Armar PC personalizada");
            System.out.println("3. Ver resumen de pedidos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    ensamblaje.manejarPrearmado();
                    flujoFinal();
                    break;
                case 2:
                    ensamblaje.iniciarPersonalizado();
                    seleccionarComponentes();
                    agregarSoftwareOpcional();
                    flujoFinal();
                    break;
                case 3:
                    mostrarResumenPedido();
                    break;
                case 4:
                    seguirComprando = false;
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    /**
     * Permite al usuario seleccionar todos los componentes necesarios para armar una computadora.
     * Incluye CPU, RAM, GPU, disco, fuente de poder, motherboard y gabinete.
     */
    private void seleccionarComponentes() {
        System.out.println("\n--- Selección de Componentes ---");

        // CPU
        System.out.println("\n[CPU] Seleccione el procesador:");
        System.out.println("1. Intel Core i5-13600K (6 núcleos) - $2500");
        System.out.println("2. Intel Core i7-13700K (8 núcleos) - $3500");
        System.out.println("3. Intel Core i9-13900K (12 núcleos) - $5000");
        System.out.print("Opción: ");
        int opcionCPU = scanner.nextInt();
        CPU cpu = switch (opcionCPU) {
            case 1 -> new IntelCPU("Core i5-13600K", 2500, 6, "LGA1700");
            case 2 -> new IntelCPU("Core i7-13700K", 3500, 8, "LGA1700");
            case 3 -> new IntelCPU("Core i9-13900K", 5000, 12, "LGA1700");
            default -> throw new IllegalArgumentException("Opción inválida");
        };
        ensamblaje.agregarCPU(cpu);

        // RAM
        System.out.println("\n[RAM] Seleccione la memoria:");
        System.out.println("1. ADATA 16GB DDR4 3200MHz - $100");
        System.out.println("2. ADATA 32GB DDR4 3200MHz - $180");
        System.out.print("Opción: ");
        int opcionRAM = scanner.nextInt();
        RAM ram = switch (opcionRAM) {
            case 1 -> new AdataRAM("ADATA 16GB", 100, 16, "DDR4", 3200);
            case 2 -> new AdataRAM("ADATA 32GB", 180, 32, "DDR4", 3200);
            default -> throw new IllegalArgumentException("Opción inválida");
        };
        ensamblaje.agregarRAM(ram);

        // GPU
        System.out.println("\n[GPU] Seleccione la tarjeta gráfica:");
        System.out.println("1. NVIDIA RTX 3060 12GB - $6000");
        System.out.println("2. NVIDIA RTX 4080 16GB - $12000");
        System.out.print("Opción: ");
        int opcionGPU = scanner.nextInt();
        GPU gpu = switch (opcionGPU) {
            case 1 -> new NvidiaGPU("RTX 3060", 6000, "GDDR6", 12);
            case 2 -> new NvidiaGPU("RTX 4080", 12000, "GDDR6X", 16);
            default -> throw new IllegalArgumentException("Opción inválida");
        };
        ensamblaje.agregarGPU(gpu);

        // Disco
        System.out.println("\n[Almacenamiento] Seleccione el disco:");
        System.out.println("1. SSD Samsung 500GB NVMe - $60");
        System.out.println("2. SSD Samsung 1TB NVMe - $100");
        System.out.print("Opción: ");
        int opcionDisco = scanner.nextInt();
        Disco disco = switch (opcionDisco) {
            case 1 -> new SSD("Samsung 500GB", 60, "Samsung", 500, "NVMe");
            case 2 -> new SSD("Samsung 1TB", 100, "Samsung", 1000, "NVMe");
            default -> throw new IllegalArgumentException("Opción inválida");
        };
        ensamblaje.agregarDisco(disco);

        // Fuente
        System.out.println("\n[Fuente] Seleccione la fuente de poder:");
        System.out.println("1. EVGA 600W 80+ Bronze - $50");
        System.out.println("2. Corsair 750W 80+ Gold - $80");
        System.out.print("Opción: ");
        int opcionFuente = scanner.nextInt();
        FuentePoder fuente = switch (opcionFuente) {
            case 1 -> new EVGAFuentePoder("EVGA 600W", 50, 600, "80+ Bronze");
            case 2 -> new EVGAFuentePoder("Corsair 750W", 80, 750, "80+ Gold");
            default -> throw new IllegalArgumentException("Opción inválida");
        };
        ensamblaje.agregarFuentePoder(fuente);

        // Motherboard
        System.out.println("\n[Motherboard] Seleccione la placa base:");
        System.out.println("1. ASUS Z590 (Intel) - $250");
        System.out.println("2. ASUS B550 (AMD) - $150");
        System.out.print("Opción: ");
        int opcionMB = scanner.nextInt();
        Motherboard mb = switch (opcionMB) {
            case 1 -> new ASUSMotherboard("ASUS Z590", 250, "Z590", "LGA1200");
            case 2 -> new ASUSMotherboard("ASUS B550", 150, "B550", "AM4");
            default -> throw new IllegalArgumentException("Opción inválida");
        };
        ensamblaje.agregarMotherboard(mb);

        // Gabinete
        System.out.println("\n[Gabinete] Seleccione el chasis:");
        System.out.println("1. NZXT H510 - $70");
        System.out.println("2. Lian Li O11 Dynamic - $150");
        System.out.print("Opción: ");
        int opcionGabinete = scanner.nextInt();
        Gabinete gabinete = switch (opcionGabinete) {
            case 1 -> new NZXTGabinete("NZXT H510", 70, "ATX", true);
            case 2 -> new NZXTGabinete("Lian Li O11", 150, "ATX", false);
            default -> throw new IllegalArgumentException("Opción inválida");
        };
        ensamblaje.agregarGabinete(gabinete);

        scanner.nextLine(); // Limpiar buffer
    }

    /**
     * Permite al usuario agregar software adicional opcional.
     * Muestra un submenú con productos como Windows, Office y Photoshop.
     */
    private void agregarSoftwareOpcional() {
        System.out.println("\n--- Software Adicional ---");
        System.out.println("¿Desea agregar software? (S/N)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            boolean continuar = true;
            while (continuar) {
                System.out.println("\nOpciones de software:");
                System.out.println("1. Windows 11 Pro - $300");
                System.out.println("2. Office 365 - $250");
                System.out.println("3. Adobe Photoshop - $500");
                System.out.println("4. Finalizar selección");
                System.out.print("Seleccione: ");
                
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
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
                        System.out.println("Opción inválida");
                }
            }
        }
    }

    /**
     * Finaliza el flujo de compra solicitando dirección y generando el pedido.
     * El pedido se agrega a la lista y se muestra el total.
     */
    private void flujoFinal() {
        System.out.print("\nIngrese la dirección de entrega: ");
        String direccion = scanner.nextLine();
        ensamblaje.setDireccionEntrega(direccion);
        
        Pedido pedido = ensamblaje.crearPedido();
        pedidos.add(pedido);
        
        System.out.println("\n¡Pedido creado exitosamente!");
        System.out.println("Número de pedido: " + pedido.getIdPedido());
        System.out.println("Total: $" + pedido.getComputadora().calcularPrecioTotal());
    }

    /**
     * Muestra un resumen de todos los pedidos realizados hasta el momento.
     * Incluye ID, fecha, estado, precio y dirección de entrega.
     */
    private void mostrarResumenPedido() {
        System.out.println("\n--- Resumen de Pedidos ---");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println("\nPedido #" + pedido.getIdPedido());
                System.out.println("Fecha: " + pedido.getFechaCreacion());
                System.out.println("Estado: " + pedido.getEstadoActual().getDescripcionEstado());
                System.out.println("Total: $" + pedido.getPrecioTotal());
                System.out.println("Dirección: " + pedido.getDireccionEntrega());
            }
        }
    }
}