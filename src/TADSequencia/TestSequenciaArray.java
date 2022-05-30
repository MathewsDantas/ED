package TADSequencia;

public class TestSequenciaArray {
    public static void main(String[] args) throws SequenciaVaziaException {
        SequenciaArray sequence = new SequenciaArray(1);
        System.out.println("Tamanho: "+sequence.size());
        sequence.insertFirst(1);
        sequence.insertFirst(2);
        sequence.insertFirst(3);
        sequence.print();
        sequence.insertLast(10);
        sequence.insertLast(15);
        sequence.print();
        System.out.println("Retirado da position 3: "+sequence.remove(3));
        System.out.println("Retirado da position 0: "+sequence.remove(0));
        sequence.insertAfter(1,4);
        sequence.insertAfter(1,40);
        sequence.insertAfter(4,50);
        sequence.insertBefore(1,100);
        sequence.swapElements(1,4);
        sequence.print();
        // vetor
        /*System.out.println("Tamanho: "+sequence.size());
        sequence.insertAtRank(0,1);
        sequence.insertAtRank(0,2);
        sequence.insertAtRank(0,3);
        sequence.insertAtRank(0,4);
        sequence.insertAtRank(2,5);
        sequence.print();
        sequence.replaceAtRank(4,10);
        System.out.println("Elemento no rank 3 = "+sequence.elemAtRank(3));
        sequence.removeAtRank(1);
        sequence.print();*/

    }
}
