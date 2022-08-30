/**
 * Representación de un objeto que me permite almacenar un objeto genérico
 * @author Emmanuel Cruz Hernández.
 * @version 1.0
 */
public class ContenedorGenerico<T, U> {

  /** Entero que se almacena en el objeto */
  public T valor;

  /** Segundo valor del contenedor genérico */
  public U valor2;

  /**
   * Contruye un nuevo contenedor
   * @param valor es el valor a almacenar en el contenedor
   */
  public ContenedorGenerico(T valor, U valor2){
    this.valor = valor;
    this.valor2 = valor2;
  }

  /**
   * Modifica el valor del contenedor
   * @param nuevoValor el nuevo valor a almacenar
   */
  public void setValor(T nuevoValor){
    valor = nuevoValor;
  }

  /**
   * Obtiene el valor almacenado en el contenedor
   * @return el valor almacenado en el contenedor
   */
  public T getValor() {
    return valor;
  }

  /**
   * Obtiene el valor almacenado en el contenedor
   * @return el valor almacenado en el contenedor
   */
  public U getValor2() {
    return valor2;
  }

  public static void main(String[] args) {
    ContenedorGenerico<Integer, Integer> c1 = new ContenedorGenerico<Integer, Integer>(5, 10);
    ContenedorGenerico<String, String> c2 = new ContenedorGenerico<>("Hola", "mundo");
    ContenedorGenerico<Boolean, Double> c3 = new ContenedorGenerico<>(true, 4.8);
    ContenedorGenerico<Double, Double> c4 = new ContenedorGenerico<Double, Double>(4.5, 7.5);
    ContenedorGenerico<Integer, Boolean> c5 = new ContenedorGenerico<>(10, false);

    // System.out.println(c1.getValor());
    // System.out.println(c2.getValor());
    // System.out.println(c3.getValor());
    // System.out.println(c4.getValor());
    // System.out.println(c5.getValor());

    System.out.println(c1.getValor() + c5.getValor());
    System.out.println(c1.getValor() + c1.getValor2());
    System.out.println(c5.getValor() + c1.getValor2());

    System.out.println(!c3.getValor());
  }
}