package avl;

import arvorePesquisa.ArvorePesquisa;
import arvorePesquisa.InvalidNoException;
import arvorePesquisa.No;

import java.util.ArrayList;

public class Avl extends ArvorePesquisa {

    public Avl() {
        super();
    }

    public Avl(Object key) {
        super(key);
    }


    public static void rightRotation(No no){
        No novoPai = no.getFilhoEsquerdo();
        if (hasRight(novoPai)) {
            no.setFilhoEsquerdo(novoPai.getFilhoDireito());
            no.getFilhoEsquerdo().setPai(no);
            novoPai.setFilhoDireito(no);
        }
        else {
            novoPai.setFilhoDireito(no);
            no.setFilhoEsquerdo(null);
        }
        if (no != root){
            if (no == no.getPai().getFilhoDireito()){
                no.getPai().setFilhoDireito(novoPai);
            }
            else {
                no.getPai().setFilhoEsquerdo(novoPai);
            }
            novoPai.setPai(no.getPai());
        }
        else { // o novoPai será a nova raíz
            root = novoPai;
        }
        no.setPai(novoPai);
        /*  FB_B_novo= FB_B - 1 - max(FB_A, 0);
        *    FB_A_novo= FB_A - 1 + min(FB_B_novo, 0);
        */
        int novoFbB = no.getFb() - 1 - Math.max(novoPai.getFb(),0);
        int novoFbA = novoPai.getFb() - 1 + Math.min(novoFbB,0);
        no.setFb(novoFbB);
        novoPai.setFb(novoFbA);
    }

    public static void leftRotation(No no){
        No novoPai = no.getFilhoDireito();
        if (hasLeft(novoPai)) {
            no.setFilhoDireito(novoPai.getFilhoEsquerdo());
            no.getFilhoDireito().setPai(no);
            novoPai.setFilhoEsquerdo(no);
        }
        else {
            novoPai.setFilhoEsquerdo(no);
            no.setFilhoDireito(null);
        }
        if (no != root){
            if (no == no.getPai().getFilhoDireito()){
                no.getPai().setFilhoDireito(novoPai);
            }
            else {
                no.getPai().setFilhoEsquerdo(novoPai);
            }
            novoPai.setPai(no.getPai());
        }
        else { // o novoPai será a nova raíz
            root = novoPai;
        }
        no.setPai(novoPai);
        /*  FB_B_novo= FB_B + 1 - min(FB_A, 0);
        *   FB_A_novo= FB_A + 1 +max(FB_B_novo, 0);
        */
        int novoFbB = (no.getFb() + 1) - Math.min(novoPai.getFb(),0);
        int novoFbA = (novoPai.getFb() + 1) + Math.max(novoFbB,0);
        no.setFb(novoFbB);
        novoPai.setFb(novoFbA);
    }

    public void checkRotation(No no){
        if (no.getPai().getFb() == 2){ // rotação a direita
            if (no.getPai().getFilhoEsquerdo().getFb() >= 0){ // se a subarvore a esquerda tiver o msm sinal faz rotaçãoSimples.
                rightRotation(no.getPai());//nó desbalanceado
            }
            else {// rotaçãoDupla
                No noPai = no.getPai();
                leftRotation(no);
                rightRotation(noPai);//nó desbalanceado
            }
        }
        else if(no.getPai().getFb() == -2){ // rotação a esquerda
            if (no.getPai().getFilhoDireito().getFb() <=0){ // se a subarvore a direita tiver o msm sinal faz rotaçãoSimples.
                leftRotation(no.getPai());//nó desbalanceado
            }
            else { // rotaçãoDupla
                No noPai = no.getPai();
                rightRotation(no);
                leftRotation(noPai);//nó desbalanceado
            }
        }
    }

    public void checkFb(No no, int ehInsert, boolean ehEsquerdo){
        if (ehEsquerdo){ // eh filho esquerdo
            no.getPai().setFb(no.getPai().getFb() + (ehInsert)); // se for insert será +1, caso seja remove será -1.
        }
        if (!ehEsquerdo){ //eh filho direito
            no.getPai().setFb(no.getPai().getFb() - (ehInsert));
        }
        if (no.getPai().getFb() == 2 || no.getPai().getFb() == -2){
            checkRotation(no);
        }
        else if ((no.getPai() != root && ehInsert == 1 && no.getPai().getFb() != 0)){//condição de parada insert
            ehEsquerdo = false;
            if (no.getPai().getPai().getFilhoEsquerdo() == no.getPai()){ // Verifica se o antecessor é filho esquerdo
                ehEsquerdo = true;
            }
            checkFb(no.getPai(), ehInsert, ehEsquerdo);
        }
        else if((no.getPai() != root && ehInsert == -1 && (no.getPai().getFb() == 0))){//condição de parada remove
            ehEsquerdo = false;
            if (no.getPai().getPai().getFilhoEsquerdo() == no.getPai()){
                ehEsquerdo = true;
            }
            checkFb(no.getPai(), ehInsert, ehEsquerdo);
        }
    }

