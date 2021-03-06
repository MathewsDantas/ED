package heap;

public class TestFilaPrioridade {
    public static void main(String[] args) {
        FilaPrioridade fila = new FilaPrioridade(10);
        fila.insert(1);
        fila.insert(7);
        fila.insert(2);
        fila.insert(10);
        fila.insert(4);
        fila.insert(12);
        fila.insert(5);
        fila.insert(6);

        fila.print2();
        System.out.println("Altura: "+fila.height());
        System.out.println("Min: "+fila.min());
        System.out.println("Retirado: "+fila.removeMin());
        System.out.println("Retirado: "+fila.removeMin());
        fila.print2();
        System.out.println("Altura: "+fila.height());
        System.out.println("Min: "+fila.min());
    }
}
