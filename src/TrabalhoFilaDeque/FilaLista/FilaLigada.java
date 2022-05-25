package TrabalhoFilaDeque.FilaLista;

import TrabalhoFilaDeque.No;

public class FilaLigada implements IListaFila{

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

    public FilaLigada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public void enqueue(Object o) {
        No elemento = new No();
        elemento.setValor(o);

        if(tamanho == 0) {
            primeiro = elemento;
            ultimo = elemento;
        }
        else {
            ultimo.setProximo(elemento);
            ultimo = elemento;
        }
        tamanho++;
    }

    @Override
    public Object dequeue() {
        No aux = primeiro;
        primeiro = aux.getProximo();
        tamanho--;
        return aux.getValor();
    }

    @Override
    public Object first() {
        return primeiro.getValor();
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return primeiro == null;
    }

    @Override
    public void print() {
        No elemento = primeiro;
        for (int i = 1; i <= tamanho; i++){
            System.out.println("Posicao: " + i + " Valor: " + elemento.getValor());
            elemento = elemento.getProximo();
        }
    }


}
