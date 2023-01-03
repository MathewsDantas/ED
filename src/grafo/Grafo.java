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

    public void InserirAresta(Vertice inicio, Vertice fim, Double peso) {
        Aresta novaAresta = new Aresta(peso, inicio, fim);
        inicio.inserirArestaSaida(novaAresta);
        fim.inserirArestaEntrada(novaAresta);
        this.arestas.add(novaAresta);
    }
    
    public ArrayList<Vertice> vertices() {
        return vertices;
    }

    public ArrayList<Aresta> arestas(){
        return arestas;
    }
    
}
