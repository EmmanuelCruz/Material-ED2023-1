import java.util.NoSuchElementException;
/**
 * Definir la lista de operaciones de una Cola/ Queue
 * 
 * @version 1.0 Septiembre 2022.
 * @since Estructuras de datos 2023-1.
 */
public interface TDAQueue<T> {
   
    /**
     * Limpia la cola. Elimina todos los elementos.
     */
    public void clear();

    /**
     * Remueve y regresa el siguiente elemento en la cola.
     * 
     * @return el siguiente en la cola.
     * @throws NoSuchElementException si la cola está vacía.
     */
    public T dequeue() throws NoSuchElementException;

    /**
     * Agrega un nuevo al final de la cola.
     * 
     * @param e el elemento a agregar.
     */
    public void enqueue(T e);

    /**
     * Devuelve el elemento siguiente en la cola, sin eliminarlo.
     * 
     * @return el siguiente elemento en la cola.
     * @throws NoSuchElementException si la cola está vacía.
     */
    public T first() throws NoSuchElementException;

    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola no contiene elementos, false en otro caso.
     */
    public boolean isEmpty();

    public void show();

}

