package heap;

public class FilaPrioridadeNode extends HeapNode{

    public FilaPrioridadeNode(Object k) {
        super(k);
    }

    public Object min(){
        return super.getRaiz().getElemento();
    }

    public Object removeMin(){
        return super.remove();
    }
}
