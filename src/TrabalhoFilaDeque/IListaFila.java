package TrabalhoFilaDeque;

public interface IListaFila {

    void enqueue(Object o);
    Object dequeue();
    Object first();
    int size();
    boolean isEmpty();
    void print();

}
