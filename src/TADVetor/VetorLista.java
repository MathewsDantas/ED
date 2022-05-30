package TADVetor;

import ListaDuplamente.Node;

public class VetorLista implements IVetor{

    private Node header;
    private Node trailer;
    private int n;

    public VetorLista(){
        n = 0;
        header = new Node(null,null,null);
        trailer = new Node(null,null,header);
        header.setNext(trailer);
    }

    @Override
    public Object elemAtRank(Integer r) throws VetorVazioException {
        if (r < 0 || r > (n-1)){
            throw new VetorVazioException("Fora do limite");
        }
        if (isEmpty()) {
            throw new VetorVazioException("Vazio");
        }
        Node node = nodeAtRank(r);
        return node.getElement();
    }

    @Override
    public Object replaceAtRank(Integer r, Object o) throws VetorVazioException {
        if (r < 0 || r > (n-1)){
            throw new VetorVazioException("Fora do limite");
        }
        if (isEmpty()) {
            throw new VetorVazioException("Vazio");
        }
        Node node = nodeAtRank(r);
        Object old_element = node.getElement();
        node.setElement(o);
        return old_element;
    }

    @Override
    public void insertAtRank(Integer r, Object o) throws VetorVazioException {
        if (r < 0 || r > size()){
            throw new VetorVazioException("Fora do limite");
        }
        if (r == n && n!=0){
            Node prev = nodeAtRank(r);
            Node next = trailer;
            Node new_node = new Node(o, next, prev);
            next.setPrev(new_node);
            prev.setNext(new_node);
        }
        else {
            Node next = nodeAtRank(r);
            Node prev = next.getPrev();
            Node new_node = new Node(o, next, prev);
            next.setPrev(new_node);
            prev.setNext(new_node);
        }
        n++;
    }

    @Override
    public Object removeAtRank(Integer r) throws VetorVazioException {
        if (r < 0 || r > (n-1)){
            throw new VetorVazioException("Fora do limite");
        }
        if (isEmpty()) {
            throw new VetorVazioException("Vazio");
        }
        Node node_delete = nodeAtRank(r);
        Node next = node_delete.getNext();
        Node prev = node_delete.getPrev();
        prev.setNext(next);
        next.setPrev(prev);
        n--;
        return node_delete.getElement();
    }

    public int size(){
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private Node nodeAtRank(int r){
        Node node;
        if (r <= size()/2) {
            node = header.getNext();
            for (int i = 0; i < r; i++) {
                node = node.getNext();
            }
        }
        else{
            node = trailer.getPrev();
            for (int i = 0; i < size() - r-1; i++) {
                node = node.getPrev();
            }
        }
        return node;
    }

    public void print() {
        Node node = header.getNext();
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < n; i++){
            System.out.println("Rank: " + i + " Valor: " + node.getElement());
            node = node.getNext();
        }
        System.out.println("-----------------------------------------------");
    }
}
