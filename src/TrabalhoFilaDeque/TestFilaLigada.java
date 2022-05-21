package TrabalhoFilaDeque;

public class TestFilaLigada {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.enqueue(1);
        lista.enqueue(3);
        lista.enqueue(4);
        lista.enqueue(40);
        lista.print();
        System.out.println("Primeiro da fila: "+lista.first());
        System.out.println("Tamanho da fila: "+lista.size());
        System.out.println("Dequeue: "+lista.dequeue());
        lista.print();
        System.out.println("Dequeue: "+lista.dequeue());
    }
}
