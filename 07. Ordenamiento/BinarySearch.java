/**
 * Implementación de un algoritmo que aplica búsqueda binaria.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2022.
 * @since Laboratorio de Estructuras de datos 2023-1.
 */
public class BinarySearch {
  
  /**
   * Verificar si un elemento se encuentra contenido en un arreglo ordenado de enteros.
   * @param arr el arreglo que contiene los elementos ordenados.
   * @param elem el entero a buscar dentro del arreglo.
   * @return true si elem se encuentra contenido en arr. false, en otro caso.
   */
  public static boolean binarySearch(int[] arr, int elem){
    return binarySearch(arr, elem, 0, arr.length-1);
  }

  /**
   * Verificar si un elemento se encuentra contenido en un arreglo ordenado de enteros.
   * @param arr el arreglo que contiene los elementos ordenados.
   * @param elem el entero a buscar dentro del arreglo.
   * @param lo el índice de inicio de la búsqueda.
   * @param hi el índice de fin de la búsqueda.
   * @return true si elem se encuentra contenido en arr. false, en otro caso.
   */
  private static boolean binarySearch(int[] arr, int elem, int lo, int hi){
    // Si elem no esta contenido en el arreglo arr
    if(lo > hi)
      return false;
    
    int mid = lo + ((hi-lo) / 2);

    // Si elem sí está contenido en el arreglo arr
    if(arr[mid] == elem)
      return true;
    
    if(arr[mid] < elem) // Si se encuentra en la mitad derecha
      return binarySearch(arr, elem, mid+1, hi);
    else // Se busca en la mitad izquirda
      return binarySearch(arr, elem, lo, mid-1);
      
  } // O(log n)

  public static void main(String[] args) {
    int[] arr = {1, 3, 7, 8, 10, 23, 26, 29, 46, 49, 57, 58, 60, 64, 78};

    int buscado = 57;
    System.out.println("Si el entero "+buscado+" esta contenido en el arreglo: "+binarySearch(arr, buscado));

    int buscado2 = 67;
    System.out.println("Si el entero "+buscado2+" esta contenido en el arreglo: "+binarySearch(arr, buscado2));
  }
}
