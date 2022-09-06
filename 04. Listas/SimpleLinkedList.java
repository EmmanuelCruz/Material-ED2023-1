import java.util.Iterator;

public class SimpleLinkedList<T> implements TDAList<T>{
    
    private class Nodo{
        /* Elemento a almacenar */
        public T elemento;

        /* Apuntador al nodo siguiente */
        public Nodo siguiente;

        /* Crea un nodo a partir de un elemento <i>elemento</i> de tipo <i>T</i> */
        public Nodo(T elemento){
            this.elemento = elemento;
        }
    }

    /**
     * Iterador de la lista simplemente ligada
     */
    private class IteradorListaSimple implements Iterator<T> {
        /**
         * 
         */

        private Nodo iteradorLista;
        
        public IteradorListaSimple() {
            
        }

        public boolean hasNext(){

        }

        public T next(){

        }
    }

    /** Nodo inicial de la lista */
    private Nodo cabeza;

    /** Cantidad de elementos en la lista */
    private int longitud;
    
    /**
     * Inserta un nuevo elemento <i>e</i> en la posicion <i>i</i>
     * 
     * @param i la posicion donde agregar el elemento
     * @param e el elemento que vamos a agregar
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango.
     */
    public void add(int i, T e) throws IndexOutOfBoundsException{
        if (i < 0 || i > longitud) {
            throw new IndexOutOfBoundsException("El indice no esta en el rango de 0 y el tamanio de la lista. ");
        }

        Nodo nuevo = new Nodo(e);

        // Caso para la lista vacia
        if (cabeza == null) {
            cabeza = nuevo;
            longitud++;
            return;
        }

        // Agregar en la posicion 0.
        if(i == 0){
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            longitud ++;
        }
        else if(i == longitud){
            // 
        }


    }

    /**
     * Elimina el elemento en la posicion <i>i</i>
     * 
     * @param i la posicion del elemento a eliminar
     * @return el elemento eliminado.
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango.
     */
    public T remove(int i) throws IndexOutOfBoundsException{

    }

    /**
     * Vacia la lista. Elimina todos los elementos.
     */
    public void clear(){
        cabeza = null;
    }

    /**
     * Obtiene el elemento en la posicion <i>i</i>
     * 
     * @param i el indice del elemento a obtener
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango.
     */
    public T get(int i) throws IndexOutOfBoundsException{

    }

    /**
     * Verifica si un elemento esta contenido en la lista
     * 
     * @param e el elemento a verificar si esta contenido
     * @return true si el elemento si eta contenido, false en otro caso.
     */
    public boolean contains(T e){

    }

    /**
     * Verifica si la lista esta vacia.
     * 
     * @return true si la lista no contiene elementos, false en otro caso.
     */
    public boolean isEmpty(){
        // return cabeza == null;
        return longitud == 0; 

    }

    /**
     * Regresa la cantidad de elementos contenidos en la lista.
     * 
     * @return la cantidad de elementos contenidos.
     */
    public int size(){
        // podemos recorrer toda la lista e ir contando cada elemento. Complejidad O(n) -- Lineal sobre el tamaño de la lista.
        return longitud; //podemos guardar un  contador de elementos en la lista. Y actualizarlo tras cada movimiento. Complejidad(1) Constante. 
        
        
    }



}
