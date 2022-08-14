package skipList;

public class QuadNode {

    private QuadNode anterior;
    private QuadNode posterior;
    private QuadNode abaixo;
    private QuadNode acima;
    private Object key;

    public QuadNode(Object key) {
        this.anterior = null;
        this.posterior = null;
        this.abaixo = null;
        this.acima = null;
        this.key = key;
    }

    public QuadNode getAnterior() {
        return anterior;
    }

    public void setAnterior(QuadNode anterior) {
        this.anterior = anterior;
    }

    public QuadNode getPosterior() {
        return posterior;
    }

    public void setPosterior(QuadNode posterior) {
        this.posterior = posterior;
    }

    public QuadNode getAbaixo() {
        return abaixo;
    }

    public void setAbaixo(QuadNode abaixo) {
        this.abaixo = abaixo;
    }

    public QuadNode getAcima() {
        return acima;
    }

    public void setAcima(QuadNode acima) {
        this.acima = acima;
    }

    public Object getItem() {
        return key;
    }

    public void setItem(Object item) {
        this.key = item;
    }
}
