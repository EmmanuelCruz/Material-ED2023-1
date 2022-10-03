import java.util.Random;
import java.util.Arrays;

/**
 * Implementación de algunos algoritmos de ordenamiento.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2022.
 * @since Estructuras de Datos 2023-1.
 */
public class Sorter {

  /**
   * Itercambiar de posición a dos elementos de un arreglo de enteros.
   * @param arr arreglo del cuál intercambiar los elementos.
   * @param i la primera posición del elemento para hacer el intercambio.
   * @param j la segunda posición del elemento para hacer el intercambio.
   */
  public static void swap(int[] arr, int i, int j){
    int aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
  }

  /**
   * Ordena un arreglo con el algoritmo de InsertionSort.
   * @param arr el arreglo con los enteros a ordenar.
   */
  public static void insertionSort(int[] arr){
    for(int i = 0; i < arr.length-1; i++){
      for(int j = i+1; j>0 && arr[j-1]>arr[j]; j--){
        swap(arr, j, j-1);
      }
    }
  }

  /**
   * Generar un arreglo con números aleatorios.
   * @param n la longitud del arreglo a generar.
   * @param max el número máximo a generarse aleatoriamente.
   * @return el arreglo generado.
   */
  public static int[] generateArray(int n, int max){
    int[] result = new int[n];
    Random rn = new Random();
    for(int i=0; i < n ; i++){
      result[i] = rn.nextInt(max);
    }
    return result;
  }

  /**
   * Ordena un arreglo de enteros con el algoritmo mergeSort.
   * @param arr el arreglo con los enteros a ordenar.
   */
  public static void mergeSort(int[] arr){
    mergeSort(arr, 0, arr.length - 1);
  }

  /**
   * Auxiliar para el metodo mergeSort.
   * @param arr el arreglo con los enteros a ordenar.
   * @param lo el indice de inicio para ordenar.
   * @param hi el indice de fin para ordenar.
   */
  private static void mergeSort(int[] arr, int lo, int hi){
    if(hi <= lo)
      return;
    
    int mid = lo + ((hi-lo) / 2);
    mergeSort(arr, lo, mid);
    mergeSort(arr, mid+1, hi);
    merge(arr, lo, mid, hi);
  }

  /**
   * Permite meclar los valores de los indices datos.
   * @param arr el arreglo con los elementos a ordenar.
   * @param lo el indice de inicio del rango.
   * @param mid la mitad del rango a mezclar.
   * @param hi el indice de fin del rango.
   */
  public static void merge(int[] arr, int lo, int mid, int hi){
    // Elementos de la primera mitad
    int i = lo;
    // Elementos de la segunda mitad
    int j = mid + 1;

    // Hacemos una copia del arreglo
    int[] aux = Arrays.copyOf(arr, arr.length);

    for(int k = lo; k<=hi; k++){
      if(i > mid){ // Si ya se recorrieron los elementos de la primera mitad
        arr[k] = aux[j++];
      } else if(j > hi){ // Si ya se recorrieron los elementos de la segunda mitad
        arr[k] = aux[i++];
      } else if(aux[j] < aux[i]){ // Si el elemento de la segunda mitad es menor
        arr[k] = aux[j++];
      } else { // Si el elemento de la primera mitad es menor
        arr[k] = aux[i++];
      }
    }

  }

  public static void main(String[] args) {
    
    int[] generado = generateArray(100000, 100000);
    int[] generado2 = Arrays.copyOf(generado, generado.length);
    // System.out.println("El arreglo generado es: "+Arrays.toString(generado));
    
    long inicio = System.currentTimeMillis();
    insertionSort(generado);
    long fin = System.currentTimeMillis();
    System.out.println("InsertionSort se tardo: "+(fin-inicio)+" milisegundos");
    
    // System.out.println("El arreglo ordenado con insertionSort es: "+Arrays.toString(generado));
    inicio = System.currentTimeMillis();
    mergeSort(generado2);
    fin = System.currentTimeMillis();
    System.out.println("MergeSort se tardo: "+(fin-inicio)+" milisegundos");

    // System.out.println("El arreglo ordenado con mergeSort es: "+Arrays.toString(generado2));

  }

}
