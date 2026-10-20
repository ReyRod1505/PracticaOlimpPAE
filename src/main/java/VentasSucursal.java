import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VentasSucursal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de ventas (n):");
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        System.out.println("Ingresa " + n + " líneas con el formato: sucursal importe (ejemplo: Managua 100)");

        // Mapa para acumular las ventas por sucursal
        Map<String, Long> ventas = new HashMap<>();

        String sucursalGanadora = "";
        long maxVentas = -1;

        for (int i = 0; i < n; i++) {
            String sucursal = scanner.next();
            long importe = scanner.nextLong();

            // Sumar el importe actual al total acumulado de la sucursal
            long totalActual = ventas.getOrDefault(sucursal, 0L) + importe;
            ventas.put(sucursal, totalActual);

            // Lógica para determinar la sucursal ganadora y manejar empates
            if (totalActual > maxVentas) {
                maxVentas = totalActual;
                sucursalGanadora = sucursal;
            } else if (totalActual == maxVentas) {
                // En empate gana la sucursal menor según String.compareTo
                if (sucursal.compareTo(sucursalGanadora) < 0) {
                    sucursalGanadora = sucursal;
                }
            }
        }

        // Imprimir el resultado esperado: "Nombre Total"
        System.out.println("Sucursal ganadora:");
        System.out.println(sucursalGanadora + " " + maxVentas);

        scanner.close();
    }
}