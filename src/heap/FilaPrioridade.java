package heap;

public class FilaPrioridade extends Heap{

    public FilaPrioridade(int capacidade) {
        super(capacidade);
    }

    public Object min(){
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }
        Object aux = super.heap[1];
        for (int i=2; i<=super.n; i++){
            if ((int) super.heap[i] < (int) aux){
                aux = super.heap[i];
            }
        }
        return aux;
    }

//    public Object removeMin(){
//        if(isEmpty()){
//            throw new RuntimeException("Empty");
//        }
//        Object aux = min();
//        return aux;
//    }
}
