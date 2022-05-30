package TADLista;

public class TestListaEncadeada {
    public static void main(String[] args) throws ListaVaziaException {
        ListaListaEncadeada lista = new ListaListaEncadeada();
        System.out.println("Tamanho: "+lista.size());
        lista.insertFirst(1);
        lista.insertFirst(2);
        lista.insertLast(4);
        lista.insertBefore(2,10);
        lista.insertAfter(0,5);
        lista.print();
    }
}
