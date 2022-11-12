// import Files and Paths
import java.nio.file.Paths;
import java.util.Arrays;
import java.nio.file.Files;

public class test {

    public static void main(String[] args) {
        try {
            // lee el archivo de texto json.txt y lo guarda en un String
            String json = new String(Files.readAllBytes(Paths.get("json.txt")));
            // imprime el String
            String json_sincorchetes = json.substring(2, json.length()-1);
            //System.out.println(json_sincorchetes);

            // quitar saltos de linea
            String json_sin_saltos = json_sincorchetes.replaceAll("\\r\\n|\\r|\\n", "");

            // quitar comillas dobles
            String json_sin_comillas = json_sin_saltos.replaceAll("\"", "");

            // split by comma
            String[] objeto = json_sin_comillas.split("id:");
           

            System.out.println(objeto.length - 1 );
            // imprime el String
            for (int i = 1; i < objeto.length; i++) {
            //for (int i = 0; i < 2; i++) {
                System.out.println(objeto[i]);
                System.out.println("id: " + objeto[i].substring(0, objeto[i].indexOf(",")));

                int indiceNombre = objeto[i].indexOf("name:");
                System.out.println("name: " + objeto[i].substring(indiceNombre + 5, objeto[i].indexOf(",", indiceNombre)));
                System.out.println("#####");
            }



            System.out.println("titulo,autor,fecha");
            System.out.println("principito,desconocido,1800");
            System.out.println("Lore ,Alexandra Bracken,2020");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
}