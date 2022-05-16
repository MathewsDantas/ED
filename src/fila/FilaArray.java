package fila;

public class FilaArray implements IFila{

    private Object[] fila;
    private int capacidade;
    private int inicio;
    private int fim;
    private int FC;

    public FilaArray(int capacidade, int FC) {
        this.capacidade = capacidade;
        this.FC = FC;
        this.inicio = 0;
        this.fim = 0;
        this.fila = new Object[capacidade];
    }


    @Override
    public void enqueue(Object o) {
        if (size() == capacidade - 1){
            if(FC == 0) {
                capacidade*=2;
            }
            else {
                capacidade = capacidade + FC;
            }
            Object[] fila2 = new Object[capacidade];
            for (int i=0; i <= size(); i++){
                fila2[i] = fila[i];
            }
            fila = fila2;
        }
        fila[fim] = o;
        System.out.println("fim = "+fim +" capacidade = "+capacidade);
        fim = (fim + 1) % capacidade;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()){
            throw new FilaVaziaException("Vazia");
        }
        Object aux = fila[inicio];
        fila[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        return aux;
    }

    @Override
    public Object first() throws FilaVaziaException{
        if (isEmpty()){
            throw new FilaVaziaException("Vazia");
        }
        return fila[inicio];
    }

    @Override
    public int size() {
        return (capacidade - inicio + fim) % capacidade;
    }

    @Override
    public boolean isEmpty() {
        return inicio == fim;
    }
}
