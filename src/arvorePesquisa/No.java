package arvorePesquisa;

public class No {

    private Object elemento;
    private No pai;
    private No filhoEsquerdo;
    private No filhoDireito;
    private int fb;

    public No() {
        this.elemento = null;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.fb =0;
    }

    public No(Object elemento) {
        this.elemento = elemento;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.fb =0;
    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }



}
