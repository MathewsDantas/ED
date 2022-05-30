package TADSequencia;


public class SequenciaArray implements ISequencia
{
    private Object[] sequence;
    private int capacity;
    private int header;
    private int trailer;

    public SequenciaArray(int capacity){
        this.capacity = capacity;
        this.sequence = new Object[capacity];
        this.header = 0;
        this.trailer = 0;
    }

    @Override
    public int size() {
        return trailer;
    }

    @Override
    public boolean isEmpty() {
        return trailer == 0;
    }

    @Override
    public Object first() throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return sequence[header];
    }

    @Override
    public Object last() throws SequenciaVaziaException {
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return sequence[trailer-1];
    }

    @Override
    public Object before(int p) throws SequenciaVaziaException {
        if (p < 0 || p >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return sequence[p-1];
    }

    @Override
    public Object after(int p) throws SequenciaVaziaException {
        if (p < 0 || p >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return sequence[p+1];
    }

    @Override
    public void replaceElement(int p, Object o) throws SequenciaVaziaException {
        if (p < 0 || p >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        sequence[p] = o;
    }

    @Override
    public void swapElements(int p1, int p2) throws SequenciaVaziaException {
        if (p1 < 0 || p1 >= trailer || p2 < 0 || p2 >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Object element1 = sequence[p1];
        sequence[p1] = sequence[p2];
        sequence[p2] = element1;
    }

    @Override
    public void insertBefore(int p, Object o) throws SequenciaVaziaException {
        if (p < 0 || p >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        if ( size() == capacity-1){
            capacity*=2;
            Object[] new_sequence = new Object[capacity];
            for (int i = 0; i < size(); i++){
                new_sequence[i] = sequence[i];
            }
            sequence = new_sequence;
        }
        for (int i = trailer; i >= p ; i--){
            sequence[i] = sequence[i-1];
        }
        sequence[p-1] = o;
        trailer++;
    }

    @Override
    public void insertAfter(int p, Object o) throws SequenciaVaziaException {
        if (p < 0 || p >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        if ( size() == capacity-1){
            capacity*=2;
            Object[] new_sequence = new Object[capacity];
            for (int i = 0; i < size(); i++){
                new_sequence[i] = sequence[i];
            }
            sequence = new_sequence;
        }
        for (int i = trailer; i > (p+1) ; i--){
            sequence[i] = sequence[i-1];
        }
        sequence[p+1] = o;
        trailer++;
    }

    @Override
    public void insertFirst(Object o) {
        if (size() == 0){
            sequence[header] = o;
        }
        else {
            if(size() >= capacity){
                capacity*=2;
                Object[] new_sequence = new Object[capacity];
                for (int i = 0; i < size(); i++){
                    new_sequence[i] = sequence[i];
                }
                sequence = new_sequence;
            }
            for (int i = size(); i > header; i--){
                sequence[i] = sequence[i - 1];
            }
            sequence[header] = o;
        }
        trailer++;
    }

    @Override
    public void insertLast(Object o) {
        if (size() == 0){
            sequence[header] = o;
        }
        else {
            if(size() >= capacity){
                capacity*=2;
                Object[] new_sequence = new Object[capacity];
                for (int i = 0; i < size(); i++){
                    new_sequence[i] = sequence[i];
                }
                sequence = new_sequence;
            }
            sequence[trailer] = o;
        }
        trailer++;
    }

    @Override
    public Object remove(int p) throws SequenciaVaziaException {
        if (p < 0 || p >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        for (int i = p; i < size()-1; i++){
            sequence[i] = sequence[i+1];
        }
        Object old_element = sequence[p];
        trailer--;
        return old_element;
    }

    @Override
    public Object elemAtRank(int rank) throws SequenciaVaziaException {
        if (rank < 0 || rank >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        return sequence[rank];
    }

    @Override
    public Object replaceAtRank(int rank, Object o) throws SequenciaVaziaException {
        if (rank < 0 || rank >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        Object old_element = sequence[rank];
        sequence[rank] = o;
        return old_element;
    }

    @Override
    public void insertAtRank(int rank, Object o) throws SequenciaVaziaException {
        if (rank < 0 || rank > trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        if (size() == capacity -1){
            capacity*=2;
            Object[] new_sequence = new Object[capacity];
            for (int i = 0; i < size(); i++) {
                new_sequence[i] = sequence[i];
            }
            sequence = new_sequence;
        }
        if (rank < trailer){
            for (int i = trailer; i > rank; i--){
                sequence[i] = sequence[i-1];
            }
        }
        sequence[rank] = o;
        trailer++;
    }

    @Override
    public Object removeAtRank(int rank) throws SequenciaVaziaException {
        if (rank < 0 || rank >= trailer){
            throw new SequenciaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new SequenciaVaziaException("Vazia");
        }
        for (int i = rank; i < (size()-1); i++){
            sequence[i] = sequence[i+1];
        }
        return null;
    }

    public void print(){
        System.out.println("----------------------------------------");
        for (int i = 0; i < size(); i++){
            System.out.println("Rank/Position: "+i+" Valor: "+sequence[i]);
        }
        System.out.println("----------------------------------------");
    }
}
