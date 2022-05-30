package TADVetor;

public class TestVetorLista {
    public static void main(String[] args) throws VetorVazioException {
        VetorLista vetor = new VetorLista();
        System.out.println("Tamanho: "+vetor.size());
        vetor.insertAtRank(0,5);
        vetor.insertAtRank(1,7);
        vetor.insertAtRank(0,9);
        vetor.insertAtRank(0,12);
        vetor.insertAtRank(0,2);
        System.out.println(vetor.elemAtRank(0));
        System.out.println(vetor.elemAtRank(1));
        System.out.println(vetor.elemAtRank(2));
        System.out.println(vetor.replaceAtRank(1,10));
        vetor.print();
        System.out.println("Deletado: "+vetor.removeAtRank(0));
        vetor.insertAtRank(1,3);
        vetor.print();
        System.out.println("Tamanho: "+vetor.size());
    }
}
