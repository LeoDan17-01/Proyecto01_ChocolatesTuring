import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private EnsamblajeContext ensamblaje;
    private List<Pedido> pedidos;
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.pedidos = new ArrayList<>();
        this.ensamblaje = new EnsamblajeContext("CDMX");
        inicializarMenu();
    }

    /**
     * Método que inicializa el menú y gestiona la interacción con el usuario.
     */
    private void inicializarMenu() {
        boolean seguirComprando= true;
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("                    PC's MonosChinos MX);
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------\n");

        while (seguirComprando) {
            System.out.println("\nBienvenido a MonosChinos MX");
            System.out.println("Por favor, seleccione alguna de las siguientes opciones o elija salir:");
            System.out.println("1. Comprar PC prearmada");
            System.out.println("2. Armar PC personalizada");
            System.out.println("3. Ver resumen de pedidos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    ensamblaje.manejarPrearmado(); // Configura la PC prearmada
                    flujoFinal();
                    break;
                case 2:
                    ensamblaje.iniciarPersonalizado(); // Inicia el ensamblaje personalizado
                    seleccionarComponentes();
                    agregarSoftwareOpcional();
                    flujoFinal();
                    break;
                case 3:
                    mostrarResumenPedido(); // Muestra los pedidos realizados
                    break;
                case 4:
                    seguir = false; // Termina el programa
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    /**
     * Método que permite al usuario seleccionar los componentes de su PC personalizada.
     */
    private void seleccionarComponentes() {
        System.out.println("\n--- Selección de componentes ---");

        // Selección de CPU
        System.out.println("Selecciona una CPU:");
        System.out.println("1. Intel Core i5-13600K\n2. Intel Core i7-13700K\n3. Intel Core i9-13900K");
        int opcionCPU = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        CPU cpu = null;
        switch (opcionCPU) {
            case 1:
                cpu = new IntelCPU("Intel Core i5-13600K", 4500.0, "Intel", 14);
                break;
            case 2:
                cpu = new IntelCPU("Intel Core i7-13700K", 5500.0, "Intel", 16);
                break;
            case 3:
                cpu = new IntelCPU("Intel Core i9-13900K", 6500.0, "Intel", 18);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        ensamblaje.agregarCPU(cpu);

        // Selección de RAM
        System.out.println("Selecciona una RAM:");
        System.out.println("1. Kingston 16GB\n2. Kingston 32GB");
        int opcionRAM = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        RAM ram = null;
        switch (opcionRAM) {
            case 1:
                ram = new RAM("Kingston 16GB", "Kingston", 1200.0, "RAM", 16);
                break;
            case 2:
                ram = new RAM("Kingston 32GB", "Kingston", 2000.0, "RAM", 32);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        ensamblaje.agregarRAM(ram);

        // Selección de GPU
        System.out.println("Selecciona una GPU:");
        System.out.println("1. NVIDIA RTX 3060\n2. NVIDIA RTX 4080");
        int opcionGPU = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        GPU gpu = null;
        switch (opcionGPU) {
            case 1:
                gpu = new GPU("RTX 3060", 7000.0, "NVIDIA", "GDDR6", 12);
                break;
            case 2:
                gpu = new GPU("RTX 4080", 12000.0, "NVIDIA", "GDDR6X", 16);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        ensamblaje.agregarGPU(gpu);

        // Selección de Disco
        System.out.println("Selecciona un disco:");
        System.out.println("1. HDD 1TB\n2. SSD 1TB");
        int opcionDisco = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        Disco disco = null;
        switch (opcionDisco) {
            case 1:
                disco = new HDD("HDD 1TB", 1000.0, "Seagate", 1000, 7200);
                break;
            case 2:
                disco = new Disco("SSD 1TB", 1800.0, "Kingston", 1000, "SSD");
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        ensamblaje.agregarDisco(disco);

        // Selección de Fuente de Poder
        System.out.println("Selecciona una Fuente de Poder:");
        System.out.println("1. Corsair 800W\n2. Corsair 1200W");
        int opcionFuente = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        FuentePoder fuente = null;
        switch (opcionFuente) {
            case 1:
                fuente = new FuentePoder("Corsair 800W", "Corsair", 1100.0, "Fuente", 800);
                break;
            case 2:
                fuente = new FuentePoder("Corsair 1200W", "Corsair", 1500.0, "Fuente", 1200);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        ensamblaje.agregarFuentePoder(fuente);

        // Selección de Motherboard
        System.out.println("Selecciona una Motherboard:");
        System.out.println("1. ASUS Z590\n2. ASUS Z790");
        int opcionMotherboard = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        Motherboard motherboard = null;
        switch (opcionMotherboard) {
            case 1:
                motherboard = new Motherboard("ASUS Z590", "ASUS", 3000.0, "Motherboard", "Z590");
                break;
            case 2:
                motherboard = new Motherboard("ASUS Z790", "ASUS", 3500.0, "Motherboard", "Z790");
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        ensamblaje.agregarMotherboard(motherboard);

        // Selección de Gabinete
        System.out.println("Selecciona un Gabinete:");
        System.out.println("1. NZXT H510\n2. Yeyian Lancer");
        int opcionGabinete = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        Gabinete gabinete = null;
        switch (opcionGabinete) {
            case 1:
                gabinete = new Gabinete("NZXT H510", "NZXT", 1500.0, "Gabinete");
                break;
            case 2:
                gabinete = new Gabinete("Yeyian Lancer", "Yeyian", 1200.0, "Gabinete");
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        ensamblaje.agregarGabinete(gabinete);
    }

    /**
     * Método que permite agregar software opcional a la computadora.
     */
    private void agregarSoftwareOpcional() {
        System.out.println("\n¿Deseas agregar software adicional?");
        System.out.println("1. Windows 11\n2. Office 365\n3. Photoshop\n4. AutoCAD\n5. Terminal Hacker\n6. Ninguno");

        boolean seguir = true;
        while (seguir) {
            System.out.print("Selecciona una opción (o 6 para terminar): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    ensamblaje.agregarSoftware(new SoftwareAdicional("Windows 11", 300.0));
                    break;
                case 2:
                    ensamblaje.agregarSoftware(new SoftwareAdicional("Office 365", 250.0));
                    break;
                case 3:
                    ensamblaje.agregarSoftware(new SoftwareAdicional("Adobe Photoshop", 500.0));
                    break;
                case 4:
                    ensamblaje.agregarSoftware(new SoftwareAdicional("AutoCAD", 800.0));
                    break;
                case 5:
                    ensamblaje.agregarSoftware(new SoftwareAdicional("Terminal Hacker", 100.0));
                    break;
                case 6:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * Método que procesa el pedido final y lo agrega a la lista de pedidos.
     */
    private void flujoFinal() {
        System.out.print("\nIngresa la dirección de entrega: ");
        String direccion = scanner.nextLine();
        ensamblaje.setDireccionEntrega(direccion);
        Pedido pedido = ensamblaje.crearPedido();
        pedidos.add(pedido);
        System.out.println("Pedido creado exitosamente con ID: " + pedido.getIdPedido());
    }

    /**
     * Método que muestra el resumen de los pedidos realizados.
     */
    private void mostrarResumenPedido() {
        System.out.println("\n--- Resumen de pedidos ---");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
}
