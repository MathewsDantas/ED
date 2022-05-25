package fila;

public class TestFilaArrayList {

    public static void main(String[] args) {
        FilaArrayList fila = new FilaArrayList();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);
        fila.print();
    }
}
