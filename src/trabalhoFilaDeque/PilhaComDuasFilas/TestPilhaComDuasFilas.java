package trabalhoFilaDeque.PilhaComDuasFilas;

public class TestPilhaComDuasFilas {
    public static void main(String[] args) {
        PilhaComDuasFilas pilha = new PilhaComDuasFilas();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);
        System.out.println("Tamanho: "+ pilha.size());
        System.out.println("Topo da pilha: "+ pilha.top());
        pilha.print();
        System.out.println("Retirado: "+ pilha.pop());
        System.out.println("Retirado: "+ pilha.pop());
        System.out.println("Retirado: "+ pilha.pop());
        System.out.println("Retirado: "+ pilha.pop());
        System.out.println("Retirado: "+ pilha.pop());
        pilha.print();
        System.out.println("Tamanho: "+ pilha.size());
        pilha.push(30);
        System.out.println("Topo da pilha: "+ pilha.top());
        System.out.println("Tamanho: "+ pilha.size());

    }
}
