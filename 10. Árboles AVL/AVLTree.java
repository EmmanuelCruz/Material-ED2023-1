/**
 * La implementación de los métodos de un árbol binario de búsqueda.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2022.
 * @since Laboratorio de Estructuras de Datos 2023-1.
 */
public class AVLTree<K extends Comparable, T> implements TDABinarySearchTree<K, T> {

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

    /** Padre del nodo */
    public BinaryNode parent;

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

  /**
   * Permite obtener la altura de un nodo.
   * @param v el nodo del cual obtener la altura
   * @return la altura del nodo.
   */
  private int h(BinaryNode v){
    // Si es nulo
    if(v == null)
      return -1;
    int vi = h(v.left);
    int vd = h(v.right);
    return 1 + (vi > vd ? vi : vd);
  }

  /**
   * Permite obtener el balance de un nodo v.
   * @param v el nodo del cual obtener el balance
   * @return el balance del nodo v.
   */
  private int b(BinaryNode v){
    return h(v.left) - h(v.right);
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
   * @return el nodo nuevo insertado
   */
  private BinaryNode insert(BinaryNode newNode, BinaryNode actual){
    if(newNode.key.compareTo(actual.key) < 0) { // Subarbol izquierdo
      if (actual.left != null) // Nos movemos al izquierdo
        return insert(newNode, actual.left);
      else { // insertamos el elemento en ese subárbol
        actual.left = newNode;
        return newNode;
      }
    } else { // Subarbol derecho
      if(actual.right != null) 
        return insert(newNode, actual.right);
      else {
        actual.right = newNode;
        return newNode;
      }
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

    BinaryNode inserted = insert(newNode, root);

    // Realiza el rebalanceo
    rebalancea(inserted);
  }

  /**
   * Permite realizar el rebalanceo desde un nodo v hasta la raíz.
   * @param actual el nodo actual para realizar el rebalanceo.
   */
  private void rebalancea(BinaryNode actual){
    // Si el parámetro es null
    if(actual == null)
      return;
    
    if(b(actual) < -1){
      if(b(actual.right) < 1){
        // Se rota actual a la izquierda
        // Se recalculan las alturas
        rebalancea(actual.parent);
      } else if(b(actual.right) ==1 ){
        // Rotar actual.right a la derecha
        // Rotar a v hacia la izuierda
        // Recalcular alturas y rebalanceo
        rebalancea(actual.parent);
      }
    } else if(b(actual) > 1){
      if(b(actual.left) > -1){
        // Rotamos a actual a la derecha
        // Recalculamos las alturas
        rebalancea(actual.parent);
      } else if(b(actual.left) == -1) {
        // Rotamos actual.left a la izquierda
        // Rotamos actual a la derecha
        // Recalculamos las alturas
        rebalancea(actual.parent);
      }
    }
  }

  @Override
  public T remove(K k) {
    // Realizar la eliminación tal cual como se hace en un árbol binario de búsqueda

    BinaryNode removed = null; // El resultado de la eliminación de un nodo

    rebalancea(removed);
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
