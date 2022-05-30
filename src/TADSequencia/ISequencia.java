package TADSequencia;

public interface ISequencia {
    int size();
    boolean isEmpty();
    Object first() throws SequenciaVaziaException;
    Object last() throws SequenciaVaziaException;
    Object before(int p) throws SequenciaVaziaException;
    Object after(int p) throws SequenciaVaziaException;
    void replaceElement(int p, Object o) throws SequenciaVaziaException;
    void swapElements(int p1, int p2) throws SequenciaVaziaException;
    void insertBefore(int p, Object o) throws SequenciaVaziaException;
    void insertAfter(int p, Object o) throws SequenciaVaziaException;
    void insertFirst(Object o) throws SequenciaVaziaException;
    void insertLast(Object o);
    Object remove(int p) throws SequenciaVaziaException;
    Object elemAtRank(int rank) throws SequenciaVaziaException;
    Object replaceAtRank(int rank, Object o) throws SequenciaVaziaException;
    void insertAtRank(int rank, Object o) throws SequenciaVaziaException;
    Object removeAtRank(int rank) throws SequenciaVaziaException;
}
