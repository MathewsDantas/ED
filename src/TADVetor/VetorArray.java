package TADVetor;

public class VetorArray implements IVetor{
    private int n;
    private Object[] vetor;
    private int capacity;

    VetorArray(int capacity){
        this.capacity = capacity;
        this.n = 0;
        this.vetor = new Object[capacity];
    }

    @Override
    public Object elemAtRank(Integer rank) throws VetorVazioException {
        if (rank < 0 || rank > (capacity-1)){
            throw new VetorVazioException("Fora do limite");
        }
        if (isEmpty()) {
            throw new VetorVazioException("Vazio");
        }
        return vetor[rank];
    }

    @Override
    public Object replaceAtRank(Integer rank, Object o) throws VetorVazioException {
        if (rank < 0 || rank > (capacity-1)){
            throw new VetorVazioException("Fora do limite");
        }
        if (isEmpty()) {
            throw new VetorVazioException("Vazio");
        }
        Object old_element = vetor[rank];
        vetor[rank] = o;
        return old_element;
    }

    @Override
    public void insertAtRank(Integer rank, Object o) throws VetorVazioException {
        if (rank < 0 || rank > capacity){
            throw new VetorVazioException("Fora do limite");
        }
        if (size() >= capacity -1){
            capacity*=2;
            Object[] new_vetor = new Object[capacity];
            for (int i = 0; i < size(); i++) {
                new_vetor[i] = vetor[i];
            }
            vetor = new_vetor;
        }
        if (rank < size()){
            for (int i = size(); i > rank; i--){
                vetor[i] = vetor[i - 1];
            }
        }
        vetor[rank] = o;
        n++;
    }

    @Override
    public Object removeAtRank(Integer rank) throws VetorVazioException {
        if (rank < 0 || rank > (capacity-1)){
            throw new VetorVazioException("Fora do limite");
        }
        if (isEmpty()) {
            throw new VetorVazioException("Vazio");
        }
        Object element = vetor[rank];
        for (int i = rank; i < (size()-1); i++){
            vetor[i] = vetor[i+1];
        }
        n--;
        return element;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void print(){
        System.out.println("----------------------------------------");
        for (int i = 0; i < size(); i++){
            System.out.println("Rank: "+i+" Valor: "+vetor[i]);
        }
        System.out.println("----------------------------------------");
    }
}
