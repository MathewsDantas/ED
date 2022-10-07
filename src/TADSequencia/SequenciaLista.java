package TADSequencia;

import listaDuplamente.Node;

public class SequenciaLista implements ISequencia{

    private Node header;
    private Node trailer;
    private int n;

    public SequenciaLista(){
        this.header = new Node(null,null,null);
        this.trailer = new Node(null,null,header);
        this.n = 0;
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
    public Object first() throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return header;
    }

    @Override
    public Object last() throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return trailer;
    }

    @Override
    public Object before(int p) throws SequenciaVaziaException {
        if (p < 0 || p > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return atRank(p-1);
    }

    public Object before2(Node no) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node no2 = header.getNext();
        while(no2 != no && no2 != trailer) {
            no2 = no2.getNext();
        }
        return no2.getPrev().getElement();
    }

    @Override
    public Object after(int p) throws SequenciaVaziaException {
        if (p < 0 || p > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return atRank(p+1);
    }

    public Object after2(Node no) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node no2 = header.getNext();
        while(no2 != no && no2 != trailer) {
            no2 = no2.getNext();
        }
        return no2.getNext().getElement();
    }

    @Override
    public void replaceElement(int p, Object o) throws SequenciaVaziaException {
        if (p < 0 || p > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node node = atRank(p);
        node.setElement(o);
    }

    public void replaceElement2(Node no, Object o) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node no2 = header.getNext();
        while(no2 != no && no2 != trailer) {
            no2 = no2.getNext();
        }
        no.setElement(o);
    }

    @Override
    public void swapElements(int p1, int p2) throws SequenciaVaziaException {
        if (p1 < 0 || p1 > n || p2 < 0 || p2 > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node node1 = atRank(p1);
        Node node2 = atRank(p2);
        Object aux = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(aux);
    }

    public void swapElements2(Node noA, Node noB) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Object aux = noA.getElement();
        noA.setElement(noB.getElement());
        noB.setElement(aux);
    }

    @Override
    public void insertBefore(int p, Object o) throws SequenciaVaziaException {
        if (p < 0 || p > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node node = atRank(p);
        Node new_node = new Node(o,node,node.getPrev());
        node.getPrev().setNext(new_node);
        node.setPrev(new_node);
        n++;
    }

    public void insertBefore2(Node no, Object o) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node no2 = header.getNext();
        while(no2 != no && no2 != trailer) {
            no2 = no2.getNext();
        }
        no.getPrev().setElement(o);
    }


    @Override
    public void insertAfter(int p, Object o) throws SequenciaVaziaException {
        if (p < 0 || p > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node node = atRank(p);
        Node new_node = new Node(o,node.getNext(),node);
        node.getNext().setPrev(new_node);
        node.setNext(new_node);
        n++;
    }

    public void insertAfter2(Node no, Object o) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node no2 = header.getNext();
        while(no2 != no && no2 != trailer) {
            no2 = no2.getNext();
        }
        no.getNext().setElement(o);
    }

    @Override
    public void insertFirst(Object o) throws SequenciaVaziaException {
        Node new_node = new Node(o,header.getNext(),header);
        header.getNext().setPrev(new_node);
        header.setNext(new_node);
        n++;
    }

    @Override
    public void insertLast(Object o) {
        Node new_node = new Node(o,trailer,trailer.getPrev());
        trailer.getPrev().setNext(new_node);
        trailer.setPrev(new_node);
        n++;
    }

    @Override
    public Object remove(int p) throws SequenciaVaziaException {
        if (p < 0 || p > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node node_delete = atRank(p);
        Node next = node_delete.getNext();
        Node prev = node_delete.getPrev();
        prev.setNext(next);
        next.setPrev(prev);
        n--;
        return node_delete.getElement();
    }

    public Object remove2(Node no) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Node no2 = header.getNext();
        while(no2 != no && no2 != trailer) {
            no2 = no2.getNext();
        }
        no.getNext().setPrev(no.getPrev());
        no.getPrev().setNext(no.getNext());
        return no.getElement();
    }

    @Override
    public Object elemAtRank(int rank) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        if (rank < 0 || rank > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        return atRank(rank).getElement();
    }

    @Override
    public Object replaceAtRank(int rank, Object o) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        if (rank < 0 || rank > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        Node node = atRank(rank);
        Object old_element = node.getElement();
        node.setElement(o);
        return old_element;
    }

    @Override
    public void insertAtRank(int rank, Object o) throws SequenciaVaziaException {
        if (rank < 0 || rank > size()){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (rank == n && n!=0){ // caso rank for o último.
            Node prev = atRank(rank);
            Node next = trailer;
            Node new_node = new Node(o, next, prev);
            next.setPrev(new_node);
            prev.setNext(new_node);
        }
        else {
            Node next = atRank(rank);
            Node prev = next.getPrev();
            Node new_node = new Node(o, next, prev);
            next.setPrev(new_node);
            prev.setNext(new_node);
        }
        n++;
    }

    @Override
    public Object removeAtRank(int rank) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        if (rank < 0 || rank > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        Node node_delete = atRank(rank);
        Node next = node_delete.getNext();
        Node prev = node_delete.getPrev();
        prev.setNext(next);
        next.setPrev(prev);
        n--;
        return node_delete.getElement();
    }

    public Node atRank(int rank) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        if (rank < 0 || rank > n){
            throw new SequenciaVaziaException("Fora do limite");
        }
        Node node;
        if (rank <= size()/2) {
            node = header.getNext();
            for(int i=0; i < rank; i++)
                node = node.getNext();
        }
        else{
            node = trailer.getPrev();
            for(int i=0; i < size()-rank-1 ; i++)
                node = node.getPrev();
        }
        return node;
    }

    public int rankOf(Node no) throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }

        Node no2 = header.getNext();
        int r = 0;
        while(no2 != no && no2 != trailer) {
            no2 = no2.getNext();
            r++;
        }
        return r;
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
