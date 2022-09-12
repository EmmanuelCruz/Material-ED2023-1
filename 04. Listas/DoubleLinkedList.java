/**
 * Implementación de una lista doblemente ligada
 * 
 * @author Emmanuel Cruz Hernández
 * @version 1.0 2022
 * @since Estructuras de datos 2023-1.
 */
public class DoubleLinkedList<T> implements TDAList<T> {

  /**
   * Representación de un Nodo
   */
  private class Node {

    /** Elemento almacenado en el nodo */
    public T element;

    /** Referencia a un nodo siguiente */
    public Node next;

    /** Referencia a un nodo anterior */
    public Node prev;

    /**
     * Crea un nuevo nodo
     * @param e el elemento a almacenar en el nodo
     */
    public Node(T e) {
      this.element = e;
    }

  }

  /** Nodo cabeza */
  public Node head;

  /** Nodo cola */
  public Node tail;
  
  @Override
  public void add(int i, T e) throws IndexOutOfBoundsException {
    // Pasan algún indice inválido
    if(i < 0 || i > size())
      throw new IndexOutOfBoundsException("La posicion "+i+" esta fuera del rango valido. [0,"+size()+"]");

    // Crear un nuevo nodo
    Node newNode = new Node(e);

    // Cuando la lista es vacía
    if(head == null){
      head = newNode;
      tail = newNode;
      return;
    }

    // Se agrega en la primera posición
    if(i == 0) {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
      return;
    }

    // Agregar en la última posición
    if(i == size()){
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
      return;
    }

    // Para saber si insertamos desde head o insertamos desde tail
    if(i < size()/2){ // Insertar desde head
      Node headIterator = head;
  
      for(int counter = 0; counter < i-1; counter++)
        headIterator = headIterator.next;
      
      newNode.next = headIterator.next;
      newNode.prev = headIterator;
      headIterator.next.prev = newNode;
      headIterator.next = newNode;
    } else { // Insertar desde tail
      // Se queda como ejercicio
    }


  }

  @Override
  public T remove(int i) throws IndexOutOfBoundsException {
    return null;
  }

  @Override
  public void clear(){}

  @Override
  public T get(int i) throws IndexOutOfBoundsException {
    return null;
  }

  @Override
  public boolean contains(T e){
    return false;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    Node iterator = head;
    int counter = 0;

    while(iterator != null){
      counter++;
      iterator = iterator.next;
    }

    return counter;
  }

  /**
   * Mostar los elementos de una lista
   */
  public void show() {
    Node iterator = head;
    while(iterator != null){
      System.out.println(iterator.element);
      iterator = iterator.next;
    }
  }
  
}
