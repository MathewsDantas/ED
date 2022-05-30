package TADLista;

public class TestListaArray {
    public static void main(String[] args) throws ListaVaziaException {
        ListaArray lista = new ListaArray(1);
        System.out.println("Tamanho: "+lista.size());
        lista.insertFirst(1);
        lista.insertFirst(2);
        lista.insertFirst(3);
        lista.print();
        lista.insertLast(10);
        lista.insertLast(15);
        lista.print();
        System.out.println("Retirado da position 3: "+lista.remove(3));
        System.out.println("Retirado da position 0: "+lista.remove(0));
        lista.insertAfter(1,4);
        lista.insertAfter(1,40);
        lista.insertAfter(4,50);
        lista.insertBefore(1,100);
        lista.swapElements(1,4);
        lista.print();
    }
}
