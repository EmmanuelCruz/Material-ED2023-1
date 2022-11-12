/**
 * Implementación de un árbol binario de busqueda.
 * 
 * @author Emmanuel Cruz Hernández.
 * @version 2.0 Julio 2021.
 * @since Estructuras de Datos 2021-2.
 */
public class BinarySearchTree<K extends Comparable, T> implements TDABinarySearchTree<K, T> {

    /**
     * Nodo para un árbol binario de búsqueda.
     */
    public class BinaryNode {

        /** Clave. */
        public K key;

        /** Elemento. */
        public T element;

        /** Padre del nodo. */
        public BinaryNode parent;

        /** Hijo izquierdo. */
        public BinaryNode left;

        /** Hijo derecho. */
        public BinaryNode rigth;

        /**
         * Crea un nuevo nodo.
         * 
         * @param key     la clave.
         * @param element el elemento a almacenar.
         * @param parent  el padre del nodo.
         */
        public BinaryNode(K key, T element, BinaryNode parent) {
            this.key = key;
            this.element = element;
            this.parent = parent;
        }
    }

    /** Raiz del arbol. */
    public BinaryNode root;

    @Override
    public T retrieve(K k) {
        BinaryNode buscado = retrieveAux(root, k);
        if (buscado == null)
            return null;
        else
            return buscado.element;
    }

    private BinaryNode retrieveAux(BinaryNode actual, K k) {
        // Es cuando la clave k no se encuentra.
        if (actual == null)
            return null;

        // Cuando las claves son iguales
        if (actual.key.compareTo(k) == 0)
            return actual;

        if (k.compareTo(actual.key) < 0) { // Fue menor. Buscamos en el izquierdo.
            return retrieveAux(actual.left, k);
        } else { // Fue mayor. Entonces busca en el derecho.
            return retrieveAux(actual.rigth, k);
        }
    }

    @Override
    public void insert(T e, K k) {
        // Si el arbol es vacio.
        if (root == null) {
            root = new BinaryNode(k, e, null);
            return;
        }

        insertAux(root, k, e);
    }

    public BinaryNode insertAux(BinaryNode actual, K key, T e) {
        if (key.compareTo(actual.key) < 0) { // La clave es menor.
            if (actual.left == null) {
                BinaryNode agregado = new BinaryNode(key, e, actual);
                actual.left = agregado;
                return agregado;
            } else {
                insertAux(actual.left, key, e);
            }
        } else { // La clave es mayor.
            if (actual.rigth == null) {
                BinaryNode agregado = new BinaryNode(key, e, actual);
                actual.rigth = agregado;
                return agregado;
            } else {
                insertAux(actual.rigth, key, e);
            }
        }
    }

    @Override
    public T delete(K k) {
        // Obtenemos el nodo que queremos eliminar.
        BinaryNode eliminado = retrieveAux(root, k);

        // Ver si está en el árbol
        if (eliminado == null)
            return null;

        BinaryNode padre = eliminado.parent;

        // Caso 1: si tiene 0 hijos -> Es una hoja
        if (eliminado.rigth == null && eliminado.left == null) {
            // Verificar si eliminado es hijo izquierdo o derecho.
            if (padre.left == eliminado)
                padre.left = null;
            else
                padre.rigth = null;

            return eliminado.element;
        }

        // Caso 2: si tiene 2 hijos
        T regreso = eliminado.element;
        if (eliminado.rigth != null && eliminado.left != null) {
            BinaryNode max = findMax(eliminado.left);
            delete(max.key);
            eliminado.key = max.key;
            eliminado.element = max.element;

            return regreso;
        }

        // Caso 3: si tiene un sólo hijo (izquierdo o derecho)
        boolean izquierdo = padre.left == eliminado;

        if (eliminado.rigth != null) { // Subir el derecho
            eliminado = eliminado.rigth;
        } else { // Subir el izquierdo
            eliminado = eliminado.left;
        }

        eliminado.parent = padre;

        if (izquierdo)
            padre.left = eliminado;
        else
            padre.rigth = eliminado;

        return regreso;
    }

    @Override
    public T findMin() {
        // Tarea moral.
        return null;
    }

    @Override
    public T findMax() {
        BinaryNode max = findMax(root);
        if (max == null)
            return null;
        return max.element;
    }

    /**
     * Encuentra el nodo con clave máxima a partir de un nodo actual.
     * 
     * @param actual el nodo actual.
     * @param el     nodo con clave mayor a partir del actual.
     */
    private BinaryNode findMax(BinaryNode actual) {
        if (actual == null)
            return null;

        BinaryNode max = actual;

        while (max.rigth != null)
            max = max.rigth;

        return max;
    }

    @Override
    public void preorden() {
        preordenAux(root);
    }

    private void preordenAux(BinaryNode actual) {
        if (actual == null)
            return;

        // Visitar la raíz
        System.out.println(actual.element);

        // Preorden sobre el hijo izquierdo
        preordenAux(actual.left);
        // Peorden sobre el hijo derecho
        preordenAux(actual.rigth);

    }

    @Override
    public void inorden() {
        // Moral
    }

    @Override
    public void postorden() {
        // Moral
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> arbol = new BinarySearchTree<>();

        arbol.insert("A", 15);
        arbol.insert("B", 8);
        arbol.insert("Z", 20);
        arbol.insert("J", 3);
        arbol.insert("E", 14);
        arbol.insert("H", 26);

        arbol.delete(20);

        arbol.preorden();
    }
}