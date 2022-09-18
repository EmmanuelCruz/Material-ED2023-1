import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Implementación de una pila basada en listas.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Septiembre 2022.
 * @since Estructuras de datos 2023-1.
 */
public class Stack<T> implements TDAStack<T> {

  /* Lista de apoyo para las operaciones */
  private ArrayList<T> lista = new ArrayList<>();
  
  @Override
  public void push(T e){
    lista.add(0, e);
  }

  @Override
  public T pop() throws EmptyStackException {
    // Verificar si es vacía
    if(lista.isEmpty())
      throw new EmptyStackException();
    return lista.remove(0);
  }
  
  @Override
  public T top() throws EmptyStackException {
    // Verificar si es vacía
    if(lista.isEmpty())
      throw new EmptyStackException();
    return lista.get(0);
  }

 @Override
  public boolean isEmpty() {
    return lista.isEmpty();
  }
  
  @Override
  public void clear(){
    lista.clear();
  }

  @Override
  public void show(){
    Iterator<T> iterator = lista.iterator();
    while(iterator.hasNext()){
      System.out.println(iterator.next());
    }
  }
}
