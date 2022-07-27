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
        fila.print();
        System.out.println("Altura: "+fila.height());
        System.out.println("Min: "+fila.min());
        System.out.println("Retirado: "+fila.remove());
        System.out.println("Retirado: "+fila.remove());
        fila.print();
        System.out.println("Remove min: "+fila.removeMin());
        fila.print();
        System.out.println("Altura: "+fila.height());
    }
}
