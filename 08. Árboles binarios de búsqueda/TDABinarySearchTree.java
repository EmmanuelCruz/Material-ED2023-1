/**
 * Interfaz que define las operaciones de un árbol binario de búsqueda.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2022.
 * @since Laboratorio de Estructuras de Datos 2023-1.
 */
public interface TDABinarySearchTree<K extends Comparable, T> {
  
  /**
   * Obtener un elemento del árbol a partir de una clave.
   * @param k la clave asociada al elemento a obtener.
   * @return el objeto asociado a la clave k, o null si no existe.
   */
  public T retrieve(K k);

  /**
   * Insertar un nuevo elemento con una clave.
   * @param t el objeto a insertar en el árbol.
   * @param k la clave asociada al objeto t.
   */
  public void insert(T t, K k);

  /**
   * Remover un elemento del árbol a partir de una clave.
   * @param k la clave del nodo a eliminar.
   * @return el objeto eliminado o null si no existe algún elemento con clave k.
   */
  public T remove(K k);

  /**
   * Obtiene el objeto con clave menor.
   * @return el objeto con clave menor.
   */
  public T findMin();

  /**
   * Obtiene el objeto con clave máxima.
   * @return el objeto con clave máxima.
   */
  public T findMax();

  /**
   * Recorre los elementos del árbol en preorden.
   */
  public void preorden();

  /**
   * Recorre los elementos del árbol en inorden.
   */
  public void inorden();

  /**
   * Recorre los elementos del árbol en postorden.
   */
  public void postorden();

}
