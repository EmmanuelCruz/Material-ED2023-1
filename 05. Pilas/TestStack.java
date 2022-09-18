import java.util.EmptyStackException;

/**
 * Prueba de las operaciones de una pila
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Septiembre 2022.
 * @since Estructuras de datos 2023-1.
 */
public class TestStack {
  
  public static void main(String[] args) {
    TDAStack<String> stack = new Stack<>();

    try {
      System.out.println("El tope es "+stack.top());
    } catch (EmptyStackException e) {
      System.out.println("La pila esta vacia");
    }

    stack.push("Buho");
    stack.push("Pinguino");
    stack.push("Gato");
    stack.push("Oso");
    stack.push("Gallo");

    stack.show();

    System.out.println("El tope es "+stack.top());

    stack.pop();

    stack.show();

    stack.clear();

    System.err.println("La pila es vacia: "+stack.isEmpty());

  }
}