    public No insert(Object k){
        No v = super.insert(k);
        boolean ehEsquerdo = false;
        if (v.getPai().getFilhoEsquerdo() == v){
            ehEsquerdo = true;
        }
        checkFb(v, 1, ehEsquerdo);
        return v;
    }

    public void remove(Object k){
        boolean ehEsquerdo = false;
        No novoNo = null;
        No aux = find(k, root);
        if(k != aux.getElemento()) {
            throw new InvalidNoException("O Node com a chave "+ k + " nao existe!");
        }
        else {
            if (isExternal(aux)) {
                if (aux.getPai().getFilhoEsquerdo() == aux) {
                    ehEsquerdo = true;
                    aux.getPai().setFilhoEsquerdo(null);
                } else {
                    aux.getPai().setFilhoDireito(null);
                }
                checkFb(aux,-1,ehEsquerdo);
            }
            else if (aux.getFilhoEsquerdo() == null) { //verifica se o aux tem filho direito
                if (aux.getPai().getFilhoEsquerdo() == aux) { // verifica se é filho esquerdo
                    aux.getPai().setFilhoEsquerdo(aux.getFilhoDireito());
                    aux.getFilhoDireito().setPai(aux.getPai());
                    novoNo = aux.getFilhoEsquerdo(); // avl - o aux é descartado
                } else if (aux.getPai().getFilhoDireito() == aux) {
                    aux.getPai().setFilhoDireito(aux.getFilhoDireito());
                    aux.getFilhoDireito().setPai(aux.getPai());
                    novoNo = aux.getFilhoDireito(); // avl
                }
                if (aux.getPai().getFilhoEsquerdo() == aux){
                    ehEsquerdo = true;
                }
                checkFb(novoNo,-1,ehEsquerdo);
            }
            else if (aux.getFilhoDireito() == null) {
                if (aux.getPai().getFilhoEsquerdo() == aux) {
                    aux.getPai().setFilhoEsquerdo(aux.getFilhoEsquerdo());
                    aux.getFilhoEsquerdo().setPai(aux.getPai());
                    novoNo = aux.getFilhoEsquerdo(); // avl
                } else if (aux.getPai().getFilhoDireito() == aux) {
                    aux.getPai().setFilhoDireito(aux.getFilhoEsquerdo());
                    aux.getFilhoEsquerdo().setPai(aux.getPai());
                    novoNo = aux.getFilhoDireito(); // avl
                }
                if (aux.getPai().getFilhoEsquerdo() == aux){
                    ehEsquerdo = true;
                }
                checkFb(novoNo,-1,ehEsquerdo);
            }
            else { // v possui os 2 filhos.
                No min;
                min = aux;
                min = min.getFilhoDireito();
                while (min.getFilhoEsquerdo() != null) { //encontrar o menor a direita
                    min = min.getFilhoEsquerdo();
                }
                size++;
                remove(min.getElemento());
                aux.setElemento(min.getElemento());
            }
            size--;
        }
    }

    public void printArvore() {
        ArrayList<No> lista = new ArrayList<>();
        organizador(root, lista);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("A R V O R E:");
        for(int j=0; j <= height(root); j++) {
            for(int i = 0; i<size();i++) {
                if(depth(lista.get(i)) == j) {
                    System.out.print("(" + (lista.get(i)).getElemento() + ")" +"["+ (lista.get(i).getFb()) + "]");
                } else {
                    System.out.print("\t       ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    private void organizador(No no,  ArrayList<No> lista) {
        if(no.getFilhoEsquerdo() != null) {
            organizador(no.getFilhoEsquerdo(),lista);
        }
        lista.add(no);
        if(no.getFilhoDireito() != null) {
            organizador(no.getFilhoDireito(),lista);
        }
    }
}
