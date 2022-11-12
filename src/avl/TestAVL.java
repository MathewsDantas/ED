package avl;

public class TestAVL {
    public static void main(String[] args) {
        Avl avl = new Avl(1);

        avl.insert(2);
        avl.insert(3);
        avl.printArvore();
        avl.insert(4);
        avl.printArvore();
        avl.insert(5);
        avl.printArvore();
        avl.insert(6);
        avl.printArvore();
        avl.insert(7);
        avl.printArvore();
        avl.insert(8);
        avl.printArvore();
        avl.insert(9);
        avl.printArvore();
        avl.remove(4);
        avl.printArvore();
    }
}

