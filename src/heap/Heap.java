package heap;

public class Heap {

    protected Object[] heap;
    protected int capacidade;
    protected int n;

    public Heap(int capacidade) {
        this.heap = new Object[capacidade];
        this.capacidade = capacidade;
        this.n = 0;
    }

    public boolean isEmpty(){
        return this.n == 0;
    }

    public boolean isFolha(int index){
        return index > parent(n) && index <= n;
    }

    public int left(int index){
        return 2 * index;
    }

    public int right(int index){
        return (2 * index)+ 1;
    }

    public int height(){
        int i = 2,aux = 0;
        while (i <= n){
            i = i*2;
            aux++;
        }
        return aux;
    }

    public int parent(int index){
        return (index)/2;
    }

    public int size(){
        return n;
    }

    public void insert(int element){
        if(n >= (heap.length-1)){
            capacidade*= 2;
            Object[] new_heap = new Object[capacidade];
            for (int i=1; i <= n; i++){
                new_heap[i] = heap[i];
            }
            heap = new_heap;
        }

        n++;
        heap[n] = element;
        upHeap(n);
    }

    public Object remove(){
        if(isEmpty()) throw new RuntimeException("Empty");
        Object aux = heap[1];
        heap[1] = heap[n];
        n--;
        downHeap(1);

        return aux;
    }

// max - heap
    private void upHeap(int index){
        if(index == 1 || (int) heap[parent(index)] >= (int) heap[index] ){
            return;
        }
        Object aux = heap[index];
        heap[index] = heap[parent(index)];
        heap[parent(index)] = aux;
        upHeap(parent(index));
    }

    private void downHeap(int index){
        if(isFolha(index)){
            return;
        }
        if ((int)heap[index] < (int) heap[left(index)] || (int)heap[index] < (int) heap[right(index)])
        {
            Object aux = heap[index];
            if ((int)heap[left(index)] > (int)heap[right(index)]){
                heap[index] = heap[left(index)];
                heap[left(index)] = aux;
                downHeap(left(index));
            }
            else {
                heap[index] = heap[right(index)];
                heap[right(index)] = aux;
                downHeap(right(index));
            }
        }
    }

    public void print(){
        for (int i=1; i <= n; i++){
            System.out.print(heap[i]+ " ");
        }
        System.out.println();
    }

    public void print2(){
        for(int i=0;i<=height();i++){
            for(int j=0;j<Math.pow(2,i) && j+Math.pow(2,i)<=n;j++){ //qtd. de elementos por altura && indice de cada elemento.
                System.out.print(heap[j+(int)Math.pow(2,i)]+" ");

            }
            System.out.println();
        }
    }
}
