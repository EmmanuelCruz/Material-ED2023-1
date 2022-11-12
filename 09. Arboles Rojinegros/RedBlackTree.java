/**
* Implementación de un árbol rojinegro.
*
*
*/
public class RedBlackTree<K extends Comparable, T> extends BinarySearchTree<K,T> {
    /**
     * Nodo para árboles rojinegros.
     */
    private class RedBlackNode extends BinarySearchTree.BinaryNode{

        
        /** color del nodo, o es rojo  no es rojo. */
        public boolean red;
        
        /**
         * Crea un nuevo nodo para árboles rojinegros.
         * 
         * @param key    la llave del nodo.
         * @param e      el elemento a agregar.
         * @param parent el padre del nodo.
         */
        public RedBlackNode(K key, T e, RedBlackNode parent) {
            super(key, e, parent);
            red = true;
        }

        /**
         * Verifica si el color del nodo es rojo.
         * 
         * @return true si el nodo es rojo, false en otro caso.
         */
        public boolean isRed(){
            return red;
        }
        
        /**
         * Cambia el color del nodo.
         */
        public void setColor(){
            red = !red;
        }

        public void paintBlack(){
            if (isRed()) {
                setColor();
            }
        }
        
        public void paintRed(){
            if (!isRed()) {
                setColor();
            }
        }

    }

    /**
	 * Agrega un nuevo elemento al árbol.
	 * @param e el elemento a agregar.
	 * @param k la clave del elemento.
	 */
	public void insert(T e, K k){
        BinaryNode v = null;
        if(root == null){
            root = new RedBlackNode(k, e, null);
            v = root;
        } else {
            v = insertAux(root,k,e);
        }

        rebalancea(v);
    }

    private void rebalancea (RedBlackNode actual){
        // Caso 1
        // si el nodo no tiene padre el nodo sera negro. 
        if (actual.parent == null) {
            actual.setColor(); 
            return;
        }
        // Caso 2
        // si el nodo padre es negro, terminamos
        RedBlackNode p = (RedBlackNode) actual.parent;
        if(!p.isRed()){
            return;
        }

        // Caso 3
        RedBlackNode a = (RedBlackNode) p.parent;
        RedBlackNode t = (a.left == p) ? (RedBlackNode)a.rigth : (RedBlackNode)a.left;

        if(t.isRed() && p.isRed()){
            p.paintBlack();
            t.paintBlack();
            a.paintRed();
            rebalancea(a);
        }
        
        // Caso 4
        if((p == a.left && v == p.rigth) ||
            (p == a.rigth && v = p.left)){
                //rotamos
        } else {
            p.paintBlack();
            a.paintRed();
            // rotamos
        }

    }
}
