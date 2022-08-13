package heap;

public class TestFilaPrioridadeNode {

    public static void main(String[] args) {
        FilaPrioridadeNode fila = new FilaPrioridadeNode(2);
        fila.insert(10);
        fila.insert(4);
        fila.insert(6);
        fila.insert(1);
        fila.insert(5);
        fila.insert(15);
        fila.printArvore();
        System.out.println("Min: "+fila.min());
        System.out.println("ultimo: "+fila.getUltimo().getElemento());
        System.out.println("RemoveMin: "+fila.removeMin());
        fila.printArvore();
        System.out.println("ultimo: "+fila.getUltimo().getElemento());
        System.out.println("RemoveMin: "+fila.removeMin());
        fila.printArvore();
        System.out.println("ultimo: "+fila.getUltimo().getElemento());
        System.out.println("RemoveMin: "+fila.removeMin());
        fila.printArvore();
        System.out.println("RemoveMin: "+fila.removeMin());
        fila.printArvore();
        System.out.println("ultimo: "+fila.getUltimo().getElemento());
        System.out.println("RemoveMin: "+fila.removeMin());
        fila.printArvore();
        System.out.println("RemoveMin: "+fila.removeMin());
        fila.printArvore();

    }
}
