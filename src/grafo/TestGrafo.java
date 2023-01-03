package grafo;

import java.util.ArrayList;

public class TestGrafo {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Vertice v1 = grafo.InserirVertice("G1");
        Vertice v2 = grafo.InserirVertice("G2");
        Vertice v3 = grafo.InserirVertice("G3");
        Vertice v4 = grafo.InserirVertice("G4");

        grafo.InserirAresta(v1,v2, 10.0);
        grafo.InserirAresta(v1,v3, 15.0);
        grafo.InserirAresta(v2,v3, 20.0);
        grafo.InserirAresta(v3,v4, 30.0);
        grafo.InserirAresta(v4,v1, 40.0);

        System.out.println("Todos os vertices do grafo:");
        ArrayList<Vertice> todosVertices = grafo.vertices();
        for (Vertice o: todosVertices) {
            System.out.println(o.getO());
        }

        System.out.println("\nTodas as arestas do grafo: ");
        ArrayList<Aresta> todasArestas = grafo.arestas();
        for (Aresta o: todasArestas) {
            System.out.println(o.getPeso());
        }

        ArrayList<Aresta> arestasSaida = v1.getArestasSaida();
        System.out.println("\nTodas as arestas de saída de: " + v1.getO());
        for (Aresta o: arestasSaida) {
            System.out.println(o.getPeso());
        }

        ArrayList<Aresta> arestasEntrada = v1.getArestasEntrada();
        System.out.println("\nTodas as arestas de entrada de: " + v1.getO());
        for (Aresta o: arestasEntrada) {
            System.out.println(o.getPeso());
        }
    }

}
