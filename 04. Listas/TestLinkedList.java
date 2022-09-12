/**
 * Clase con las pruebas de la implementación de una lista doblemente ligada
 */
public class TestLinkedList {
  
  public static void main(String[] args) {
    DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();

    // Insertamos en la primera posición
    lista.add(0, 6);
    lista.add(0, 5);
    lista.add(0, 4);
    lista.add(0, 3);
    lista.add(0, 2);
    lista.add(0, 1);
    lista.show();
    System.out.println("La longitud de la lista es "+lista.size());

    // Insertamos en la última posición
    lista.add(6, 7);
    lista.add(7, 8);
    lista.add(8, 9);

    try {
      lista.add(-45, -45);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    lista.add(2, 56);
    lista.show();

  }
}
