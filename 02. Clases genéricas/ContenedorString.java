/**
 * Representación de un objeto que me permite almacenar un String
 * @author Emmanuel Cruz Hernández.
 * @version 1.0
 */
public class ContenedorString {

  /** Entero que se almacena en el objeto */
  public String valor;

  /**
   * Contruye un nuevo contenedor
   * @param valor es el valor a almacenar en el contenedor
   */
  public ContenedorString(String valor){
    this.valor = valor;
  }

  /**
   * Modifica el valor del contenedor
   * @param nuevoValor el nuevo valor a almacenar
   */
  public void setValor(String nuevoValor){
    valor = nuevoValor;
  }

  /**
   * Obtiene el valor almacenado en el contenedor
   * @return el valor almacenado en el contenedor
   */
  public String getValor() {
    return valor;
  }

  public static void main(String[] args) {
    ContenedorString c1 = new ContenedorString("Cinco");

    System.out.println(c1.getValor());;
  }
}