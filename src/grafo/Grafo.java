package grafo;

import java.util.ArrayList;

public class Grafo {

    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public Vertice InserirVertice(Object o) {
        Vertice novoVertice = new Vertice(o);
        this.vertices.add(novoVertice);
        return novoVertice;
    }

    public Aresta InserirAresta_Nao_Dirigida(Vertice v1, Vertice v2, Double peso) {
        Aresta novaAresta = new Aresta(peso, v1, v2,false);
        this.arestas.add(novaAresta);
        return novaAresta;
    }

    public void InserirAresta(Vertice inicio, Vertice fim, Double peso) {
        Aresta novaAresta = new Aresta(peso, inicio, fim,true);
        inicio.inserirArestaSaida(novaAresta);
        fim.inserirArestaEntrada(novaAresta);
        this.arestas.add(novaAresta);
    }
    
    public ArrayList<Vertice> vertices() { return vertices;}

    public ArrayList<Aresta> arestas(){
        return arestas;
    }

    public ArrayList<Vertice> finalVertices(Aresta aresta) {
        ArrayList<Vertice> vertices = new ArrayList<>();
        vertices.add(aresta.getFim());
        vertices.add(aresta.getInicio());
        return vertices;
    }

    public Vertice oposto(Vertice vertice, Aresta aresta) {
        if (vertice != aresta.getFim() && vertice != aresta.getInicio())
        {
            throw new InvalidVerticeException("O Vertice com a chave "+ vertice.getO() + " nao existe nessa aresta!");
        }
        Vertice aux = aresta.getFim();
        if (aux == vertice)
        {
            aux = aresta.getInicio();
        }
        return aux;
    }

    public boolean ehAdjacente(Vertice v1, Vertice v2) {
        for (Aresta a: v1.getArestasSaida()) {
            if (a.getFim() == v2) {
                return true;
            }
        }
        for (Aresta a: v2.getArestasEntrada()) {
            if (a.getInicio() == v2){
                return true;
            }
        }
        return false;
    }

    public void substituirVertice(Vertice vertice,Object elemento) {
        vertice.setO(elemento);
    }

    public void substituirAresta(Aresta aresta, Double elemento) {
        aresta.setPeso(elemento);
    }

    public Object removeVertice(Vertice vertice) {
        Object aux = vertice.getO();
        Vertice verticeOposto;

        for (Aresta a: vertice.getArestasSaida()) {
             verticeOposto = a.getFim();
             verticeOposto.removeArestaEntrada(a);
        }

        for (Aresta a: vertice.getArestasEntrada()) {
            verticeOposto = a.getInicio();
            verticeOposto.removeArestaSaida(a);
        }

        vertice = null;
        return aux;
    }

    public Object removeAresta(Aresta aresta) {
        Object aux = aresta.getPeso();

        Vertice inicio = aresta.getInicio();
        inicio.removeArestaSaida(aresta);
        Vertice fim = aresta.getFim();
        fim.removeArestaEntrada(aresta);

        return aux;
    }

    public ArrayList<Aresta> arestasIncidentes(Vertice vertice) {

        ArrayList<Aresta> todasArestas = new ArrayList<>(vertice.getArestasSaida());
        todasArestas.addAll(vertice.getArestasEntrada());

        return todasArestas;
    }

    public boolean ehDirecionado(Aresta aresta) {
        return aresta.isDirigida();
    }
}
