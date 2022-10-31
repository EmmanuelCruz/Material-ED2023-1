/**
 * O pruebas de los métodos implementados para un árbol binario de búsqueda.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2022.
 * @since Laboratorio de Estructuras de Datos 2023-1.
 */

public class BinarySearchTreeTest {
  
  public static void main(String[] args) {
    TDABinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

    tree.insert("CINCUENTA", 50);
    tree.insert("OCHENTA", 80);
    tree.insert("TREINTA", 30);
    tree.insert("SESENTA", 60);
    tree.insert("CINCUENTA Y CINCO", 55);
    tree.insert("SESENTA Y CINCO", 65);
    tree.insert("VEINTICINCO", 25);
    tree.insert("TREINTA Y SEIS", 36);
    
    tree.preorden();

  }
}
