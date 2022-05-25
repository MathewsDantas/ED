package TrabalhoFilaDeque.FilaLista;

public interface IListaFila {

    void enqueue(Object o);
    Object dequeue() throws FilaVaziaException;
    Object first()throws FilaVaziaException;
    int size();
    boolean isEmpty();
    void print();

}
