package TrabalhoFilaDeque.PilhaLista;

public class TestPilhaLigada {
    public static void main(String[] args){

        PilhaLigada pilha = new PilhaLigada();
        pilha.push(10);
        pilha.push(30);
        pilha.push(50);
        pilha.print();
        System.out.println("Topo da pilha: "+ pilha.top());
        System.out.println("Tamanho da pilha: "+ pilha.size());
        System.out.println("Retirado: "+pilha.pop());
        pilha.print();
        System.out.println("Topo da pilha: "+ pilha.top());
    }
}
