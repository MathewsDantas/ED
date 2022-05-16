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
            int cap_aux = capacidade;
            capacidade*=2;
            Object[] p2 = new Object[capacidade];

            for(int i = 0; i <v_size(); i++) {
                p2[i] = p[i];
            }
            for(int i = (cap_aux-1); i <p_size(); i--) {
                p2[--capacidade] = p[i];
            }
            tam_preta = capacidade - (cap_aux-tam_preta);
            p = p2;
        }
        p[++tam_vermelha] = o;
    }

    @Override
    public void p_push(Object o) {
        if((v_size() + p_size()) >= capacidade-1) {
            int cap_aux = capacidade;
            capacidade*=2;
            Object[] p2 = new Object[capacidade];

            for(int i = 0; i <size(); i++) {
                p2[i] = p[i];
            }
            for(int i = (cap_aux-1); i <p_size(); i--) {
                p2[--capacidade] = p[i];
            }
            tam_preta = capacidade - (cap_aux-tam_preta);//nova capacidade - tamanho da pilha preta.
            p = p2;
        }
        p[--tam_preta] = o;
    }

    @Override
    public Object v_pop() throws PilhaVaziaException {
        tam_vermelha--;
        return p[tam_vermelha+1];
    }

    @Override
    public Object p_pop() throws PilhaVaziaException {
        tam_preta++;
        return p[tam_preta-1];
    }

    @Override
    public Object v_top() throws PilhaVaziaException {
        if(v_isEmpty()) {
            throw new PilhaVaziaException("A pilha est� vazia");
        }
        return p[tam_vermelha];
    }

    @Override
    public Object p_top() throws PilhaVaziaException {
        if(p_isEmpty()) {
            throw new PilhaVaziaException("A pilha est� vazia");
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
}
