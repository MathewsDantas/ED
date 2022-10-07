package trabalhoFilaDeque.PilhaLista;

import trabalhoFilaDeque.No;

public class PilhaLigada implements IListaPilha{

    private No primeiro;
    private No ultimo;
    private int tamanho;

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public PilhaLigada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public void push(Object o) {
        No elemento = new No();
        elemento.setValor(o);
        if(tamanho == 0) {
            primeiro = elemento;
            ultimo = elemento;
        }
        else {
            elemento.setProximo(primeiro);
            primeiro = elemento;// o novo elemento sempre será o primeiro.
        }
        tamanho++;
    }

    @Override
    public Object pop() throws PilhaVaziaException {
        if (isEmpty()){
            throw new PilhaVaziaException("Vazia");
        }
        No aux = primeiro;
        primeiro = aux.getProximo();
        tamanho--;
        return aux.getValor();
    }

    @Override
    public Object top() throws PilhaVaziaException {
        if (isEmpty()){
            throw new PilhaVaziaException("Vazia");
        }
        return primeiro.getValor();
    }

    @Override
    public boolean isEmpty() {
        return primeiro == null;
    }

    @Override
    public int size() {
        return tamanho;
    }

    public void print() {
        No elemento = primeiro;
        for (int i = 1; i <= tamanho; i++){
            System.out.println("Posicao: " + i + " Valor: " + elemento.getValor());
            elemento = elemento.getProximo();
        }
    }
}
