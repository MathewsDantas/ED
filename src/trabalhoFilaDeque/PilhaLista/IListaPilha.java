package trabalhoFilaDeque.PilhaLista;

public interface IListaPilha {

    void push(Object o);
    Object pop() throws PilhaVaziaException;
    Object top() throws PilhaVaziaException;
    boolean isEmpty();
    int size();
}
