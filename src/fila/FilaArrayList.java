package fila;

import java.util.ArrayList;

public class FilaArrayList implements IFila {

    private ArrayList<Object> fila = new ArrayList<Object>();

    public FilaArrayList() {
        super();
    }

    public void enqueue(Object o) {
        fila.add(o);
    }

    public Object dequeue() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A Fila está vazia!");
        } else {
            Object aux = fila.get(0);
            fila.remove(0);
            return aux;
        }

    }

    public Object first() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A Fila está vazia!");
        } else {
            return fila.get(0);
        }
    }

    public int size() {
        return fila.size();
    }


    public boolean isEmpty() {
        return fila.size()==0;
    }

    @Override
    public void print() {
        for (int i = 0; i <size() ; i++){
            System.out.println("indice: "+i+" = "+fila.get(i));
        }
    }

}
