package RubroNegra;


import java.util.ArrayList;

public class ArvoreRubroNegra {

    public static No raiz;
    public int size;

    public ArvoreRubroNegra(){

    }

    public ArvoreRubroNegra(Object v){
        raiz = new No(v);
        raiz.ehRubro(false);
        size = 1;
    }

    public No root()
    {
        return raiz;
    }

    public boolean isInternal(No v)
    {
        return (v.getFilhoEsquerdo() != null || v.getFilhoDireito() != null);
    }

    public boolean isExternal(No v)
    {
        return (v.getFilhoEsquerdo() == null && v.getFilhoDireito() == null);
    }

    protected static boolean hasLeft(No v){
        return v.getFilhoEsquerdo() != null;
    }

    protected static boolean hasRight(No v){
        return v.getFilhoDireito() != null;
    }

    public boolean isRoot(No v)
    {
        return v == raiz;
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

    public int depth(No v) {
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
        if (no != raiz){
            if (no == no.getPai().getFilhoDireito()){
                no.getPai().setFilhoDireito(novoPai);
            }
            else {
                no.getPai().setFilhoEsquerdo(novoPai);
            }
            novoPai.setPai(no.getPai());
        }
        else { // o novoPai será a nova raíz
            raiz = novoPai;
        }
        no.setPai(novoPai);
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
        if (no != raiz){
            if (no == no.getPai().getFilhoDireito()){
                no.getPai().setFilhoDireito(novoPai);
            }
            else {
                no.getPai().setFilhoEsquerdo(novoPai);
            }
            novoPai.setPai(no.getPai());
        }
        else { // o novoPai será a nova raíz
            raiz = novoPai;
        }
        no.setPai(novoPai);

    }

    public void insert (Object v){

        if (size() == 0) {
            raiz = new No(v);
        }
        No aux = find(v, raiz);
        No novo = new No();
        novo.setElemento(v);
        if ( (int) v <= (int) aux.getElemento()){
            novo.setPai(aux);
            aux.setFilhoEsquerdo(novo);
            checkInsert(novo);
        }
        else {
            novo.setPai(aux);
            aux.setFilhoDireito(novo);
            checkInsert(novo);
        }
        size++;
    }

    public void checkInsert(No novo) {
        No tio = null;
        while (novo.getPai().isRubro()) {

            if (novo.getPai() == novo.getPai().getPai().getFilhoEsquerdo()) { // Verifica se é filho esquerdo
                tio = novo.getPai().getPai().getFilhoDireito(); // tio

                if (tio != null && tio.isRubro()){ // se tio é rubro -> caso 2
                    novo.getPai().ehRubro(false); // pai passa a ser negro
                    tio.ehRubro(false); // tio passa a ser negro
                    novo.getPai().getPai().ehRubro(true);
                    novo = novo.getPai().getPai(); // condiçao para continuar, pois caso o avó tenha sido negro anteriormento deve ser feita uma nova checagem
                }
                else { // tio negro
                    if (novo == novo.getPai().getFilhoDireito()) { // Verifica se é filho direito 3c
                        // dps da rotação o pai do novo passará a ser o filho do novo
                        No paiDoNovo = novo.getPai();
                        leftRotation(paiDoNovo);
                        novo = paiDoNovo;
                    }
                    novo.getPai().ehRubro(false);
                    novo.getPai().getPai().ehRubro(true);
                    No avo = novo.getPai().getPai();
                    rightRotation(avo); // 3a
                    No root = root();
                }
            }
            else {
                tio = novo.getPai().getPai().getFilhoEsquerdo();

                if (tio != null && tio.isRubro()) { // se tio é rubro -> caso 2
                    novo.getPai().ehRubro(false);
                    tio.ehRubro(false);
                    novo.getPai().getPai().ehRubro(true);
                    novo = novo.getPai().getPai(); // condiçao para continuar, pois caso o avó tenha sido negro anteriormento deve ser feita uma nova checagem
                }
                else {
                    if (novo == novo.getPai().getFilhoEsquerdo()) { // 3d
                        No paiDoNovo = novo.getPai();
                        rightRotation(paiDoNovo);
                        novo = paiDoNovo;
                    }
                    novo.getPai().ehRubro(false);
                    novo.getPai().getPai().ehRubro(true);
                    No avo = novo.getPai().getPai();
                    leftRotation(avo); // 3b
                    No root = root();
                }
            }
        }
        root().ehRubro(false);
    }

    public void printArvore() {
        ArrayList<No> lista = new ArrayList<>();
        organizador(raiz, lista);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("A R V O R E:");
        for(int j=0; j <= height(raiz); j++) {
            for(int i = 0; i<size();i++) {
                if(depth(lista.get(i)) == j) {
                    if ((lista.get(i)).isRubro()) {
                        System.out.print("(" + (lista.get(i)).getElemento() + ")" + "[R]");
                    } else {
                        System.out.print("(" + (lista.get(i)).getElemento() + ")" + "[N]");
                    }
                }
                else {
                    System.out.print("     ");
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
