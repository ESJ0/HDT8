import java.io.*;
import java.util.Scanner;

/**
 * Clase principal para gestionar la cola de pacientes.
 * Lee los datos de un archivo y los añade a una cola de prioridad.
 */

public class Main {
    public static void main(String[] args) {
        VectorHeap<Paciente> cola = new VectorHeap<>();

        try (Scanner sc = new Scanner(new File("pacientes.txt"))) {
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    char codigo = partes[2].trim().charAt(0);
                    cola.add(new Paciente(nombre, sintoma, codigo));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Atendiendo pacientes en orden de prioridad:");
        while (!cola.isEmpty()) {
            System.out.println(cola.remove());
        }
    }
}
