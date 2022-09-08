import java.util.List;

public class pruebaListaSimple {
    public static void main(String[] args) {
        SimpleLinkedList<String> lista = new SimpleLinkedList<>();

        lista.add(0, "a");
        //System.out.println(lista.size());
        lista.add(1, "b");
        //System.out.println(lista.size());
        lista.add(2, "d");
        //System.out.println(lista.size());
        lista.add(2,"c");
        //System.out.println(lista.size());
        lista.add(0,"!");
        
        
        //System.out.println(lista.size());
        lista.remove(0);
        //System.out.println(lista.size());
        lista.remove(2);
        
        //System.out.println(lista.isEmpty());
        //lista.clear();
        //System.out.println(lista.size());
        //System.out.println(lista.isEmpty());


        System.out.println(lista.contains("b"));
        System.out.println(lista.contains("d"));

        System.out.println(lista);
    }
}
