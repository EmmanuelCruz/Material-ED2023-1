/**
 * La implementación de los métodos de un árbol binario de búsqueda.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2022.
 * @since Laboratorio de Estructuras de Datos 2023-1.
 */
public class BinarySearchTree<K extends Comparable, T> implements TDABinarySearchTree<K, T> {

  /**
   * Representación de un nodo binario de búsqueda
   */
  private class BinaryNode {

    /** Clave del nodo */
    public K key;

    /** Elemento almacenado en el nodo */
    public T element;

    /** Hijo izquierdo */
    public BinaryNode left;

    /** Hijo derecho */
    public BinaryNode right;

    /**
     * Crea un nuevo nodo.
     * @param k la clave del nodo.
     * @param t el elemento almacenado en el nodo.
     */
    public BinaryNode(K k, T t) {
      this.key = k;
      element = t;
    }

  }

  /** Nodo raíz del árbol */
  private BinaryNode root;

  /**
   * Permite obtener un nodo a partir de su clave.
   * @param k la clave del nodo a obtener.
   * @param actual la referencia del nodo actual.
   * @return el nodo asociado a la clave k.
   */
  private BinaryNode retrieveAux(K k, BinaryNode actual) {
    // Si no existe un nodo con clave k
    if(actual == null)
      return null;
    
    // Si las claves son iguales
    if(k.compareTo(actual.key) == 0)
      return actual;
    
    if(k.compareTo(actual.key) < 0 ) { // Si la clave es menor a la clave del nodo actual
      return retrieveAux(k, actual.left);
    } else { // La clave es mayor o igual a la clave del nodo actual
      return retrieveAux(k, actual.right);
    }
  }

  @Override
  public T retrieve(K k) {
    return null;
  }

  /**
   * Permite insertar un nuevo nodo en el árbol.
   * @param newNode el nodo a insertar.
   * @param actual el nodo actual del recorrido.
   */
  private void insert(BinaryNode newNode, BinaryNode actual){
    if(newNode.key.compareTo(actual.key) < 0) { // Subarbol izquierdo
      if (actual.left != null) // Nos movemos al izquierdo
        insert(newNode, actual.left);
      else // insertamos el elemento en ese subárbol
        actual.left = newNode;
    } else { // Subarbol derecho
      if(actual.right != null) 
        insert(newNode, actual.right);
      else 
        actual.right = newNode;
    }
  }

  @Override
  public void insert(T t, K k) {
    // Creamos el nodo
    BinaryNode newNode = new BinaryNode(k, t);

    // Si el árbol está vacío
    if(root == null) {
      root = newNode;
      return;
    }

    insert(newNode, root);
  }

  @Override
  public T remove(K k) {
    return null;
  }

  @Override
  public T findMin() {
    return null;
  }

  @Override
  public T findMax() {
    return null;
  }

  /**
   * Recorre un árbol en inorden.
   * @param actual el nodo actual del recorrido.
   */
  public void inorden(BinaryNode actual){
    // Si es null
    if(actual == null)
      return;
    
    // Aplicar inorden al izquierdo
    inorden(actual.left);
    // Visitar el elemento
    System.out.println(actual.element);
    // Aplicar inorden al derecho
    inorden(actual.right);

  }

  @Override
  public void inorden(){
    inorden(root);
  }

  @Override
  public void preorden(){}

  @Override
  public void postorden(){}
  
}
