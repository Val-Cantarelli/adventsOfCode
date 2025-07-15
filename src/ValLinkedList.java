import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ValLinkedList<V> implements Iterable<V> {
    private Node first;

    public void add(V i) {
        if (first == null){
            first = new Node(i);
        } else {
            first = new Node(i, first);
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new MyIterator<>();
    }

    @Override
    public void forEach(Consumer<? super V> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<V> spliterator() {
        return Iterable.super.spliterator();
    }


    private class MyIterator<V> implements Iterator<V>{
        Node<V> current;
        private MyIterator(){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public V next() {
            return current.next.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super V> action) {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<V> {
        private V value;
        private Node<V> next;

        public Node(V i) {
            this.value = i;
        }

        public Node(V i, Node first) {
            this.next = first;
            this.value = i;
        }
    }


}
