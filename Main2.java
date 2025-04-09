import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;

/**
 * Clase principal para gestionar la cola de pacientes, pero ahora utilizando la JCf.
 * Lee los datos de un archivo y los añade a una cola de prioridad.
 */
public class Main2 {
    public static void main(String[] args) {
        PriorityQueue<Paciente> cola = new PriorityQueue<>();

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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Atendiendo pacientes con JCF:");
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }
}
