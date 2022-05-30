package TADSequencia;

public class TestSequenciaLista {
    public static void main(String[] args) throws SequenciaVaziaException {
        
        SequenciaLista sequence = new SequenciaLista();
        /*System.out.println("Tamanho: "+sequence.size());
        sequence.insertAtRank(0,5);
        sequence.insertAtRank(0,7);
        sequence.insertAtRank(0,9); //  2 9 12 7 5
        sequence.insertAtRank(1,12);
        sequence.insertAtRank(0,2);
        System.out.println("Elemento no rank 0: "+sequence.elemAtRank(0));
        System.out.println("Elemento no rank 1: "+sequence.elemAtRank(1));
        System.out.println("Elemento no rank 2: "+sequence.elemAtRank(2));
        System.out.println(sequence.replaceAtRank(1,10));
        sequence.print();
        System.out.println("Deletado: "+sequence.removeAtRank(0));
        sequence.insertAtRank(1,3);
        sequence.print();
        System.out.println("Tamanho: "+sequence.size());*/
        //Lista
        sequence.insertFirst(1);
        sequence.insertFirst(2); // 2 5 1 10 4
        sequence.insertLast(4);
        sequence.insertBefore(2,10);
        sequence.insertAfter(0,5);
        sequence.print();
    }
}
