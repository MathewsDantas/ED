package rubroNegra;

public class No {

    public Object elemento;
    private No pai;
    private No filhoEsquerdo;
    private No filhoDireito;
    private boolean rubro;

    public No(){
        this.elemento = null;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.rubro = true;
    }

    public No(Object elemento) {
        this.elemento = elemento;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.rubro = true;
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

    public boolean isRubro() {
        return rubro;
    }

    public void setRubro(boolean vermelho) {
        this.rubro = vermelho;
    }

    public void ehRubro (Boolean x) {
        this.rubro = x;
    }
}
