package avl;

public class TestAVL {
    public static void main(String[] args) {
        Avl avl = new Avl(9);

        avl.insert(10);
        avl.insert(13);
        avl.printArvore();
        avl.insert(15);
        avl.printArvore();
        avl.insert(12);
        avl.printArvore();
        avl.insert(11);
        avl.printArvore();
        avl.insert(16);
        avl.printArvore();
        avl.insert(17);
        avl.printArvore();
        avl.remove(15);
        avl.printArvore();
        avl.remove(16);
        avl.printArvore();
        avl.insert(8);
        avl.printArvore();
        avl.remove(13);
        avl.printArvore();
        avl.remove(10);

        avl.printArvore();
    }
}

