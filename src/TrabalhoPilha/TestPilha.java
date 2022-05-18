package TrabalhoPilha;

import pilha.PilhaVaziaException;

public class TestPilha {

    public static void main(String[] args) throws PilhaVaziaException {
        VermelhaPreta p = new VermelhaPreta(1);
        p.v_push(10);
        p.v_push(20);
        p.v_push(30);
        p.p_push(100);
        p.p_push(200);
        p.p_push(300);
        System.out.println("Array inteiro: ");
        p.print();
        System.out.println("Pilha vermelha: ");
        p.v_pop();
        p.v_print();
        System.out.println("Pilha preta: ");
        p.p_pop();
    }
}
