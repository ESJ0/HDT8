/**
 * class PriorityQueue<T> es una interfaz que define las operaciones básicas de una cola de prioridad.
 */

public interface PriorityQueue<T> {
    public void add(T value);
    public T remove();
    public T peek();
    public boolean isEmpty();
}
