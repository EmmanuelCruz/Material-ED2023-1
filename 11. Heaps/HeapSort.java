import java.util.Arrays;

/**
 * Implementación del algoritmo de ordenamiento HeapSort.
 * @author Ermmanuel Cruz Hernández.
 * @version 1.0 Noviembre 2022.
 * @since Laboratorio de Estructuras de datos 2023-1.
 */
public class HeapSort<T extends Comparable> {

  /**
   * Ordena los elementos de un arreglo usando Heapsort.
   * @param arreglo a ordenar.
   */
  public void heapSort(T[] arreglo) {

    MaxHeap<T> maxHeap = new MaxHeap<>();

    // Agregamos los elementos al heap
    for(T element : arreglo)
      maxHeap.insert(element);
    
    for(int j = arreglo.length-1; j >= 0; j--)
      arreglo[j] = maxHeap.delete();
    
  }

  public static void main(String[] args) {
    HeapSort<Integer> heapSortObject = new HeapSort<>();
    Integer[] arreglo = {67, 90, 2, 12, 45, 23, 19, 97, 234, -74, 0};

    System.out.println("El arreglo desordenado es: "+Arrays.toString(arreglo));

    heapSortObject.heapSort(arreglo);
    System.out.println("El arreglo ordenado es: "+Arrays.toString(arreglo));

    // ------------------------------------

    HeapSort<String> heapSortString = new HeapSort<>();
    String[] arregloStrings = {"Hola", "Mundo", "Hello", "Abeja", "Oso", "Shrek", "Zapato", "Sapo"};

    System.out.println("El arreglo desordenado es: "+Arrays.toString(arregloStrings));

    heapSortString.heapSort(arregloStrings);
    System.out.println("El arreglo ordenado es: "+Arrays.toString(arregloStrings));
  }
  
}
