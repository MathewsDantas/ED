package TrabalhoPilha;

import pilha.PilhaVaziaException;

public interface IPilha {
    void v_push(Object o);

    void p_push(Object o);

    Object v_pop() throws pilha.PilhaVaziaException;

    Object p_pop() throws pilha.PilhaVaziaException;

    Object v_top() throws PilhaVaziaException;

    Object p_top() throws PilhaVaziaException;

    boolean isEmpty();

    boolean v_isEmpty();

    boolean p_isEmpty();

    int size();

    int v_size();

    int p_size();
}
