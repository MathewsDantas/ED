package heap;

import java.util.ArrayList;

public class HeapNode {

    private Node raiz;
    private Node ultimo;
    private int tamanho;

    HeapNode(){
        this.raiz = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    HeapNode(Object k){
        this.raiz = new Node(k);
        this.ultimo = raiz;
        this.tamanho = 1;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public void setUltimo(Node ultimo) {
        this.ultimo = ultimo;
    }

    public boolean isEmpty(){
        return ultimo == null;
    }

    public int size(){
        return tamanho;
    }

    public Node parent(Node no){
        return no.getPai();
    }

    public boolean isInternal(Node no)
    {
        return (no.getFilhoEsquerdo() == null || no.getFilhoDireito() == null);
    }

    public boolean isExternal(Node no){
        return (no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null);
    }

    public boolean isRoot(Node no){
        return no == raiz;
    }

    public int depth(Node v){
        if (isRoot(v))
            return 0;
        else
            return 1 + depth(v.getPai());
    }

    private boolean hasLeft(Node no){
        return no.getFilhoEsquerdo() != null;
    }

    private boolean hasRight(Node no){
        return no.getFilhoDireito() != null;
    }

    public int height(Node no){
        if(isExternal(no)){
            return 0;
        }
        else {
            int h1 = 0;
            if (hasLeft(no)){
                h1 = 1 + height(no.getFilhoEsquerdo());
            }
            int h2 = 0;
            if (hasRight(no)) {
                h2 = 1 + height(no.getFilhoDireito());
            }
            return h1 > h2 ? h1 : h2;
        }
    }

    public void insert(Object k){
        Node new_node = new Node(k);
        if(isEmpty()){
            this.raiz.setElemento(k);
            ultimo = raiz;
        }
        else {
            NoInsercao(ultimo);
            ultimo.setElemento(k);
            upHeap(ultimo);
        }
        tamanho++;
    }
//  Vá acima até um filho da esquerda ou a raiz for encontrada
//  Se um filho da esquerda é encontrado, vá para o filho da direita
//  Vá para baixo pela esquerda até encontrar uma folha
    private void NoInsercao(Node no){
        if (no != raiz && no.getPai().getFilhoEsquerdo() != no){
            NoInsercao(no.getPai());
        }
        if (isRoot(no)){
            while (no.getFilhoEsquerdo() != null){
                no = no.getFilhoEsquerdo();
            }
            Node novo_ultimo = new Node();
            novo_ultimo.setPai(no);
            no.setFilhoEsquerdo(novo_ultimo);
            ultimo = novo_ultimo;
        }
        else if (no.getPai().getFilhoEsquerdo() == no){
            Node novo_ultimo = new Node();
            if (no.getPai().getFilhoDireito() == null){
                novo_ultimo.setPai(no.getPai());
                no.getPai().setFilhoDireito(novo_ultimo);
                ultimo = novo_ultimo;
            }
            else {
                Node aux = no.getPai().getFilhoDireito();
                while (!isExternal(aux)) {
                    aux = aux.getFilhoEsquerdo();
                }
                novo_ultimo.setPai(aux);
                aux.setFilhoEsquerdo(novo_ultimo);
                ultimo = novo_ultimo;
            }
        }
    }

    public Object remove(){
        if(isEmpty()) throw new RuntimeException("Empty");
        Object removido = raiz.getElemento();
        if (tamanho == 1){
            raiz = null;
            ultimo = null;
        }
        else {
            if (depth(ultimo) < height(raiz) || tamanho == 3){
                NoRemove(ultimo);
            }
            raiz.setElemento(ultimo.getElemento());
            if (ultimo.getPai().getFilhoDireito() == ultimo){ // é filho direito?
                ultimo.getPai().setFilhoDireito(null);
                ultimo = ultimo.getPai().getFilhoEsquerdo();
            }
            else{ // é filho esquerdo?
                ultimo.getPai().setFilhoEsquerdo(null);
                ultimo = ultimo.getPai();
            }
            tamanho--;
            if (tamanho > 2)downHeap(raiz);

        }
        return removido;
    }

    public void NoRemove(Node no){
        if (no != raiz && no.getPai().getFilhoDireito() != no){
            NoRemove(no.getPai());
        }
        if(isRoot(no)){
            while (no.getFilhoDireito() != null){ // vindo da esquerda total para direita
                no = no.getFilhoDireito();
            }
            ultimo = no;
            if (hasLeft(no)){
                ultimo = no.getFilhoEsquerdo();
            }
        }
        else if(no.getPai().getFilhoDireito() == no){
            Node aux = no.getPai().getFilhoEsquerdo();//passa pro lado esquerdo
            while (!isExternal(aux)){
                aux = aux.getFilhoDireito();
            }
            ultimo = aux;
            if (depth(ultimo) < height(raiz)){
                NoRemove(ultimo);
            }
            if (hasLeft(aux)){
                ultimo = no.getFilhoEsquerdo();
            }
        }
    }

    private void upHeap(Node no){
        if (no == raiz || (int)no.getElemento() >= (int)no.getPai().getElemento()){
            return;
        }
        Object aux = no.getElemento();
        no.setElemento(no.getPai().getElemento());
        no.getPai().setElemento(aux);
        upHeap(no.getPai());
    }

    private void downHeap(Node no){
        if (isExternal(no)){
            return;
        }
        if ((int)no.getElemento() > (int)no.getFilhoEsquerdo().getElemento() || (int)no.getElemento() > (int)no.getFilhoDireito().getElemento()){

            Object aux = no.getElemento();
            if ((int)no.getFilhoEsquerdo().getElemento() < (int)no.getFilhoDireito().getElemento()){
                no.setElemento(no.getFilhoEsquerdo().getElemento());
                no.getFilhoEsquerdo().setElemento(aux);
                downHeap(no.getFilhoEsquerdo());
            }
            else {
                no.setElemento(no.getFilhoDireito().getElemento());
                no.getFilhoDireito().setElemento(aux);
                downHeap(no.getFilhoDireito());
            }
        }
    }

    public void inOrder(Node v){
        if (v != null){
            inOrder(v.getFilhoEsquerdo());
            System.out.println(v.getElemento());
            inOrder(v.getFilhoDireito());
        }
    }

    public void printArvore() {
        ArrayList<Node> lista = new ArrayList<>();
        organizador(raiz, lista);
        System.out.println("A R V O R E:");
        for(int j=0; j <= height(raiz); j++) {
            for(int i = 0; i<size();i++) {
                if(depth(lista.get(i)) == j) {
                    System.out.print("(" + (lista.get(i)).getElemento() + ")");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    private void organizador(Node no,  ArrayList<Node> lista) {
        if(no.getFilhoEsquerdo() != null) {
            organizador(no.getFilhoEsquerdo(),lista);
        }
        lista.add(no);
        if(no.getFilhoDireito() != null) {
            organizador(no.getFilhoDireito(),lista);
        }
    }
}
