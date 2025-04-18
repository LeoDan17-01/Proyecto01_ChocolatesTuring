import java.util.Scanner;
import java.util.List;

public class VistaTerminal {
    private Scanner scanner;
    
    public VistaTerminal() {
        this.scanner = new Scanner(System.in);
    }
    
    // Métodos para mostrar menús principales
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
    
    // Métodos para selección de componentes
    public void mostrarMenuCPU() {
        System.out.println("\n=== SELECCIÓN DE CPU ===");
        System.out.println("1. Intel Core i5-13600K");
        System.out.println("2. Intel Core i7-13700K");
        System.out.println("3. Intel Core i9-13900K");
        System.out.println("4. AMD Ryzen 5 5600G");
        System.out.println("5. AMD Ryzen 7 7700X");
        System.out.print("Seleccione CPU: ");
    }
    
    public void mostrarMenuRAM() {
        System.out.println("\n=== SELECCIÓN DE RAM ===");
        System.out.print("Ingrese cantidad de GB (16/32): ");
    }
    
    public void mostrarMenuGPU() {
        System.out.println("\n=== SELECCIÓN DE GPU ===");
        System.out.println("1. NVIDIA RTX 3060");
        System.out.println("2. NVIDIA RTX 4070");
        System.out.println("3. AMD Radeon RX 6700 XT");
        System.out.print("Seleccione GPU: ");
    }
    
    public void mostrarMenuDisco() {
        System.out.println("\n=== SELECCIÓN DE DISCO ===");
        System.out.println("1. SSD 500GB");
        System.out.println("2. SSD 1TB");
        System.out.println("3. HDD 1TB");
        System.out.println("4. HDD 2TB");
        System.out.print("Seleccione disco: ");
    }
    
    public void mostrarMenuFuente() {
        System.out.println("\n=== SELECCIÓN DE FUENTE ===");
        System.out.println("1. EVGA 600W 80+ Bronze");
        System.out.println("2. Corsair 750W 80+ Gold");
        System.out.println("3. XPG 1000W 80+ Platinum");
        System.out.print("Seleccione fuente: ");
    }
    
    public void mostrarMenuMotherboard() {
        System.out.println("\n=== SELECCIÓN DE MOTHERBOARD ===");
        System.out.println("1. ASUS Z590 (Intel)");
        System.out.println("2. ASUS B550 (AMD)");
        System.out.println("3. MSI B760 (Intel)");
        System.out.print("Seleccione motherboard: ");
    }
    
    public void mostrarMenuGabinete() {
        System.out.println("\n=== SELECCIÓN DE GABINETE ===");
        System.out.println("1. NZXT H510");
        System.out.println("2. Lian Li O11 Dynamic");
        System.out.println("3. Yeyian Shuriken");
        System.out.print("Seleccione gabinete: ");
    }
    
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
    
    // Métodos para entrada de usuario
    public int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return opcion;
    }
    
    public String leerLinea() {
        return scanner.nextLine();
    }
    
    public String leerDireccion() {
        System.out.print("\nIngrese la dirección de entrega: ");
        return scanner.nextLine();
    }
    
    public boolean confirmar(String mensaje) {
        System.out.print(mensaje + " (S/N): ");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
    
    // Métodos para mostrar información
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void mostrarError(String error) {
        System.err.println("Error: " + error);
    }
    
    public void mostrarComponenteAgregado(String descripcion) {
        System.out.println("✓ " + descripcion);
    }
    
    public void mostrarAdvertenciaCompatibilidad(String mensaje) {
        System.out.println("⚠ Advertencia: " + mensaje);
    }
    
    public void mostrarResumenPedido(Pedido pedido) {
        System.out.println("\n=== RESUMEN DE PEDIDO ===");
        System.out.println("Número: " + pedido.getIdPedido());
        System.out.println("Fecha: " + pedido.getFechaCreacion());
        System.out.println("Sucursal: " + pedido.getSucursalDestino());
        System.out.println("Dirección: " + pedido.getDireccionEntrega());
        System.out.println("Estado: " + pedido.getEstadoActual().getDescripcionEstado());
        System.out.println("Total: $" + pedido.getPrecioTotal());
    }
    
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
    
    public void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public void cerrar() {
        scanner.close();
    }
}