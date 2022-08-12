package heap;

public class Node {

    private Object elemento;
    private Node pai;
    private Node filhoEsquerdo;
    private Node filhoDireito;

    public Node() {
        this.elemento = null;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }

    public Node(Object elemento) {
        this.elemento = elemento;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    public Node getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(Node filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public Node getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(Node filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

}
