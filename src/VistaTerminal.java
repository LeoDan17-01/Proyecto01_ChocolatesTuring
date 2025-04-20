import java.util.Scanner;
import java.util.List;

/**
 * Clase que representa la vista de usuario basada en terminal (consola).
 * 
 * Proporciona métodos para mostrar mensajes, errores, leer entradas del usuario
 * y facilitar la interacción textual con el sistema.
 */
public class VistaTerminal {
    private Scanner scanner;
    
    /**
     * Constructor que inicializa la vista y el lector de consola.
     */
    public VistaTerminal() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Muestra el menú principal de la aplicación.
     */
    public void mostrarMenuPrincipal() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("                PC Builder - Ensamblaje de Computadoras");
        System.out.println("-----------------------------------------------------------");
        System.out.println("\nMenú Principal:");
        System.out.println("1. Comprar PC prearmada");
        System.out.println("2. Armar PC personalizada");
        System.out.println("3. Ver resumen de pedidos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Muestra el menú de selección de CPU.
     */
    public void mostrarMenuCPU() {
        System.out.println("\n=== SELECCIÓN DE CPU ===");
        System.out.println("1. Intel Core i5-13600K");
        System.out.println("2. Intel Core i7-13700K");
        System.out.println("3. Intel Core i9-13900K");
        System.out.println("4. AMD Ryzen 5 5600G");
        System.out.println("5. AMD Ryzen 7 7700X");
        System.out.print("Seleccione CPU: ");
    }
    
    /**
     * Muestra el menú para ingresar cantidad de RAM.
     */
    public void mostrarMenuRAM() {
        System.out.println("\n=== SELECCIÓN DE RAM ===");
        System.out.print("Ingrese cantidad de GB (16/32): ");
    }
    
    /**
     * Muestra el menú de selección de GPU.
     */
    public void mostrarMenuGPU() {
        System.out.println("\n=== SELECCIÓN DE GPU ===");
        System.out.println("1. NVIDIA RTX 3060");
        System.out.println("2. NVIDIA RTX 4070");
        System.out.println("3. AMD Radeon RX 6700 XT");
        System.out.print("Seleccione GPU: ");
    }
    
    /**
     * Muestra el menú de selección de discos de almacenamiento.
     */
    public void mostrarMenuDisco() {
        System.out.println("\n=== SELECCIÓN DE DISCO ===");
        System.out.println("1. SSD 500GB");
        System.out.println("2. SSD 1TB");
        System.out.println("3. HDD 1TB");
        System.out.println("4. HDD 2TB");
        System.out.print("Seleccione disco: ");
    }
    
    /**
     * Muestra el menú de selección de fuente de poder.
     */
    public void mostrarMenuFuente() {
        System.out.println("\n=== SELECCIÓN DE FUENTE ===");
        System.out.println("1. EVGA 600W 80+ Bronze");
        System.out.println("2. Corsair 750W 80+ Gold");
        System.out.println("3. XPG 1000W 80+ Platinum");
        System.out.print("Seleccione fuente: ");
    }
    
    /**
     * Muestra el menú de selección de motherboard.
     */
    public void mostrarMenuMotherboard() {
        System.out.println("\n=== SELECCIÓN DE MOTHERBOARD ===");
        System.out.println("1. ASUS Z590 (Intel)");
        System.out.println("2. ASUS B550 (AMD)");
        System.out.println("3. MSI B760 (Intel)");
        System.out.print("Seleccione motherboard: ");
    }
    
    /**
     * Muestra el menú de selección de gabinete.
     */
    public void mostrarMenuGabinete() {
        System.out.println("\n=== SELECCIÓN DE GABINETE ===");
        System.out.println("1. NZXT H510");
        System.out.println("2. Lian Li O11 Dynamic");
        System.out.println("3. Yeyian Shuriken");
        System.out.print("Seleccione gabinete: ");
    }
    
    /**
     * Muestra el menú de selección de software adicional.
     */
    public void mostrarMenuSoftware() {
        System.out.println("\n=== SOFTWARE ADICIONAL ===");
        System.out.println("1. Windows 11 Pro - $300");
        System.out.println("2. Microsoft Office 365 - $250");
        System.out.println("3. Adobe Photoshop - $500");
        System.out.println("4. AutoCad - $700");
        System.out.println("5. Terminal con WSL - $150");
        System.out.println("6. Finalizar selección");
        System.out.print("Seleccione software: ");
    }
    
    /**
     * Lee una opción numérica del usuario.
     *
     * @return opción ingresada.
     */
    public int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return opcion;
    }
    
