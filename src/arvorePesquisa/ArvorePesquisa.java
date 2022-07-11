package arvorePesquisa;


import java.util.ArrayList;

public class ArvorePesquisa {

    private No root;
    private int size;

    public ArvorePesquisa() {
    }

    public ArvorePesquisa(Object key) {
        root = new No(key);
        size = 1;
    }

    public No root()
    {
        return root;
    }

    public boolean isInternal(No v)
    {

        return (v.getFilhoEsquerdo() == null || v.getFilhoDireito() == null);
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
            if (hasLeft(aux)){
                aux.getFilhoEsquerdo().setPai(v);
                if ((int) aux.getFilhoEsquerdo().getElemento() <= (int) k){
                    v.setFilhoEsquerdo(aux.getFilhoEsquerdo());
                }
                else {
                    v.setFilhoDireito(aux.getFilhoEsquerdo());
                }
            }
            else {
                v.setPai(aux);
            }
            aux.setFilhoEsquerdo(v);
        }
        else {
            if (hasRight(aux)){
                aux.getFilhoDireito().setPai(v);
                if ((int) aux.getFilhoDireito().getElemento() > (int) k){
                    v.setFilhoDireito(aux.getFilhoDireito());
                }
                else {
                    v.setFilhoEsquerdo(aux.getFilhoDireito());
                }
            }
            else {
                v.setPai(aux);
            }
            aux.setFilhoDireito(v);
        }
        size++;
    }

    public void remove(Object k){
        No aux = find(k, root);
        if (isExternal(aux)){
            if (aux.getPai().getFilhoEsquerdo() == aux){
                aux.getPai().setFilhoEsquerdo(null);
            }
            else {
                aux.getPai().setFilhoDireito(null);
            }
        }
        else if ( aux.getFilhoEsquerdo() == null){
            if (aux.getPai().getFilhoEsquerdo() == aux){
                aux.getPai().setFilhoEsquerdo(aux.getFilhoDireito());
                aux.getFilhoDireito().setPai(aux.getPai());
            }
            else if(aux.getPai().getFilhoDireito() == aux){
                aux.getPai().setFilhoDireito(aux.getFilhoDireito());
                aux.getFilhoDireito().setPai(aux.getPai());
            }
        }
        else if( aux.getFilhoDireito() == null){
            if (aux.getPai().getFilhoEsquerdo() == aux){
                aux.getPai().setFilhoEsquerdo(aux.getFilhoEsquerdo());
                aux.getFilhoEsquerdo().setPai(aux.getPai());
            }
            else if(aux.getPai().getFilhoDireito() == aux){
                aux.getPai().setFilhoDireito(aux.getFilhoEsquerdo());
                aux.getFilhoEsquerdo().setPai(aux.getPai());
            }

        }
        else { // v possui os 2 filhos.
            No min;
            min = aux;
            min = min.getFilhoDireito();
            while (min.getFilhoEsquerdo() != null){ //encontrar o menor a direita
                min = min.getFilhoEsquerdo();
            }
            size++;
            remove(min.getElemento());
            aux.setElemento(min.getElemento());
        }
        size--;
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

    /*public void mostraArvore(No a, int b) {
        if (a == null) {
            return;
        }
        mostraArvore(a.getFilhoDireito(), b+1);
        imprimeNo(a.getElemento(), b);
        mostraArvore(a.getFilhoEsquerdo(), b+1);
    }

    private void imprimeNo(Object c, int b) {
        int i;
        for (i = 0; i < b; i++) System.out.print("   ");
        System.out.print("" + c + "\n");
    }*/

    public void printArvore()
    {
        int h = height(root);
        double totalNos= Math.pow(2, 4);
        for (int i = 0; i <= h; i++){
            ArrayList<Object> lista = new ArrayList<>();
            printProfunAtual(root, i, lista);
            for (int j = 0; j < (totalNos*3)/(lista.size()+1); j++) {//antes do primeiro elemento da profundidade.
                System.out.print(" ");
            }
            for (int k = 0; k<lista.size(); k++) {
                if (lista.get(k) == "*" && i<h){
                    System.out.print("*");
                }else if(lista.get(k) != "*"){
                    System.out.print("("+lista.get(k)+")");// por esse motivo mult por 3 lá em cima.
                }
                for (int j = 0; j < ((totalNos*2)/(lista.size()+1))+1; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private void printProfunAtual(No root, int prof, ArrayList<Object> lista)
    {
        if (root == null && prof >0){
            for (int i = 0; i<prof; i++){
                lista.add("*");
                lista.add("*");
            }
        }
        if (root == null && prof == 0){
            lista.add("*");
        }
        if (root == null)// verificar folhas
            return;
        if (prof == 0)
            lista.add(root.getElemento());
        else if (prof > 0) {
            printProfunAtual(root.getFilhoEsquerdo(), prof - 1, lista);
            printProfunAtual(root.getFilhoDireito(), prof - 1, lista);
        }
    }
}

