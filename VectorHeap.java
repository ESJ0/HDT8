import java.util.ArrayList;

public class VectorHeap<T extends Comparable<T>> implements PriorityQueue<T> {
    protected ArrayList<T> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    protected int padre(int i){ 
        return (i - 1) / 2;
    }
    protected int left(int i){
        return 2 * i + 1; 
    }

    protected int right(int i){ 
        return 2 * i + 2; 
    }

    protected void filtrarArriba(int i) {
        T value = data.get(i);
        while (i > 0 && value.compareTo(data.get(padre(i))) < 0) {
            data.set(i, data.get(padre(i)));
            i = padre(i);
        }
        data.set(i, value);
    }

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

    @Override
    public void add(T value) {
        data.add(value);
        filtrarArriba(data.size() - 1);
    }

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

    @Override
    public T peek() {
        return data.isEmpty() ? null : data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}