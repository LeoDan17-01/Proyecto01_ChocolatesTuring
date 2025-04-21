import java.util.Scanner;
import java.util.List;

/**
 * Clase que representa la vista de usuario basada en terminal (consola).
 * Proporciona metodos para mostrar mensajes, errores, leer entradas del usuario
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
     * Muestra el menu principal de la aplicacion.
     */
    public void mostrarMenuPrincipal() {
        System.out.println("\n-----------------------------------------------------------");
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
     * Muestra informacion detallada de una sucursal.
     * @param sucursal La sucursal a mostrar
     */
    public void mostrarInfoSucursal(Sucursal sucursal) {
        System.out.println("\n===== INFORMACIÓN DE SUCURSAL ====");
        System.out.println("Nombre: " + sucursal.getNombre());
        System.out.println("Dirección: " + sucursal.getDireccion());
        System.out.println("Tipo: " + (sucursal.isCentral() ? "Central (CDMX)" : "Regional"));
    }

    /**
     * Muestra el menu de seleccion de CPU.
     */
    public void mostrarMenuCPU() {
        System.out.println("\n=== SELECCIÓN DE CPU ===");
        System.out.println("1. Intel Core i3-13100K - $1200.00");
        System.out.println("2. Intel Core i5-13600K - $2500.00");
        System.out.println("3. Intel Core i7-13700K - $3500.00");
        System.out.println("4. Intel Core i9-13900K - $5000.00");
        System.out.print("Seleccione CPU: ");
    }
    
    /**
     * Muestra el menu para ingresar cantidad de RAM.
     */
    public void mostrarMenuRAM() {
        System.out.println("\n=== SELECCIÓN DE RAM ===");
        System.out.println("1. ADATA 8GB DDR4 3200MHz - $800.00");
        System.out.println("2. ADATA 16GB DDR4 3200MHz - $1500.00");
        System.out.println("3. ADATA 32GB DDR4 3200MHz - $2800.00");
        System.out.println("4. Kingston 8GB DDR4 3200MHz - $850.00");
        System.out.println("5. Kingston 16GB DDR4 3200MHz - $1600.00");
        System.out.println("6. Kingston 32GB DDR4 3200MHz - $3000.00");
        System.out.print("Seleccione RAM: ");
    }
    
    /**
     * Muestra el menu de seleccion de GPU.
     */
    public void mostrarMenuGPU() {
        System.out.println("\n=== SELECCIÓN DE GPU ===");
        System.out.println("1. NVIDIA GTX 1660 - $2500.00");
        System.out.println("2. NVIDIA RTX 3060 - $3000.00");
        System.out.println("3. NVIDIA RTX 4070 - $4500.00");
        System.out.println("4. NVIDIA RTX 4080 - $6000.00");
        System.out.println("5. NVIDIA RTX 4090 - $8000.00");
        System.out.print("Seleccione GPU: ");
    }
    
    /**
     * Muestra el menu de seleccion de discos de almacenamiento.
     */
    public void mostrarMenuDisco() {
        System.out.println("\n=== SELECCIÓN DE DISCO ===");
        System.out.println("1. HDD Western Digital Blue 500GB - $700.00");
        System.out.println("2. HDD Western Digital Blue 1TB - $1000.00");
        System.out.println("3. HDD Seagate Barracuda 1TB - $1100.00");
        System.out.println("4. HDD Seagate Barracuda 2TB - $1600.00");
        System.out.println("5. SSD Kingston 500GB - $1200.00");
        System.out.println("6. SSD Kingston 1TB - $1800.00");
        System.out.println("7. SSD Kingston 2TB - $2500.00");
        System.out.println("8. SSD Kingston 4TB - $4000.00");
        System.out.print("Seleccione disco: ");
    }
    
    /**
     * Muestra el menu de seleccion de fuente de poder.
     */
    public void mostrarMenuFuente() {
        System.out.println("\n=== SELECCIÓN DE FUENTE ===");
        System.out.println("1. EVGA 800W 80+ Bronze - $1000.00");
        System.out.println("2. EVGA 1000W 80+ Bronze - $1300.00");
        System.out.println("3. EVGA 1500W 80+ Golde - $1800.00");
        System.out.println("4. Corsair 800W 80+ Bronze - $1050.00");
        System.out.println("5. Corsair 1200W 80+ Gold - $1600.00");
        System.out.println("6. Corsair 1500W 80+ Gold - $1900.00");
        System.out.println("7. XPG 500W 80+ Bronze - $1000.00");
        System.out.println("8. XPG 900W 80+ Gold - $1300.00");
        System.out.println("9. XPG 1300W 80+ Golde - $1900.00");
        System.out.print("Seleccione fuente: ");
    }
    
    /**
     * Muestra el menu de seleccion de motherboard.
     */
    public void mostrarMenuMotherboard() {
        System.out.println("\n=== SELECCIÓN DE MOTHERBOARD ===");
        System.out.println("1. ASUS ROG Maximus Z790 Hero - $5000.00");
        System.out.println("2. ASUS TUF Gaming B760-Plus WIFI D4 - $3200.00");
        System.out.println("3. MSI MEG Godlike - $6000.00");
        System.out.println("4. MSI MAG B760 Tomahawk WIFI DDR4 - $3500.00");
        System.out.print("Seleccione motherboard: ");
    }
    
    /**
     * Muestra el menu de seleccion de gabinete.
     */
    public void mostrarMenuGabinete() {
        System.out.println("\n=== SELECCIÓN DE GABINETE ===");
        System.out.println("1. NZXT H6 Flow ATX - $2000.00");
        System.out.println("2. Yeyian Lancer ATX - $1800.00");
        System.out.print("Seleccione gabinete: ");
    }
    
    /**
     * Muestra el menu de seleccion de software adicional.
     */
    public void mostrarMenuSoftware() {
        System.out.println("\n=== SOFTWARE ADICIONAL ===");
        System.out.println("1. Windows 11 Pro - $300");
        System.out.println("2. Microsoft Office 365 - $250");
        System.out.println("3. Adobe Photoshop - $500");
        System.out.println("4. Finalizar selección");
        System.out.print("Seleccione software: ");
    }
    
    /**
     * Lee una opcion numerica del usuario.
     * 
     * @return opcion ingresada
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
     * Lee una linea completa de entrada del usuario.
     * 
     * @return linea ingresada como texto
     */
    public String leerLinea() {
        return scanner.nextLine();
    }
    
    /**
     * Solicita al usuario ingresar una direccion de entrega.
     * @return direccion ingresada
     */
    public String leerDireccion() {
        System.out.print("\nIngrese la dirección de entrega: ");
        return scanner.nextLine();
    }
    
    /**
     * Solicita una confirmacion (Si/No) al usuario.
     * @param mensaje Mensaje a mostrar
     * @return true si el usuario responde "S", false en caso contrario
     */
    public boolean confirmar(String mensaje) {
        System.out.print(mensaje + " (S/N): ");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
    
    /**
     * Muestra un mensaje estandar en la consola.
     * 
     * @param mensaje Texto que se desea mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    /**
     * Muestra un mensaje de error en consola.
     * 
     * @param error Mensaje de error a mostrar
     */
    public void mostrarError(String error) {
        System.err.println("Error: " + error);
    }
    
    /**
     * Muestra un mensaje de exito al agregar un componente.
     * 
     * @param descripcion Descripcion del componente agregado
     */
    public void mostrarComponenteAgregado(String descripcion) {
        System.out.println("✓ " + descripcion);
    }
    
    /**
     * Muestra una advertencia de compatibilidad al usuario.
     * 
     * @param mensaje Texto con la advertencia
     */
    public void mostrarAdvertenciaCompatibilidad(String mensaje) {
        System.out.println("! Advertencia: " + mensaje);
    }
    
    /**
     * Muestra el resumen de un pedido especifico.
     * 
     * @param pedido Pedido a mostrar
     */
    public void mostrarResumenPedido(Pedido pedido) {
        System.out.println("\n=== RESUMEN DE PEDIDO ===");
        System.out.println("Número: " + pedido.getIdPedido());
        System.out.println("Fecha: " + pedido.getFechaCreacion());
        System.out.println("Sucursal Origen: " + pedido.getSucursalOrigen().getNombre());
        System.out.println("Sucursal Destino: " + pedido.getSucursalDestino().getNombre());
        System.out.println("Dirección: " + pedido.getDireccionEntrega());
        System.out.println("Estado: " + pedido.getEstadoActual().getDescripcionEstado());
        System.out.printf("Total: $%.2f%n", pedido.getPrecioTotal());
    }
    
    /**
     * Muestra una lista de todos los pedidos registrados.
     * 
     * @param pedidos Lista de pedidos
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
     * @param computadora Computadora a mostrar
     */
    public void mostrarDetallesComputadora(Computadora computadora) {
        System.out.println("\n=== DETALLES DE LA COMPUTADORA ===");
        System.out.println("- CPU: " + computadora.getCpu().getDescripcion());
        
        int totalRAM = computadora.getRams().stream().mapToInt(RAM::getCapacidadGB).sum();
        System.out.println("- RAM: " + totalRAM + "GB");
        
        if (computadora.getGpu() != null) {
            System.out.println("- GPU: " + computadora.getGpu().getDescripcion());
        }
        
        System.out.println("- Almacenamiento:");
        for (Disco disco : computadora.getDiscos()) {
            System.out.println("  • " + disco.getDescripcion());
        }
        
        System.out.println("- Fuente: " + computadora.getFuente().getDescripcion());
        System.out.println("- Motherboard: " + computadora.getMotherboard().getDescripcion());
        System.out.println("- Gabinete: " + computadora.getGabinete().getDescripcion());
        
        if (!computadora.getSoftware().isEmpty()) {
            System.out.println("- Software incluido:");
            for (SoftwareAdicional soft : computadora.getSoftware()) {
                System.out.printf("  • %s - $%.2f%n", soft.getNombre(), soft.getPrecio());
            }
        }
        
        System.out.printf("TOTAL: $%.2f%n", computadora.calcularPrecioTotal());
    }
    
    /**
     * Limpia la pantalla de la terminal (emulacion basica).
     */
    public void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    /**
     * Cierra el lector de consola.
     * Debe llamarse antes de terminar la aplicacion.
     */
    public void cerrar() {
        scanner.close();
    }
}