package grafo;

import java.util.ArrayList;

public class Vertice {

    private Object o;
    private ArrayList<Aresta> arestasSaida;
    private ArrayList<Aresta> arestasEntrada;

    public Vertice(Object o) {
        this.o = o;
        this.arestasEntrada = new ArrayList<Aresta>();
        this.arestasSaida = new ArrayList<Aresta>();
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public ArrayList<Aresta> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta> getArestasSaida() {
        return arestasSaida;
    }

    public void inserirArestaEntrada(Aresta aresta){ // é apontado
        this.arestasEntrada.add(aresta);
    }

    public void inserirArestaSaida(Aresta aresta){ // aponta
        this.arestasSaida.add(aresta);
    }


}
