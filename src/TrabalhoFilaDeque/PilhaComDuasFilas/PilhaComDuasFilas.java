package TrabalhoFilaDeque.PilhaComDuasFilas;

import TrabalhoFilaDeque.IListaPilha;
import TrabalhoFilaDeque.ListaLigada;


public class PilhaComDuasFilas implements IListaPilha {
    ListaLigada fila = new ListaLigada();
    ListaLigada filaInvertida = new ListaLigada();

    @Override
    public void push(Object o) {
        fila.enqueue(o);
    }

    @Override
    public Object pop() {
        filaInvertida = fila.invertLista();
        Object aux = filaInvertida.dequeue();
        fila = filaInvertida.invertLista();
        return aux;
    }

    @Override
    public Object top() {
        filaInvertida = fila.invertLista();
        return filaInvertida.first();
    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    @Override
    public int size() {
        return fila.size();
    }

    public void print(){
        filaInvertida = fila.invertLista();
        filaInvertida.print();
    }
}
