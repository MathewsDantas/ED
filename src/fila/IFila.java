package fila;

public interface IFila {
    void enqueue(Object o);
    Object dequeue();
    Object first();
    int size();
    boolean isEmpty();
    void print();
}
