package avl;

import java.util.ArrayList;

public class Avl {

    private No root;
    private int size;

    public Avl() {
    }

    public Avl(Object key) {
        root = new No(key);
        size = 1;
    }

    public No root()
    {
        return root;
    }

    public boolean isInternal(No v)
    {
        return (v.getFilhoEsquerdo() != null || v.getFilhoDireito() != null);
    }

    public boolean isExternal(No v)
    {
        return (v.getFilhoEsquerdo() == null && v.getFilhoDireito() == null);
    }

    public boolean isRoot(No v)
    {
        return v == root;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public No parent(No v)
    {
        return v.getPai();
    }

    public int depth(No v){
        if (isRoot(v))
            return 0;
        else
            return 1 + depth(v.getPai());
    }

    public int height(No v){
        if(isExternal(v)){
            return 0;
        }
        else {
            int h1 = 0;
            if (hasLeft(v)){
                h1 = 1 + height(v.getFilhoEsquerdo());
            }
            int h2 = 0;
            if (hasRight(v)) {
                h2 = 1 + height(v.getFilhoDireito());
            }
            return h1 > h2 ? h1 : h2;
        }
    }

    public Object replace(No v, Object o) {
        Object aux = v.getElemento();
        v.setElemento(o);
        return aux;
    }

    public No find(Object k, No v){
        if (isExternal(v)){
            return v;
        }
        if ( (int) k < (int) v.getElemento()){
            if (hasLeft(v)){
                return find(k, v.getFilhoEsquerdo());
            }
            return v;
        }
        else if ( k == v.getElemento()){
            return v;
        }
        else if ( (int) k > (int) v.getElemento()){
            if (hasRight(v)){
                return find(k , v.getFilhoDireito());
            }
            return v;
        }
        return v;
    }

    public void insert(Object k){
        No aux = find(k, root);
        No v = new No();
        v.setElemento(k);
        if ( (int) k <= (int) aux.getElemento()){
            v.setPai(aux);
            aux.setFilhoEsquerdo(v);
        }
        else {
            v.setPai(aux);
            aux.setFilhoDireito(v);
        }
        size++;
        checkFb(v, 1);
    }

    public void rightRotation(No no){
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
        int novoFbB = no.getFb() - 1 - Math.min(novoPai.getFb(),0);
        int novoFbA = novoPai.getFb() - 1 + Math.max(novoFbB,0);
        no.setFb(novoFbB);
        novoPai.setFb(novoFbA);
    }

    public void leftRotation(No no){
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
        int novoFbB = no.getFb() + 1 - Math.min(novoPai.getFb(),0);
        int novoFbA = novoPai.getFb() + 1 + Math.max(novoFbB,0);
        no.setFb(novoFbB);
        novoPai.setFb(novoFbA);
    }

    public void checkRotation(No no){
        if (no.getPai().getFb() == 2){ // rotação a direita
            if (no.getFb() >= 0){ // se a subarvore a esquerda tiver o msm sinal faz rotaçãoSimples.
                rightRotation(no.getPai());//nó desbalanceado
            }
            else {// rotaçãoDupla
                leftRotation(no);
                rightRotation(no.getPai());//nó desbalanceado
            }
        }
        else if(no.getPai().getFb() == -2){ // rotação a esquerda
            if (no.getPai().getFilhoDireito().getFb() <=0){ // se a subarvore a direita tiver o msm sinal faz rotaçãoSimples.
                leftRotation(no.getPai());//nó desbalanceado
            }
            else { // rotaçãoDupla
                rightRotation(no);
                leftRotation(no.getPai());//nó desbalanceado
            }
        }
    }

    public void checkFb(No no, int ehInsert){
        if (no.getPai().getFilhoEsquerdo() == no){ // eh filho esquerdo
            no.getPai().setFb(no.getPai().getFb() + (ehInsert)); // se for insert será +1, caso seja remove será -1.
        }
        else {
            no.getPai().setFb(no.getPai().getFb() - (ehInsert));
        }
        if (no.getPai().getFb() == 0) { //condição de parada
            return;
        }
        else {
            checkRotation(no);
            checkFb(no.getPai(), ehInsert);
        }
    }

    public void remove(Object k){
        No aux = find(k, root);
        if(k != aux.getElemento()) {
            throw new InvalidNoException("O Node com a chave "+ k + " nao existe!");
        }
        else {
            if (isExternal(aux)) {
                if (aux.getPai().getFilhoEsquerdo() == aux) {
                    aux.getPai().setFilhoEsquerdo(null);
                } else {
                    aux.getPai().setFilhoDireito(null);
                }
            }
            else if (aux.getFilhoEsquerdo() == null) { //verifica se o aux tem filho direito
                if (aux.getPai().getFilhoEsquerdo() == aux) { // verifica se é filho esquerdo
                    aux.getPai().setFilhoEsquerdo(aux.getFilhoDireito());
                    aux.getFilhoDireito().setPai(aux.getPai());
                } else if (aux.getPai().getFilhoDireito() == aux) {
                    aux.getPai().setFilhoDireito(aux.getFilhoDireito());
                    aux.getFilhoDireito().setPai(aux.getPai());
                }
            }
            else if (aux.getFilhoDireito() == null) {
                if (aux.getPai().getFilhoEsquerdo() == aux) {
                    aux.getPai().setFilhoEsquerdo(aux.getFilhoEsquerdo());
                    aux.getFilhoEsquerdo().setPai(aux.getPai());
                } else if (aux.getPai().getFilhoDireito() == aux) {
                    aux.getPai().setFilhoDireito(aux.getFilhoEsquerdo());
                    aux.getFilhoEsquerdo().setPai(aux.getPai());
                }
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
            checkFb(aux, -1);
        }
    }

    public void preOrder(No v) {
        if (v != null){
            System.out.println(v.getElemento());
            preOrder(v.getFilhoEsquerdo());
            preOrder(v.getFilhoDireito());
        }

    }

    public void posOrder(No v){
        if (v != null){
            posOrder(v.getFilhoEsquerdo());
            posOrder(v.getFilhoDireito());
            System.out.println(v.getElemento());
        }
    }

    public void inOrder(No v){
        if (v != null){
            inOrder(v.getFilhoEsquerdo());
            System.out.println(v.getElemento());
            inOrder(v.getFilhoDireito());
        }
    }

    private boolean hasLeft(No v){
        return v.getFilhoEsquerdo() != null;
    }

    private boolean hasRight(No v){
        return v.getFilhoDireito() != null;
    }

    public void printArvore() {
        ArrayList<No> lista = new ArrayList<>();
        organizador(root, lista);
        System.out.println("A R V O R E:");
        for(int j=0; j <= height(root); j++) {
            for(int i = 0; i<size();i++) {
                if(depth(lista.get(i)) == j) {
                    System.out.print("(" + (lista.get(i)).getElemento() + ")");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    private void organizador(No no, ArrayList<No> lista) {
        if(no.getFilhoEsquerdo() != null) {
            organizador(no.getFilhoEsquerdo(),lista);
        }
        lista.add(no);
        if(no.getFilhoDireito() != null) {
            organizador(no.getFilhoDireito(),lista);
        }
    }
}
