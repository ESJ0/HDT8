import java.util.ArrayList;

/**
 * Clase que implementa una cola de prioridad utilizando un vector como base.
 */

public class VectorHeap<T extends Comparable<T>> implements PriorityQueue<T> {
    protected ArrayList<T> data;

    /**
     * Constructor de la clase VectorHeap.
     */
    public VectorHeap() {
        data = new ArrayList<>();
    }

    /**
     * Método para obtener el índice del padre de un nodo dado.
     * @param i Índice del nodo.
     * @return Índice del padre del nodo.
     */
    protected int padre(int i){ 
        return (i - 1) / 2;
    }

    /**
     * Método para obtener el índice del hijo izquierdo de un nodo dado.
     * @param i Índice del nodo.
     * @return Índice del hijo izquierdo del nodo.
     */
    protected int left(int i){
        return 2 * i + 1; 
    }

    /**
     * Método para obtener el índice del hijo derecho de un nodo dado.
     * @param i Índice del nodo.
     * @return Índice del hijo derecho del nodo.
     */
    protected int right(int i){ 
        return 2 * i + 2; 
    }

    /**
     * Método para filtrar hacia arriba un nodo en el heap.
     * @param i Índice del nodo a filtrar.
     */
    protected void filtrarArriba(int i) {
        T value = data.get(i);
        while (i > 0 && value.compareTo(data.get(padre(i))) < 0) {
            data.set(i, data.get(padre(i)));
            i = padre(i);
        }
        data.set(i, value);
    }

    /**
     * Método para filtrar hacia abajo un nodo en el heap.
     * @param i Índice del nodo a filtrar.
     */
    protected void filtrarAbajo(int i) {
        int child;
        T value = data.get(i);
        while (left(i) < data.size()) {
            child = left(i);
            if (right(i) < data.size() &&
                data.get(right(i)).compareTo(data.get(child)) < 0) {
                child = right(i);
            }
            if (data.get(child).compareTo(value) < 0) {
                data.set(i, data.get(child));
                i = child;
            } else {
                break;
            }
        }
        data.set(i, value);
    }

    /**
     * Método para obtener el tamaño del heap.
     * @return Tamaño del heap.
     */
    @Override
    public void add(T value) {
        data.add(value);
        filtrarArriba(data.size() - 1);
    }

    /**
     * Método para eliminar el elemento de mayor prioridad del heap.
     * @return Elemento de mayor prioridad.
     */
    @Override
    public T remove() {
        if (isEmpty()) return null;
        T min = data.get(0);
        T last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            filtrarAbajo(0);
        }
        return min;
    }

    /**
     * Método para obtener el elemento de mayor prioridad sin eliminarlo.
     * @return Elemento de mayor prioridad.
     */
    @Override
    public T peek() {
        return data.isEmpty() ? null : data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}