import java.util.Arrays;

/**
 * Implementación para la representación de un montículo máximo.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Noviembre 2022.
 * @since Laboratorio de Estructuras de Datos 2023-1.
 */
public class MaxHeap<K extends Comparable> {

  /** Un arreglo con los registros */
  private K[] data;

  /** Máxima longitud por default */
  private int MAX = 100;

  /** Pivote para saber la posición libre del árbol */
  private int pos = 0;

  /**
   * Crea un nuevo montículo máximo.
   * @param size la longitu del arreglo de datos.
   */
  public MaxHeap(int size) {
    data = (K[]) new Comparable[size];
  }

  /**
   * Crea un nuevo montículo máximo.
   */
  public MaxHeap() {
    data = (K[]) new Comparable[MAX];
  }

  /**
   * Insertar un elemento en el árbol.
   * @param k el elemento a insertar en el árbol.
   */
  public void insert(K k){
    // Si no hay espacio en el arreglo data
    if(pos == data.length)
      data = Arrays.copyOf(data, data.length + MAX);

    data[pos++] = k;

    reacomodaArriba(pos-1);
  }

  /**
   * Reacomoda un objeto hacía arriba a partir de un índice.
   * @param i el índice del cual comenzar a reacomodar.
   */
  private void reacomodaArriba(int i){
    // Obtener el índice del padre
    int padre = (i-1) / 2;
    
    if(padre < 0) return;

    // Si el elemento actual es menor a su padre
    if(data[i].compareTo(data[padre]) <= 0)
      return;

    swap(i, padre);
    reacomodaArriba(padre);
  }

  /**
   * Aplica un swap entre dos elementos
   * @param i el primer indice para realizar el swap.
   * @param j el segundo indice para realizar el swap.
   */
  private void swap(int i, int j) {
    K aux = data[i];
    data[i] = data[j];
    data[j] = aux;
  }

  /**
   * Eliminar y regresar un elemento del árbol.
   * @return el objeto con mayor peso dentro del árbol
   */
  public K delete() {
    // Es vacio
    if(data[0] == null)
      return null;    

    K result = data[0];
    swap(0, pos-1);
    data[--pos] = null;

    reacomodaAbajo(0);

    return result;
  }

  /**
   * Reacomodar los elementos hacía abajo.
   * @param i el índice del elemento a reacomodar.
   */
  private void reacomodaAbajo(int i) {
    int izquierdo = (2*i) + 1;   
    int derecho = (2*i) + 2;
    
    // Si no tiene hijos
    if(izquierdo >= pos && derecho >= pos)
      return;
    
    if(data[izquierdo] != null) {
      if(data[derecho] != null){ // El nodo tiene ambos hijos
        if(data[i].compareTo(data[izquierdo]) > 0 && data[i].compareTo(data[derecho]) > 0)
          return;
        if(data[i].compareTo(data[izquierdo]) < 0 || data[i].compareTo(data[derecho]) < 0){
          int max = data[izquierdo].compareTo(data[derecho]) > 0 ? izquierdo : derecho;
          swap(i, max);
          reacomodaAbajo(max);
        }
      }
      else{ // El nodo tiene un solo hijo
        if(data[i].compareTo(data[izquierdo]) > 0)
          return;
        if(data[i].compareTo(data[izquierdo]) < 0){
          swap(i, izquierdo);
          reacomodaAbajo(izquierdo);
        }
      }
    }
  }

}