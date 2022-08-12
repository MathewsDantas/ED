package heap;

public class TestHeapNode {

    public static void main(String[] args) {
        HeapNode heap = new HeapNode(2);
        heap.insert(10);
        heap.insert(4);
        heap.insert(6);
        heap.insert(1);
        heap.insert(5);
        heap.insert(15);
        heap.printArvore();
        System.out.println("Retirado: "+heap.remove());
        heap.printArvore();
        System.out.println("Retirado: "+heap.remove());
        heap.printArvore();
        System.out.println("Retirado: "+heap.remove());
        heap.printArvore();
    }
}
