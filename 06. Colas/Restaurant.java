import java.util.Scanner;

/**
 * Representación del comporamiento de un restaurante
 * para asignar mesas a los comensales
 * @author Emmanuel Cruz Hernández.
 * @version Octubre de 2022
 * @since Estructuras de Datos 2023-1.
 */
public class Restaurant {
  
  /*
   * Cliente
   */
  public class Cliente {

    /** Identificador del cliente */
    public String name;

    /** Cantidad de comensales */
    public int cantidad;

    /**
     * Crear un nuevo cliente
     * @param id el identificador del cliente.
     * @param cantidad la cantidad de comensales totales del cliente
     */
    public Cliente(String id, int cantidad){
      name = id;
      this.cantidad = cantidad;
    }
  }

  /**
   * Mesa del restaurante
   */
  public class Table {

    /** Capacidad de la mesa */
    public int capacidad;

    /**
     * Crea una nueva mesa.
     * @param capacidad la capacidad de la mesa.
     */
    public Table(int capacidad) {
      this.capacidad = capacidad;
    }
  }

  /** Arreglo de mesas */
  public Table[] mesas;

  /** Fila de cliente */
  public TDAQueue<Cliente> clientes;

  /**
   * Crea un nuevo restaurante
   */
  public Restaurant(){
    Scanner sc = new Scanner(System.in);

    // Llenar la información de las mesas.
    System.err.print("¿Cuantas mesas quieres en el restaurante?: ");
    
    int cantidadMesas = sc.nextInt();
    mesas = new Table[cantidadMesas];
    for(int i = 0; i < cantidadMesas; i++){
      System.err.print("¿Cual es la capacidad de la mesa "+i+"?: ");
      int capacidadActual = sc.nextInt();
      mesas[i] = new Table(capacidadActual);
    }

    // Crear nuestros clientes para el restaurante
    System.err.print("Cuantos clientes quieres en el restaurante?: ");
    clientes = new Queue<>();

    int cantidadClientes = sc.nextInt();
    for(int j = 0; j < cantidadClientes; j++){
      System.err.print("¿Cual es la cantidad de comensales totales del cliente "+j+"?: ");
      int comensalActual = sc.nextInt();
      Cliente nuevoCliente = new Cliente(""+j, comensalActual);
      clientes.enqueue(nuevoCliente);
    }
  }

  /**
   * Atender a los clientes que esperan por el servicio.
   */
  public void atiendeClientes() {
    
    while(!clientes.isEmpty()){
      Cliente actual = clientes.dequeue();

      int minimo = 100;
      int mesaAsignada = -1;
      for(int i = 0; i < mesas.length; i++){
        // Cuando la cantidad de comensales es igual a la capacidad de la mesa
        if(actual.cantidad == mesas[i].capacidad){
          // System.out.println("El cliente "+actual.name+" fue atendido en la mesa "+i);
          mesaAsignada = i;
          break;
        }

        int diferencia = mesas[i].capacidad - actual.cantidad;
        if(diferencia > 0 && diferencia < minimo){
          minimo = diferencia;
          mesaAsignada = i;
        }
      }

      if(mesaAsignada == -1){
        System.out.println("El cliente "+actual.name+" no pudo ser atendido.");
      } else {
        System.out.println("El cliente "+actual.name+" fue atendido en la mesa "+mesaAsignada);
      }
    }
  }

  public static void main(String[] args) {
    Restaurant toks = new Restaurant();
    toks.atiendeClientes();
  }
}
