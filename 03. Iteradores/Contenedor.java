import java.util.Iterator;

/**
 * Contenedor que almacena un conjunto de elementos genericos.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0
 */
public class Contenedor<T> {

  /** Conjunto de elementos de tipo T */
  public T[] valores;

  /** Tope */
  public int tope;

  /**
   * Crea un nuevo contenedor
   * @param cantidad es la cantidad de elementos máximos para almacenar en el contenedor.
   */
  public Contenedor(int cantidad){
    valores = (T[]) new Object[cantidad];
    this.tope = 0;
  }

  /**
   * Permite agregar un elemento en la siguiente posición libre
   * @param t el elemento a almacenar en el arreglo.
   */
  public void addT(T t){
    // Verificar que el arreglo no este lleno
    if(tope >= valores.length){
      return;
    }

    // En caso de que el arreglo no este lleno
    valores[tope++] = t;
  }

  /**
   * Permite obtener el elemento en la posición n
   * @param n la posicion a obtener
   * @return el elemento en la posición n
   */
  public T getT(int n){

    for(int i = 0; i < tope ; i++){
      if(i == n)
        return valores[n];
    }
    return null;
  }

  /**
   * Regresa la cantidad de elementos dentro del contenedor
   * @return la cantidad de elementos.
   */
  public int getSize(){
    return tope;
  }

  /**
   * Crea un nuevo interador
   * @return un nuevo iterador
   */
  public Iterator<T> createIterator(){
    return new IteradorContenedor<T>(valores, tope);
  }

  /**
   * Iterador
   */
  public class IteradorContenedor<T> implements Iterator<T> {

    /** Conjunto de elementos de tipo T */
    public T[] valores;

    /** Tope */
    public int tope;

    /** Apuntador */
    public int apuntador;

    /**
     * Crea un nuevo iterador
     * @param arr el arreglo con los valores a recorrer
     * @param tope el tope de los elementos válidos por recorrer
     */
    public IteradorContenedor(T[] arr, int tope){
      valores = arr;
      this.tope = tope;
      this.apuntador = 0;
    }

    @Override
    public boolean hasNext(){
      if(apuntador >= tope)
        return false;
      return true;
    }

    @Override
    public T next(){
      return valores[apuntador++];
    }

  }

  public static void main(String[] args) {
    int cantidad = 100000;
    Contenedor<Integer> contenedor = new Contenedor<>(cantidad);

    for(int j = 0; j < cantidad; j++){
      contenedor.addT(j);
    }
    
    System.out.println("RECORRIDO CON FOR");
    long inicio = System.currentTimeMillis();
    for(int i = 0; i < contenedor.getSize() ; i++){ // n veces - dependiendo de la cantidad de elementos del contenedor
      // System.out.println(contenedor.getT(i)); // n veces
      contenedor.getT(i); // n veces
    } // -> O(n*n) complejidad cuadrática
    long fin = System.currentTimeMillis();

    System.out.println("El recorrido con un for se tardo "+(fin-inicio)+" milisegundos");


    // Poniendo a prueba el iterador
    Iterator<Integer> iterador = contenedor.createIterator();

    System.out.println("RECORRIDO CON ITERADOR");
    long inicio2 = System.currentTimeMillis();
    while(iterador.hasNext()){ // n veces
      // System.out.println(iterador.next()); // 1 vez
      iterador.next(); // 1 vez
    } // -> O(n) complejidad constante
    long fin2 = System.currentTimeMillis();

    System.out.println("El recorrido con un iterador se tardo "+(fin2-inicio2)+" milisegundos");

  }

}