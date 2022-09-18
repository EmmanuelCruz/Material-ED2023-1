import java.util.EmptyStackException;

/**
 * Definir la lista de operaciones de un Stack
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Septiembre 2022.
 * @since Estructuras de datos 2023-1.
 */
public interface TDAStack<T> {

  /**
   * Agrega un elemento en el tope
   * @param e el elemento a insertar en la pila.
   */
  public void push(T e);

  /**
   * Elimina y regresa el tope de la pila
   * @return el elemento en el tope de la pila.
   * @throws EmptyStackException en caso de que la pila esté vacía.
   */
  public T pop() throws EmptyStackException;
  
  /**
   * Regresa el tope de la pila
   * @return el elemento en el tope de la pila.
   * @throws EmptyStackException en caso de que la pila esté vacía.
   */
  public T top() throws EmptyStackException;

 /**
  * Verificar que la lista sea vacía
  * @return true en caso de ser vacía, false en otro caso
  */
 public boolean isEmpty();
 
 /**
  * Limpia el stack
  */
  public void clear();

  /**
   * Permite visualizar los elementos de uns stack
   */
  public void show();

}