package grafo;

public class Aresta {

    private Double peso;
    private Vertice inicio;
    private Vertice fim;
    private boolean dirigida;

    public Aresta(Double peso, Vertice inicio, Vertice fim, boolean dirigida) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
        this.dirigida = dirigida;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }

    public boolean isDirigida() {
        return dirigida;
    }

    public void setDirigida(boolean dirigida) {
        this.dirigida = dirigida;
    }
}
