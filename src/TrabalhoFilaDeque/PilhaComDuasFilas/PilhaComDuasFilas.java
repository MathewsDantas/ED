package TrabalhoFilaDeque.PilhaComDuasFilas;

import TrabalhoFilaDeque.FilaLista.FilaLigada;
import TrabalhoFilaDeque.FilaLista.FilaVaziaException;
import TrabalhoFilaDeque.PilhaLista.IListaPilha;

public class PilhaComDuasFilas implements IListaPilha {
    FilaLigada filaPrincipal = new FilaLigada();
    FilaLigada filaSecundaria = new FilaLigada();

    @Override
    public void push(Object o) {
        filaPrincipal.enqueue(o);
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new FilaVaziaException("A Pilha está vazia!");
        }

        invertFila();
        Object aux = null;
        int tamanho = filaSecundaria.size();
        for (int i = 0; i < tamanho; i++){
            if ( i == (tamanho-1)){
                aux = filaSecundaria.dequeue();
            }
            else {
                filaPrincipal.enqueue(filaSecundaria.dequeue());
            }
        }
        return aux;
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            throw new FilaVaziaException("A Pilha está vazia!");
        }

        invertFila();
        Object top = filaSecundaria.first();
        int tamanho = filaSecundaria.size();
        for (int i = 0; i < tamanho; i++){
            if ( i == (tamanho-1)){
                top = filaSecundaria.first();
                filaPrincipal.enqueue(filaSecundaria.dequeue());
            }
            else {
                filaPrincipal.enqueue(filaSecundaria.dequeue());
            }

        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return filaPrincipal.isEmpty();
    }

    @Override
    public int size() {
        return filaPrincipal.size();
    }

    public void print(){

        invertFila();
        filaSecundaria.print();
        int tamanho = filaSecundaria.size();
        for (int i = 0; i < tamanho; i++){
                filaPrincipal.enqueue(filaSecundaria.dequeue());
        }

    }

    public void invertFila(){

        int tamanho = filaPrincipal.size();
        for (int i = 0; i < tamanho; i++){
            filaSecundaria.enqueue(filaPrincipal.dequeue());
        }

    }
}
