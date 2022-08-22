/**
 * Clase de ejemplos de complejidad en espacio
 * @author Emmanuel Cruz Hernández
 * @since Laboratorio de Estructuras de Datos 2023-1.
 */
public class Arreglo {

  /**
   * Devuelve un arreglo de longitud n, con cada indice correspondiente a su valor en cada entrada
   * @param n la longitud del arreglo
   * @return un arreglo con los indices en cada posición
   */
  public static int[] generaArreglo(int n){
    int[] resultado = new int[n];
    for(int i = 0; i < n; i++){
      resultado[i] = i+1;
    }
    return resultado;
  }

  /**
   * Determina si contiene elementos repetidos
   * @param arr el arreglo a determinar si contiene repetidos
   * @return true en caso de haber repetidos, false, en otro caso
   */
  public static boolean containsRepited(int[] nums){
    for(int i = 0; i < nums.length; i++){ // n veces donde n es la longitud del arreglo
      int numActual = nums[i];
      int counter = 0;
      for(int j = 0; j < nums.length; j++){ // n veces
        if(numActual == nums[j]){
          // Si son iguales
          counter++;
        }
      }
      if(counter >= 2){
        return true;
      }
    }
    return false;
  } // O(n*n)

  /**
   * Determina si contiene elementos repetidos
   * @param arr el arreglo a determinar si contiene repetidos
   * @return true en caso de haber repetidos, false, en otro caso
   */
  public static boolean containsRepited2(int[] nums){
    // Encontrar el mayor elemento dentro del arreglo
    int mayor = -1;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] > mayor){
        mayor = nums[i];
      }
    } // recorrimos n posiciones

    // recorrimos m posiciones
    int[] contadores = new int[mayor];

    // Aumentamos los cotadores respecto a la cantidad de apariciones
    for(int j = 0; j < nums.length ; j++){
      contadores[nums[j]-1]++;

      if(contadores[nums[j]-1] == 2){
        return true;
      }
    } // n veces
    return false;
  } // n + m + n = 2n + m => O(n)

  public static void main(String[] args) {
  
    int[] arr = generaArreglo(10000);

    long inicio2 = System.currentTimeMillis(); // Determinando el incio de tiempo
    containsRepited2(arr);
    long fin2 = System.currentTimeMillis(); // Determinando el fin de tiempo

    System.out.println("El segundo algoritmo se tardo "+(fin2-inicio2)+" milisegundos");

    long inicio = System.currentTimeMillis(); // Determinando el incio de tiempo
    containsRepited(arr);
    long fin = System.currentTimeMillis(); // Determinando el fin de tiempo

    System.out.println("El primer algoritmo se tardo "+(fin-inicio)+" milisegundos");

    
  }
}