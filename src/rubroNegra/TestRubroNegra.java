package rubroNegra;

public class TestRubroNegra {
    public static void main(String[] args) {

        ArvoreRubroNegra rn = new ArvoreRubroNegra(1);
        rn.printArvore();
        rn.insert(2);
        rn.printArvore();
        rn.insert(3);
        rn.printArvore();
        rn.insert(4);
        rn.printArvore();
        rn.insert(5);
        rn.printArvore();
        rn.insert(6);
        rn.printArvore();
        rn.insert(7);
        rn.printArvore();
        rn.insert(8);
        rn.printArvore();
        rn.insert(9);
        rn.printArvore();
        rn.insert(10);
        rn.printArvore();
        rn.insert(11);
        rn.printArvore();
        rn.insert(12);
        rn.printArvore();


        rn.remove(2);
        rn.printArvore();
        System.out.println("Removido o 2"); // situacao 3 caso4
        rn.remove(3);
        rn.printArvore();
        System.out.println("Removido o 3");
        rn.remove(8);
        rn.printArvore();
        System.out.println("Removido o 8");
        rn.remove(11);
        rn.printArvore();
        System.out.println("Removido o 11");


    }
}
