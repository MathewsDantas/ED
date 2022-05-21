package TrabalhoFilaDeque.FilaComDuasPilhas;

import TrabalhoFilaDeque.IListaFila;
import TrabalhoFilaDeque.ListaLigada;

public class FilaComDuasPilhas implements IListaFila {
    ListaLigada pilha = new ListaLigada();
    ListaLigada pilhaInvertida = new ListaLigada();

    @Override
    public void enqueue(Object o) {
        pilha.push(o);
    }

    @Override
    public Object dequeue() {
        pilhaInvertida = pilha.invertLista();
        Object aux = pilhaInvertida.pop();
        pilha = pilhaInvertida.invertLista();
        return aux;
    }

    @Override
    public Object first() {
        pilhaInvertida = pilha.invertLista();
        return pilhaInvertida.top();
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
        pilhaInvertida = pilha.invertLista();
        pilhaInvertida.print();
    }

}
