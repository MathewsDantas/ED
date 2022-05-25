package TrabalhoFilaDeque.FilaComDuasPilhas;

public class TestFilaComDuasPilhas {
    public static void main(String[] args) {
        FilaComDuasPilhas fila = new FilaComDuasPilhas();
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);
        fila.print();
        System.out.println("Primeiro da fila: "+ fila.first());
        System.out.println("Retirado: "+ fila.dequeue());
        System.out.println("Retirado: "+ fila.dequeue());
        System.out.println("Retirado: "+ fila.dequeue());
        System.out.println("Retirado: "+ fila.dequeue());
        System.out.println("Retirado: "+ fila.dequeue());
        System.out.println("Tamanho: "+fila.size());
        fila.enqueue(4);
        fila.print();
        System.out.println("Primeiro da fila: "+ fila.first());
    }
}
