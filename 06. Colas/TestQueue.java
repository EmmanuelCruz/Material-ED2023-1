import java.util.NoSuchElementException;

public class TestQueue {
    public static void main(String[] args) {
        TDAQueue<String> queue = new Queue<>();

        try {
        System.out.println("El tope es "+ queue.first());
        } catch (NoSuchElementException e) {
        System.out.println("La cola esta vacia");
        }

        queue.enqueue("Buho");
        queue.enqueue("Pinguino");
        queue.enqueue("Gato");
        queue.enqueue("Oso");
        queue.enqueue("Gallo");

        queue.show();

        System.out.println("El tope es "+queue.first());

        queue.dequeue();

        queue.show();

        queue.clear();

        System.err.println("La pila es vacia: "+ queue.isEmpty());

    }

}
