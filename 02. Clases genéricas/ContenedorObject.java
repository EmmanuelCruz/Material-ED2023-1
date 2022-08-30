/**
 * Representación de un objeto que me permite almacenar un elemento de tipo Object
 * @author Emmanuel Cruz Hernández.
 * @version 1.0
 */
public class ContenedorObject {

  /** Entero que se almacena en el objeto */
  public Object valor;

  /**
   * Contruye un nuevo contenedor
   * @param valor es el valor a almacenar en el contenedor
   */
  public ContenedorObject(Object valor){
    this.valor = valor;
  }

  /**
   * Modifica el valor del contenedor
   * @param nuevoValor el nuevo valor a almacenar
   */
  public void setValor(Object nuevoValor){
    valor = nuevoValor;
  }

  /**
   * Obtiene el valor almacenado en el contenedor
   * @return el valor almacenado en el contenedor
   */
  public Object getValor() {
    return valor;
  }

  public static void main(String[] args) {
    ContenedorObject c1 = new ContenedorObject(5);
    ContenedorObject c2 = new ContenedorObject("Hola");
    ContenedorObject c3 = new ContenedorObject(true);
    ContenedorObject c4 = new ContenedorObject(4.5);
    ContenedorObject c5 = new ContenedorObject(10);

    // System.out.println(c1.getValor());
    // System.out.println(c2.getValor());
    // System.out.println(c3.getValor());
    // System.out.println(c4.getValor());
    int valor1 = (Integer) c1.getValor(); // Cast - La conversión de un tipo de datos a otro
    int valor5 = (Integer) c5.getValor(); // NOTA - Sólo en caso de ser posible
    int valor2 = (Integer) c2.getValor(); // NOTA - Sólo en caso de ser posible
    System.out.println(valor1 + valor5);
  }
}