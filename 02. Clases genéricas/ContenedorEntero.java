/**
 * Representación de un objeto que me permite almacenar un entero
 * @author Emmanuel Cruz Hernández.
 * @version 1.0
 */
public class ContenedorEntero {

  /** Entero que se almacena en el objeto */
  public int valor;

  /**
   * Contruye un nuevo contenedor
   * @param valor es el valor a almacenar en el contenedor
   */
  public ContenedorEntero(int valor){
    this.valor = valor;
  }

  /**
   * Modifica el valor del contenedor
   * @param nuevoValor el nuevo valor a almacenar
   */
  public void setValor(int nuevoValor){
    valor = nuevoValor;
  }

  /**
   * Obtiene el valor almacenado en el contenedor
   * @return el valor almacenado en el contenedor
   */
  public int getValor() {
    return valor;
  }

  public static void main(String[] args) {
    ContenedorEntero c1 = new ContenedorEntero(5);

    System.out.println(c1.getValor());;
  }
}