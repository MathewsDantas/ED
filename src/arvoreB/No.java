package arvoreB;

import java.util.ArrayList;

public class No {
    private No pai;
    private ArrayList<Object> chaves = new ArrayList<>();
    private ArrayList<No> filhos = new ArrayList<>();

    public No(No pai, ArrayList<Object> chaves) {
        this.pai = pai;
        this.chaves = chaves;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public ArrayList<Object> getChaves() {
        return chaves;
    }

    public void setChave(Object chave) {
        this.chaves.add(chave);
    }

    public ArrayList<No> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<No> filhos) {
        this.filhos = filhos;
    }

    public void insereFilho(No o)
    {
        filhos.add(o);
    }
    public void removeFilho(No o)
    {
        filhos.remove(o);
    }
    public int NumeroDeFilhos()
    {
        return filhos.size();
    }
}
