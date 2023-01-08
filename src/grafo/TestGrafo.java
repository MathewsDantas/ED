package grafo;

import java.util.ArrayList;

public class TestGrafo {

    public static void main(String[] args) {
        Grafo grafo_Nao_Dirigido = new Grafo();

        Vertice v1 = grafo_Nao_Dirigido.InserirVertice("V1");
        Vertice v2 = grafo_Nao_Dirigido.InserirVertice("V2");
        Vertice v3 = grafo_Nao_Dirigido.InserirVertice("V3");
        Vertice v4 = grafo_Nao_Dirigido.InserirVertice("V4");

        grafo_Nao_Dirigido.InserirAresta_Nao_Dirigida(v1,v2, "c1");
        grafo_Nao_Dirigido.InserirAresta_Nao_Dirigida(v1,v3, "c2");
        grafo_Nao_Dirigido.InserirAresta_Nao_Dirigida(v3,v4, "c3");
        grafo_Nao_Dirigido.InserirAresta_Nao_Dirigida(v2,v4, "c4");

        grafo_Nao_Dirigido.matrizIncidencia();

        Grafo grafo = new Grafo();
        v1 = grafo.InserirVertice("V1");
        v2 = grafo.InserirVertice("V2");
        v3 = grafo.InserirVertice("V3");
        v4 = grafo.InserirVertice("V4");

        grafo.InserirAresta(v2,v1, "c1");
        grafo.InserirAresta(v1,v3, "c2");
        grafo.InserirAresta(v4,v3, "c3");
        grafo.InserirAresta(v4,v2, "c4");


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

        ArrayList<Aresta> todasArestasDoVertice = grafo.arestasIncidentes(v1);
        System.out.println("\nTodas as arestas do vertice: "+ v1.getO());
        for (Aresta o: todasArestasDoVertice) {
            System.out.println(o.getPeso());
        }


        grafo.matrizIncidencia_Dirigido();
    }

}
