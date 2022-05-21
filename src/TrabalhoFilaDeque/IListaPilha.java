package TrabalhoFilaDeque;

public interface IListaPilha {

    void push(Object o);
    Object pop() throws ListaVaziaException;
    Object top() throws ListaVaziaException;
    boolean isEmpty();
    int size();

}
