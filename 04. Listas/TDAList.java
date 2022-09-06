

public interface TDAList<T>{
    
    /**
     * Inserta un nuevo elemento <i>e</i> en la posicion <i>i</i>
     * 
     * @param i la posicion donde agregar el elemento
     * @param e el elemento que vamos a agregar
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango. 
     */
    public void add(int i, T e) throws IndexOutOfBoundsException;
    
    
    /**
     * Elimina el elemento en la posicion <i>i</i>
     * 
     * @param i la posicion del elemento a eliminar
     * @return el elemento eliminado. 
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango. 
     */
    public T remove(int i) throws IndexOutOfBoundsException;
    
    /**
     * Vacia la lista. Elimina todos los elementos. 
     */
    public void clear();

    /**
     * Obtiene el elemento en la posicion <i>i</i>
     * @param i el indice del elemento a obtener
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango.
     */
    public T get(int i) throws IndexOutOfBoundsException;

    /**
     * Verifica si un elemento esta contenido en la lista
     * 
     * @param e el elemento a verificar si esta contenido
     * @return true si el elemento si eta contenido, false en otro caso.
     */
    public boolean contains(T e);

    /**
     * Verifica si la lista esta vacia.
     * 
     * @return true si la lista no contiene elementos, false en otro caso.
     */
    public boolean isEmpty();

    /**
     * Regresa la cantidad de elementos contenidos en la lista.
     * 
     * @return la cantidad de elementos contenidos. 
     */
    public int size();

}