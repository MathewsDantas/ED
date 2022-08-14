package skipList;

import java.util.Random;

public class SkipList {

    private QuadNode inicio;
    private QuadNode fim;
    private final Object menosInf = Integer.MIN_VALUE;
    private final Object maisInf = Integer.MAX_VALUE;
    private int altura;


    public SkipList() {
        this.inicio = new QuadNode(menosInf);
        this.fim = new QuadNode(maisInf);
        inicio.setPosterior(fim);
        fim.setAnterior(inicio);
        this.altura = 0;
    }

    public QuadNode busca(Object key){ // Caso n ache a chave, retornará a menor chave mais próxima.
        QuadNode n = inicio;
        while (n.getAbaixo() != null){
            n = n.getAbaixo();
            while ((int)key >= (int)n.getPosterior().getItem()){
                n = n.getPosterior();
            }
        }
        return n;
    }

    private void novoNivel(int nivel){
        if (nivel >= altura){
            altura++;
            QuadNode novoInicio = new QuadNode(menosInf);
            QuadNode novoFim = new QuadNode(maisInf);

            novoInicio.setPosterior(novoFim);
            novoInicio.setAbaixo(inicio);
            inicio.setAcima(novoInicio);
            novoFim.setAnterior(novoInicio);
            novoFim.setAbaixo(fim);
            fim.setAcima(novoFim);

            inicio = novoInicio;
            fim = novoFim;
        }
    }

    private int rand(){
        Random random = new Random();
        int nivel = -1;
        do {
            nivel++;
            novoNivel(nivel);
        } while (random.nextInt(2) == 0);
        return nivel;
    }

    public void insert(Object key){
        QuadNode noEncontrado = busca(key);
        QuadNode NoAbaixo = null;
        int novoNivel = rand();

        for (int i=0; i<=novoNivel; i++){

            QuadNode novoNo = new QuadNode(key);
            QuadNode proximo = noEncontrado.getPosterior();// Nó auxiliar
            noEncontrado.setPosterior(novoNo);
            proximo.setAnterior(novoNo);
            novoNo.setPosterior(proximo);
            novoNo.setAnterior(noEncontrado);
            if (NoAbaixo != null){
                novoNo.setAbaixo(NoAbaixo);
                NoAbaixo.setAcima(novoNo);
            }

            while (noEncontrado.getAcima() == null){//Subir de nível
                noEncontrado = noEncontrado.getAnterior();
            }
            noEncontrado = noEncontrado.getAcima();

            while ((int)key >= (int)noEncontrado.getPosterior().getItem()){//procurar novamente a posição no novo nível.
                noEncontrado = noEncontrado.getPosterior();
            }
            NoAbaixo = novoNo;
        }

    }
}
