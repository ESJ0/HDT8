import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Clase de prueba para la clase VectorHeap.
 */
public class JUnit {
    /**
     * Prueba de la clase Paciente.
     */
    @Test
    public void testAddAndRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        Paciente p1 = new Paciente("Juan", "dolor", 'C');
        Paciente p2 = new Paciente("Maria", "fiebre", 'A');
        heap.add(p1);
        heap.add(p2);
        assertEquals("Maria", heap.remove().getNombre());
        assertEquals("Juan", heap.remove().getNombre());
    }
}

