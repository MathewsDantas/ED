package TrabalhoFilaDeque;

public class TestPilhaLigada {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.push(10);
        lista.push(30);
        lista.push(50);
        lista.print();
        System.out.println("Topo da pilha: "+ lista.top());
        System.out.println("Tamanho da pilha: "+ lista.size());
        lista.pop();
        lista.print();
        System.out.println("Topo da pilha: "+ lista.top());
    }
}
