package TrabalhoFilaDeque.PilhaComDuasFilas;

import TrabalhoFilaDeque.FilaLista.FilaLigada;
import TrabalhoFilaDeque.FilaLista.FilaVaziaException;
import TrabalhoFilaDeque.PilhaLista.IListaPilha;

public class PilhaComDuasFilas implements IListaPilha {
    FilaLigada fila = new FilaLigada();
    FilaLigada filaInvertida = new FilaLigada();

    @Override
    public void push(Object o) {
        fila.enqueue(o);
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new FilaVaziaException("A Pilha está vazia!");
        }
        invertFila();
        Object aux = filaInvertida.dequeue();
        desinvertFila();
        return aux;
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            throw new FilaVaziaException("A Pilha está vazia!");
        }
        invertFila();
        Object top = filaInvertida.first();
        desinvertFila();
        return top;
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
        invertFila();
        filaInvertida.print();
        desinvertFila();
    }

    public void invertFila(){
        int tamanho = fila.size();
        for (int i = 0; i < tamanho; i++){
            filaInvertida.enqueue(fila.dequeue());
        }
    }

    public void desinvertFila(){
        int tamanho = filaInvertida.size();
        for (int i = 0; i < tamanho; i++){
            fila.enqueue(filaInvertida.dequeue());
        }
    }
}
