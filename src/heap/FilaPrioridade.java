package heap;

public class FilaPrioridade extends Heap{

    public FilaPrioridade(int capacidade) {
        super(capacidade);
    }

    public Object min(){
        return heap[1];
    }

    public Object removeMin(){
        return super.remove();
    }
}
