import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Implementación de una cola basada en una lista oblemente ligada.
 * Implementa las operaciones del TDAQueue.
 * @version 1.0 Junio 2021.
 * 
 * @since Estructuras de datos 2021-2.
 */
public class Queue<T> implements TDAQueue<T> {
    /* Lista de apoyo para las operaciones */
    private ArrayList<T> lista = new ArrayList<>();
    
    /**
     * Remueve y regresa el siguiente elemento en la cola.
     * 
     * @return el siguiente en la cola.
     * @throws NoSuchElementException si la cola está vacía.
     */
    @Override
    public T dequeue() throws NoSuchElementException{
        if (lista.isEmpty()) {
            throw new NoSuchElementException();
        }
        return lista.remove(0);

    }

    @Override
    public void enqueue(T e){
        lista.add(lista.size(),e);

    }

    @Override
    public T first() throws NoSuchElementException{
        if (lista.isEmpty()) {
            throw new NoSuchElementException();
        }
        return lista.get(0);
    }
    

    @Override
    public void clear(){
        lista.clear();
    }

    @Override
    public boolean isEmpty(){
        return lista.isEmpty();
    }

    
    public void show() {
        Iterator<T> iterator = lista.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
