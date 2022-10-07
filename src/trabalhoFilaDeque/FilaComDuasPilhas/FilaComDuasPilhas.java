package trabalhoFilaDeque.FilaComDuasPilhas;

import trabalhoFilaDeque.FilaLista.IListaFila;
import trabalhoFilaDeque.PilhaLista.PilhaLigada;
import trabalhoFilaDeque.PilhaLista.PilhaVaziaException;

public class FilaComDuasPilhas implements IListaFila{
    PilhaLigada pilha = new PilhaLigada();
    PilhaLigada pilhaInvertida = new PilhaLigada();

    @Override
    public void enqueue(Object o) {
        pilha.push(o);
    }

    @Override
    public Object dequeue() {
        if (pilha.isEmpty()) {
            throw new PilhaVaziaException("A Fila está vazia!");
        }
        else {
            invertPilha();
            Object aux = pilhaInvertida.pop();
            desinvertPilha();
            return aux;
        }
    }

    @Override
    public Object first() {
        if (pilha.isEmpty()) {
            throw new PilhaVaziaException("A Fila está vazia!");
        }
        invertPilha();
        Object top = pilhaInvertida.top();
        desinvertPilha();
        return top;
    }

    @Override
    public int size() {
        return pilha.size();
    }

    @Override
    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    @Override
    public void print(){
        invertPilha();
        pilhaInvertida.print();
        desinvertPilha();
    }

    public void invertPilha(){
        int tamanho = pilha.size();
        for (int i = 0; i < tamanho; i++){
            pilhaInvertida.push(pilha.pop());
        }
    }

    public void desinvertPilha(){
        int tamanho = pilhaInvertida.size();
        for (int i = 0; i < tamanho; i++){
            pilha.push(pilhaInvertida.pop());
        }
    }

}
