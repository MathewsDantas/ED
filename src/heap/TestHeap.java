package heap;

public class TestHeap {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(5);
        heap.insert(7);
        heap.insert(2);
        heap.insert(10);
        heap.insert(4);
        heap.insert(12);
        heap.insert(1);
        heap.print();
        System.out.println("Retirado: "+heap.remove());
        System.out.println("Retirado: "+heap.remove());
        heap.print();
    }
}
