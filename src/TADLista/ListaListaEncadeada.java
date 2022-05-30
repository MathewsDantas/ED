package TADLista;

import ListaDuplamente.Node;

public class ListaListaEncadeada implements  ILista{

    private int n;
    private Node header,trailer;

    ListaListaEncadeada(){
        this.n = 0;
        this.header = new Node(null,null,null);
        this.trailer = new Node(null,null,header);
        header.setNext(trailer);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public boolean isFirst(int p) throws ListaVaziaException {
        if (p > size() || p < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        return p == 0;
    }

    @Override
    public boolean isLast(int p) throws ListaVaziaException {
        if (p > size() || p < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        return p == (n - 1);
    }

    @Override
    public Object first() throws ListaVaziaException {
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        return header.getNext().getElement();
    }

    @Override
    public Object last() throws ListaVaziaException {
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        return trailer.getPrev().getElement();
    }

    @Override
    public Object before(int p) throws ListaVaziaException {
        if (p > size() || p < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        Node node = checkPosition(p);
        return node.getPrev();
    }

    @Override
    public Object after(int p) throws ListaVaziaException {
        if (p > size() || p < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        Node node = checkPosition(p);
        return node.getNext();
    }

    @Override
    public Object insertBefore(int p, Object o) throws ListaVaziaException {
        if (p > size() || p < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        Node node = checkPosition(p);
        Node new_node = new Node(o,node,node.getPrev());
        node.getPrev().setNext(new_node);
        node.setPrev(new_node);
        n++;
        return new_node.getElement();
    }

    @Override
    public Object insertAfter(int p, Object o) throws ListaVaziaException {
        if (p > size() || p < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        Node node = checkPosition(p);
        Node new_node = new Node(o,node.getNext(),node);
        node.getNext().setPrev(new_node);
        node.setNext(new_node);
        n++;
        return new_node.getElement();
    }

    @Override
    public Object insertFirst(Object o) {
        Node new_node = new Node(o,header.getNext(),header);
        header.getNext().setPrev(new_node);
        header.setNext(new_node);
        n++;
        return new_node.getElement();
    }

    @Override
    public Object insertLast(Object o) {
        Node new_node = new Node(o,trailer,trailer.getPrev());
        trailer.getPrev().setNext(new_node);
        trailer.setPrev(new_node);
        n++;
        return new_node.getElement();
    }

    @Override
    public Object remove(int p) throws ListaVaziaException {
        if (p > size() || p < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        Node old_node = checkPosition(p);
        Node old_prev = old_node.getPrev();
        Node old_next = old_node.getNext();
        old_prev.setNext(old_next);
        old_next.setPrev(old_prev);
        n--;

        old_node.setPrev(null);
        old_node.setNext(null);
        return old_node.getElement();
    }

    @Override
    public Object replaceElement(int p, Object o) throws ListaVaziaException {
        if (p > size() || p < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        Node node = checkPosition(p);
        Object old_element = node.getElement();
        node.setElement(o);
        return old_element;
    }

    @Override
    public void swapElements(int p1, int p2) throws ListaVaziaException {
        if (p1 > size() || p1 < 0 || p2 > size() || p2 < 0) {
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()){
            throw new ListaVaziaException("Vazia");
        }
        Node node1 = checkPosition(p1);
        Node node2 = checkPosition(p2);
        Object aux_element = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(aux_element);
    }

    private Node checkPosition(int p){
        Node node;
        if (p <= size()/2) {
            node = header.getNext();
            for (int i = 0; i < p; i++) {
                node = node.getNext();
            }
        }
        else{
            node = trailer.getPrev();
            for (int i = 0; i < size() - p-1; i++) {
                node = node.getPrev();
            }
        }
        return node;
    }

    public void print() {
        Node node = header.getNext();
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < n; i++){
            System.out.println("Posicao: " + i + " Valor: " + node.getElement());
            node = node.getNext();
        }
        System.out.println("-----------------------------------------------");
    }
}
