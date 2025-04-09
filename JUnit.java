import static org.junit.Assert.*;
import org.junit.Test;

public class JUnit {
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

