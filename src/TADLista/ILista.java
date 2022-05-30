package TADLista;

public interface ILista {
    int size();
    boolean isEmpty();
    boolean isFirst(int p) throws ListaVaziaException;
    boolean isLast(int p) throws ListaVaziaException;
    Object first() throws ListaVaziaException;
    Object last() throws ListaVaziaException;
    Object before(int p) throws ListaVaziaException;
    Object after(int p) throws ListaVaziaException;
    Object insertBefore(int p,Object o) throws ListaVaziaException;
    Object insertAfter(int p,Object o) throws ListaVaziaException;
    Object insertFirst(Object o);
    Object insertLast(Object o);
    Object remove(int p) throws ListaVaziaException;
    Object replaceElement(int p, Object o) throws ListaVaziaException;
    void swapElements(int p1, int p2) throws ListaVaziaException;
}
