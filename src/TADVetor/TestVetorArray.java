package TADVetor;

public class TestVetorArray {
    public static void main(String[] args) throws VetorVazioException {
        VetorArray vetor = new VetorArray(1);
        System.out.println("Tamanho: "+vetor.size());
        vetor.insertAtRank(0,1);
        vetor.insertAtRank(0,2);
        vetor.insertAtRank(0,3);
        vetor.insertAtRank(0,4);
        vetor.insertAtRank(2,5);
        vetor.print();
        vetor.replaceAtRank(4,10);
        System.out.println("Elemento no rank 3 = "+vetor.elemAtRank(3));
        vetor.removeAtRank(1);
        vetor.print();
    }
}
