public class EstadoVerificacion implements EstadoEnvio {
    @Override
    public void procesarEstado(Pedido pedido) {
        System.out.println("\n=== VERIFICACIÓN TÉCNICA ===");
        Computadora computadora = pedido.getComputadora();
        
        try {
            // 1. Verificar compatibilidad de componentes
            verificarCompatibilidad(computadora);
            
            // 2. Verificar requisitos mínimos
            verificarRequisitos(computadora);
            
            // 3. Verificar balance del sistema
            verificarBalance(computadora);
            
            // 4. Mostrar resumen
            mostrarResumen(computadora);
            
            System.out.println("Verificación completada exitosamente");
            // Pasar al siguiente estado (ej: EstadoEntrega)
            
        } catch (Exception e) {
            System.err.println("Error en verificación: " + e.getMessage());
            pedido.setEstadoActual(new EstadoEnsamblaje()); // Volver a ensamblaje si hay errores
        }
    }

    @Override
    public String getDescripcionEstado() {
        return "Verificación técnica de componentes";
    }

    @Override
    public String getInstruccionesSeguimiento() {
        return "Los componentes están siendo verificados para garantizar compatibilidad y rendimiento";
    }

    // ========== MÉTODOS PRIVADOS ==========
    
    private void verificarCompatibilidad(Computadora comp) {
        System.out.println("\n[1/4] Verificando compatibilidad...");
        
        // CPU + Motherboard
        if (comp.getCpu() != null && comp.getMotherboard() != null) {
            if (!comp.getCpu().getSocket().equals(comp.getMotherboard().getTipoSocket())) {
                throw new RuntimeException("Incompatibilidad CPU-Motherboard (socket no coincide)");
            }
        }
        
        // RAM + Motherboard
        if (!comp.getRams().isEmpty() && comp.getMotherboard() != null) {
            String tipoRamEsperado = comp.getMotherboard().getChipset().contains("DDR5") ? "DDR5" : "DDR4";
            for (RAM ram : comp.getRams()) {
                if (!ram.getTipoMemoria().equals(tipoRamEsperado)) {
                    System.err.println("ADVERTENCIA: RAM " + ram.getNombre() + " podría ser incompatible");
                }
            }
        }
    }
    
    private void verificarRequisitos(Computadora comp) {
        System.out.println("\n[2/4] Verificando requisitos...");
        
        // Verificar RAM mínima
        int totalRAM = comp.getRams().stream().mapToInt(RAM::getCapacidadGB).sum();
        if (totalRAM < 8) {
            System.err.println("ADVERTENCIA: Sistema con menos de 8GB de RAM");
        }
        
        // Verificar almacenamiento
        if (comp.getDiscos().isEmpty()) {
            throw new RuntimeException("No se detectaron unidades de almacenamiento");
        }
    }
    
    private void verificarBalance(Computadora comp) {
        System.out.println("\n[3/4] Verificando balance...");
        
        if (comp.getCpu() != null && comp.getGpu() != null) {
            boolean cpuHighEnd = comp.getCpu().getNumNucleos() >= 8;
            boolean gpuHighEnd = comp.getGpu().getVramGB() >= 8;
            
            if (cpuHighEnd && !gpuHighEnd) {
                System.err.println("ADVERTENCIA: CPU potente con GPU limitada (posible cuello de botella)");
            } else if (!cpuHighEnd && gpuHighEnd) {
                System.err.println("ADVERTENCIA: GPU potente con CPU limitada (posible cuello de botella)");
            }
        }
    }
    
    private void mostrarResumen(Computadora comp) {
        System.out.println("\n[4/4] Resumen del sistema:");
        System.out.println("- CPU: " + (comp.getCpu() != null ? comp.getCpu().getDescripcion() : "N/A"));
        System.out.println("- RAM: " + comp.getRams().stream().mapToInt(RAM::getCapacidadGB).sum() + "GB");
        System.out.println("- GPU: " + (comp.getGpu() != null ? comp.getGpu().getDescripcion() : "N/A"));
        System.out.println("- Almacenamiento: " + comp.getDiscos().size() + " unidades");
        System.out.println("- Fuente: " + (comp.getFuente() != null ? comp.getFuente().getDescripcion() : "N/A"));
    }
}