    /**
     * Lee una línea completa de entrada del usuario.
     *
     * @return línea ingresada como texto.
     */
    public String leerLinea() {
        return scanner.nextLine();
    }
    
    /**
     * Solicita al usuario ingresar una dirección de entrega.
     *
     * @return dirección ingresada.
     */
    public String leerDireccion() {
        System.out.print("\nIngrese la dirección de entrega: ");
        return scanner.nextLine();
    }
    
    /**
     * Solicita una confirmación (Sí/No) al usuario.
     *
     * @param mensaje Mensaje a mostrar.
     * @return true si el usuario responde "S", false en caso contrario.
     */
    public boolean confirmar(String mensaje) {
        System.out.print(mensaje + " (S/N): ");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
    
    /**
     * Muestra un mensaje estándar en la consola.
     *
     * @param mensaje Texto que se desea mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    /**
     * Muestra un mensaje de error en consola, precedido por "ERROR: ".
     *
     * @param mensaje Mensaje de error a mostrar.
     */
    public void mostrarError(String error) {
        System.err.println("Error: " + error);
    }
    
    /**
     * Muestra un mensaje de éxito al agregar un componente.
     *
     * @param descripcion Descripción del componente agregado.
     */
    public void mostrarComponenteAgregado(String descripcion) {
        System.out.println("✓ " + descripcion);
    }
    
    /**
     * Muestra una advertencia de compatibilidad al usuario.
     *
     * @param mensaje Texto con la advertencia.
     */
    public void mostrarAdvertenciaCompatibilidad(String mensaje) {
        System.out.println("⚠ Advertencia: " + mensaje);
    }
    
    /**
     * Muestra el resumen de un pedido específico.
     *
     * @param pedido Pedido a mostrar.
     */
    public void mostrarResumenPedido(Pedido pedido) {
        System.out.println("\n=== RESUMEN DE PEDIDO ===");
        System.out.println("Número: " + pedido.getIdPedido());
        System.out.println("Fecha: " + pedido.getFechaCreacion());
        System.out.println("Sucursal: " + pedido.getSucursalDestino());
        System.out.println("Dirección: " + pedido.getDireccionEntrega());
        System.out.println("Estado: " + pedido.getEstadoActual().getDescripcionEstado());
        System.out.println("Total: $" + pedido.getPrecioTotal());
    }
    
    /**
     * Muestra una lista de todos los pedidos registrados.
     *
     * @param pedidos Lista de pedidos.
     */
    public void mostrarListaPedidos(List<Pedido> pedidos) {
        System.out.println("\n=== HISTORIAL DE PEDIDOS ===");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println("----------------------------------------");
                mostrarResumenPedido(pedido);
            }
        }
    }
    
    /**
     * Muestra en detalle los componentes de una computadora ensamblada.
     *
     * @param computadora Computadora a mostrar.
     */
    public void mostrarDetallesComputadora(Computadora computadora) {
        System.out.println("\n=== DETALLES DE LA COMPUTADORA ===");
        System.out.println("- CPU: " + computadora.getCpu().getDescripcion());
        System.out.println("- RAM: " + computadora.getRams().get(0).getDescripcion());
        if (computadora.getGpu() != null) {
            System.out.println("- GPU: " + computadora.getGpu().getDescripcion());
        }
        System.out.println("- Almacenamiento: ");
        for (Disco disco : computadora.getDiscos()) {
            System.out.println("  • " + disco.getDescripcion());
        }
        System.out.println("- Fuente: " + computadora.getFuente().getDescripcion());
        System.out.println("- Motherboard: " + computadora.getMotherboard().getDescripcion());
        System.out.println("- Gabinete: " + computadora.getGabinete().getDescripcion());
        
        if (!computadora.getSoftware().isEmpty()) {
            System.out.println("- Software incluido:");
            for (SoftwareAdicional soft : computadora.getSoftware()) {
                System.out.println("  • " + soft.getNombre() + " - $" + soft.getPrecio());
            }
        }
        
        System.out.println("TOTAL: $" + computadora.calcularPrecioTotal());
    }
    
    /**
     * Limpia la pantalla de la terminal (emulación básica).
     */
    public void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    /**
     * Cierra el lector de consola.
     * Debe llamarse antes de terminar la aplicación.
     */
    public void cerrar() {
        scanner.close();
    }
}