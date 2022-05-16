package TrabalhoPilha;

import pilha.PilhaVaziaException;

public class VermelhaPreta implements IPilha{
    private Object[] p;
    private int capacidade;
    private int tam_vermelha;
    private int tam_preta;

    public VermelhaPreta(int capacidade) {
        this.capacidade = capacidade;
        this.p = new Object[capacidade];
        this.tam_vermelha = -1;
        this.tam_preta = capacidade;
    }

    @Override
    public void v_push(Object o) {
        if((v_size() + p_size()) >= capacidade-1) {
            int cap_antiga = capacidade;
            capacidade*=2;
            int cap_aux = capacidade;
            Object[] p2 = new Object[capacidade];

            for(int i = 0; i <(tam_vermelha + 1); i++) {
                p2[i] = p[i];
            }
            for(int i = (cap_antiga-1); i >(cap_antiga-tam_preta); i--) {
                p2[--cap_aux] = p[i];
            }
            tam_preta = capacidade - (cap_antiga-tam_preta); // passa o novo indice que o top da preta está
            p = p2;
        }
        p[++tam_vermelha] = o;
    }

    @Override
    public void p_push(Object o) {
        if(size() >= capacidade-1) {
            int cap_antiga = capacidade;
            capacidade*=2;
            int cap_aux = capacidade;
            Object[] p2 = new Object[capacidade];

            for(int i = 0; i <(tam_vermelha + 1); i++) {
                p2[i] = p[i];
            }
            for(int i = (cap_antiga-1); i >(cap_antiga-tam_preta); i--) {
                p2[--cap_aux] = p[i];
            }
            tam_preta = capacidade - (cap_antiga-tam_preta);//nova capacidade - tamanho da pilha preta.
            p = p2;
        }
        p[--tam_preta] = o;
    }

    @Override
    public Object v_pop() throws PilhaVaziaException {
        if(isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia");
        }
        tam_vermelha--;
        return p[tam_vermelha+1];
    }

    @Override
    public Object p_pop() throws PilhaVaziaException {
        if(isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia");
        }
        tam_preta++;
        return p[tam_preta-1];
    }

    @Override
    public Object v_top() throws PilhaVaziaException {
        if(v_isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia");
        }
        return p[tam_vermelha];
    }

    @Override
    public Object p_top() throws PilhaVaziaException {
        if(p_isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia");
        }
        return p[tam_preta];
    }

    @Override
    public boolean isEmpty() {
        return v_isEmpty() && p_isEmpty();
    }

    @Override
    public boolean v_isEmpty() {
        return tam_vermelha == -1;
    }

    @Override
    public boolean p_isEmpty() {
        return tam_preta == capacidade;
    }

    @Override
    public int size() {
        return (v_size() + p_size());
    }

    @Override
    public int v_size() {
        return tam_vermelha + 1;
    }

    @Override
    public int p_size() {
        return (capacidade - tam_preta);
    }

    @Override
    public void print() {
        for(int i = 0; i < capacidade; i++) {
            System.out.println(p[i]);
        }
    }

    @Override
    public void v_print() {
        for(int i = 0; i <= tam_vermelha; i++) {
            System.out.println(p[i]);
        }
    }

    @Override
    public void p_print() {
        for(int i = (capacidade-1); i >=tam_preta; i--) {
            System.out.println(p[i]);
        }
    }
}
