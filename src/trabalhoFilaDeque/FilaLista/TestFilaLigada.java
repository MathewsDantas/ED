package trabalhoFilaDeque.FilaLista;

public class TestFilaLigada {
    public static void main(String[] args) {
        FilaLigada fila = new FilaLigada();
        fila.enqueue(1);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(40);
        fila.print();
        System.out.println("Primeiro da fila: "+fila.first());
        System.out.println("Tamanho da fila: "+fila.size());
        System.out.println("Dequeue: "+fila.dequeue());
        fila.print();
        System.out.println("Dequeue: "+fila.dequeue());
    }
}
