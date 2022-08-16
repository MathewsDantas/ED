package skipList;

import java.util.ArrayList;
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

    private QuadNode buscaMaisProx(Object key){ // Caso n ache a chave, retornará a menor chave mais próxima da key.
        QuadNode n = inicio;
        while (n.getAbaixo() != null){
            n = n.getAbaixo();
            while ((int)key >= (int)n.getPosterior().getItem()){
                n = n.getPosterior();
            }
        }
        return n;
    }

    public Object busca(Object key){// Na primeira vez que achar a key ele retorna.
        QuadNode n = inicio;
        while (n.getAbaixo() != null){
            n = n.getAbaixo();
            while ((int)key >= (int)n.getPosterior().getItem()){
                if((int)key == (int)n.getItem()){// retorna na primeir ocorrência.
                    return n.getItem();
                }
                n = n.getPosterior();
            }
        }
        if (n.getItem() != key){
            return "NO SUCH KEY";
        }
        return n.getItem();
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

    public void insert(Object key) {
        QuadNode noEncontrado = buscaMaisProx(key);
        QuadNode NoAbaixo = null;
        int novoNivel = rand();
        for (int i = 0; i <= novoNivel; i++) {

            QuadNode novoNo = new QuadNode(key);
            QuadNode proximo = noEncontrado.getPosterior();// Nó auxiliar
            noEncontrado.setPosterior(novoNo);
            proximo.setAnterior(novoNo);
            novoNo.setPosterior(proximo);
            novoNo.setAnterior(noEncontrado);
            if (NoAbaixo != null) {
                novoNo.setAbaixo(NoAbaixo);
                NoAbaixo.setAcima(novoNo);
            }

            while (noEncontrado.getAcima() == null) {//Subir de nível
                noEncontrado = noEncontrado.getAnterior();
            }
            noEncontrado = noEncontrado.getAcima();

            while ((int) key >= (int) noEncontrado.getPosterior().getItem()) {//procurar novamente a posição no novo nível.
                noEncontrado = noEncontrado.getPosterior();
            }
            NoAbaixo = novoNo;
        }
    }

    public void remove(Object key){
        QuadNode noEncontrado = buscaMaisProx(key);
        QuadNode aux = noEncontrado;
        do {
            aux.getAnterior().setPosterior(aux.getPosterior());
            aux.getPosterior().setAnterior(aux.getAnterior());
            aux = aux.getAcima();
        }while (aux != null);

    }

    public void print(){
        ArrayList<Object> arrayPrint = new ArrayList<>();
        ArrayList<Object> arrayPrint2 = new ArrayList<>();
        QuadNode auxPrint = inicio;
        while (auxPrint.getAbaixo() != null){//Vai para o nivel 0 para pegar todos os elementos.
            auxPrint = auxPrint.getAbaixo();
        }
        while (auxPrint != null){// pega todos os elementos.
            arrayPrint.add(auxPrint.getItem());
            auxPrint = auxPrint.getPosterior();
        }
        QuadNode auxV = inicio;
        QuadNode auxH = auxV;
        int nivel = altura;
        System.out.println("altura :"+altura);
        while(auxV != null){
            System.out.print("Lv"+ nivel+" --> ");
            arrayPrint2.clear();
            while (auxH != null) {
                arrayPrint2.add(auxH.getItem());
                auxH = auxH.getPosterior();
            }
            int x = 0;
            for (int i = 0; i < arrayPrint2.size(); i++) {
                for (int j = x; j < arrayPrint.size(); j++){
                    if (arrayPrint.get(j) == arrayPrint2.get(i)){
                        if (arrayPrint2.get(i) == menosInf){
                            System.out.print("(-) ");
                        }
                        else if(arrayPrint2.get(i) == maisInf ){
                            System.out.print(" (+)");
                        }
                        else {
                            System.out.print("| " + arrayPrint.get(j) + " |");
                        }
                        j = arrayPrint.size();
                        x++;
                    }
                    else if(arrayPrint.get(j) != arrayPrint2.get(i)){
                        System.out.print("      ");
                        x++;
                    }
                }
            }
            nivel--;
            auxV = auxV.getAbaixo();
            auxH = auxV;
            System.out.println();
        }
    }

}
