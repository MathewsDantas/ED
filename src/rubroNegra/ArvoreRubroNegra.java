package rubroNegra;


import java.util.ArrayList;

public class ArvoreRubroNegra extends ArvorePesquisa{


    public ArvoreRubroNegra() {
        super();
    }

    public ArvoreRubroNegra(Object v) {
        super(v);
        super.root().ehRubro(false);
    }

    protected static boolean hasLeft(No v) {
        return v.getFilhoEsquerdo() != null;
    }

    protected static boolean hasRight(No v) {
        return v.getFilhoDireito() != null;
    }

    public void rightRotation(No no) {
        No novoPai = no.getFilhoEsquerdo();
        if (hasRight(novoPai)) {
            no.setFilhoEsquerdo(novoPai.getFilhoDireito());
            no.getFilhoEsquerdo().setPai(no);
            novoPai.setFilhoDireito(no);
        } else {
            novoPai.setFilhoDireito(no);
            no.setFilhoEsquerdo(null);
        }
        if (no != super.root()) {
            if (no == no.getPai().getFilhoDireito()) {
                no.getPai().setFilhoDireito(novoPai);
            } else {
                no.getPai().setFilhoEsquerdo(novoPai);
            }
            novoPai.setPai(no.getPai());
        } else { // o novoPai será a nova raíz
            root = novoPai;
        }
        no.setPai(novoPai);
    }

    public void leftRotation(No no) {
        No novoPai = no.getFilhoDireito();
        if (hasLeft(novoPai)) {
            no.setFilhoDireito(novoPai.getFilhoEsquerdo());
            no.getFilhoDireito().setPai(no);
            novoPai.setFilhoEsquerdo(no);
        } else {
            novoPai.setFilhoEsquerdo(no);
            no.setFilhoDireito(null);
        }
        if (no != super.root()) {
            if (no == no.getPai().getFilhoDireito()) {
                no.getPai().setFilhoDireito(novoPai);
            } else {
                no.getPai().setFilhoEsquerdo(novoPai);
            }
            novoPai.setPai(no.getPai());
        } else { // o novoPai será a nova raíz
            root = novoPai;
        }
        no.setPai(novoPai);

    }

    public No insert(Object v) {
        System.out.println(size);
        if (size() == 0) {
            root = new No(v);
        }
        No aux = find(v, super.root());
        No novo = new No();
        novo.setElemento(v);
        System.out.println(aux.getElemento());
        System.out.println(v);
        if ((int) v <= (int) aux.getElemento()) {
            novo.setPai(aux);
            aux.setFilhoEsquerdo(novo);
            checkInsert(novo);
        } else {
            novo.setPai(aux);
            aux.setFilhoDireito(novo);
            checkInsert(novo);
        }
        size++;
        return novo;
    }

    public void checkInsert(No novo) {
        No tio = null;
        while (novo.getPai().isRubro()) {

            if (novo.getPai() == novo.getPai().getPai().getFilhoEsquerdo()) { // Verifica se é filho esquerdo
                tio = novo.getPai().getPai().getFilhoDireito(); // tio

                if (tio != null && tio.isRubro()) { // se tio é rubro -> caso 2
                    novo.getPai().ehRubro(false); // pai passa a ser negro
                    tio.ehRubro(false); // tio passa a ser negro
                    novo.getPai().getPai().ehRubro(true);
                    novo = novo.getPai().getPai(); // condiçao para continuar, pois caso o avó tenha sido negro anteriormento deve ser feita uma nova checagem
                } else { // tio negro
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
            } else {
                tio = novo.getPai().getPai().getFilhoEsquerdo();

                if (tio != null && tio.isRubro()) { // se tio é rubro -> caso 2
                    novo.getPai().ehRubro(false);
                    tio.ehRubro(false);
                    novo.getPai().getPai().ehRubro(true);
                    novo = novo.getPai().getPai(); // condiçao para continuar, pois caso o avó tenha sido negro anteriormento deve ser feita uma nova checagem
                } else {
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

        root.ehRubro(false);
    }


    public void remove(Object k) {
        No aux = find(k, super.root());
        boolean antigo_cor = aux.isRubro(); // cor de quem eu removi
        boolean sucessor_cor = false;
        boolean ehFilhoEsquedo = false;
        No sucessor_CheckRemove = null;
        No paiDoSucessor = null;

        if (k != aux.getElemento()) {
            System.out.println("O Node com a chave " + k + " nao existe!");
        } else {
            if (isExternal(aux)) {
                if (aux.getPai().getFilhoEsquerdo() == aux) {
                    aux.getPai().setFilhoEsquerdo(null);
                } else {
                    aux.getPai().setFilhoDireito(null);
                }
            } else if (aux.getFilhoEsquerdo() == null) { //verifica se o aux tem filho direito
                sucessor_CheckRemove = aux.getFilhoDireito(); // sucessor
                paiDoSucessor = aux.getFilhoDireito();
                sucessor_cor = sucessor_CheckRemove.isRubro();
                if (aux.getPai().getFilhoEsquerdo() == aux) { // verifica se é filho esquerdo
                    aux.getPai().setFilhoEsquerdo(aux.getFilhoDireito());
                    aux.getFilhoDireito().setPai(aux.getPai());
                } else if (aux.getPai().getFilhoDireito() == aux) {
                    aux.getPai().setFilhoDireito(aux.getFilhoDireito());
                    aux.getFilhoDireito().setPai(aux.getPai());
                }
            } else if (aux.getFilhoDireito() == null) {
                sucessor_CheckRemove = aux.getFilhoEsquerdo(); // sucessor
                paiDoSucessor = aux.getFilhoEsquerdo();
                sucessor_cor = sucessor_CheckRemove.isRubro();
                if (aux.getPai().getFilhoEsquerdo() == aux) {
                    aux.getPai().setFilhoEsquerdo(aux.getFilhoEsquerdo());
                    aux.getFilhoEsquerdo().setPai(aux.getPai());
                } else if (aux.getPai().getFilhoDireito() == aux) {
                    aux.getPai().setFilhoDireito(aux.getFilhoEsquerdo());
                    aux.getFilhoEsquerdo().setPai(aux.getPai());
                }

            } else { // v possui os 2 filhos.
                No min;
                min = aux;
                min = min.getFilhoDireito();
                while (min.getFilhoEsquerdo() != null) { //encontrar o menor a direita
                    min = min.getFilhoEsquerdo();
                }
                // sucessor_CheckRemove = min.getPai();
                if (min == min.getPai().getFilhoEsquerdo()) {
                    ehFilhoEsquedo = true;
                }
                paiDoSucessor = min.getPai();
                sucessor_cor = min.isRubro();
                size++;
                remove(min.getElemento());
                aux.setElemento(min.getElemento());
                sucessor_CheckRemove = aux; // sucessor - já está no lugar certo
            }
            size--;

            // Se o antigo e o sucessor forem rubros nd precisa ser feito
            if (sucessor_CheckRemove != null){
                CheckRemove(sucessor_CheckRemove, paiDoSucessor, sucessor_cor, antigo_cor, ehFilhoEsquedo);
            }

        }
    }

    public void CheckRemove(No novo,No paiDoSucessor, boolean cor_sucessor, boolean cor_antigo, boolean ehFilhoEsquerdo) {
        No irmao = null;
        No aux = null;

        if (ehFilhoEsquerdo) {
            irmao = paiDoSucessor.getFilhoDireito();
            aux = paiDoSucessor.getFilhoDireito();
        }
        else {
            irmao = paiDoSucessor.getFilhoEsquerdo();
            aux = paiDoSucessor.getFilhoEsquerdo();
        }

        if (!cor_antigo && !cor_sucessor ) { // Se o no sucessor e o antigo forem negros, executa
            while (novo != super.root() && !novo.isRubro()) {
                if (novo == novo.getPai().getFilhoEsquerdo()) {

                    if (irmao != null && irmao.isRubro()) { // situação 3 - Caso 1
                        irmao.ehRubro(false);
                        novo.getPai().ehRubro(true);
                        leftRotation(novo.getPai());
                        irmao = novo.getPai().getFilhoDireito();
                    } // A partir daqui poodemos considerar o 'irmao' como sendo negro, visto que n entrou no primeiro If
                    if (irmao != null &&
                            ((irmao.getFilhoEsquerdo() == null && irmao.getFilhoDireito() == null) ||
                                    (!irmao.getFilhoEsquerdo().isRubro() && !irmao.getFilhoDireito().isRubro()))) { // situação 3 - Caso 2
                        if (!novo.getPai().isRubro()) { // Caso 2a
                            irmao.ehRubro(true);
                        } else { // Caso 2b
                            irmao.ehRubro(true);
                            novo.getPai().ehRubro(false);
                        }
                        novo = aux.getPai();
                        aux = novo;
                        irmao = novo.getPai().getFilhoDireito();
                        System.out.println(irmao.getElemento());
                    } else {
                        if (irmao.getFilhoEsquerdo().isRubro() && !irmao.getFilhoDireito().isRubro()) { // Então o esquerdo é rubro - Situação 3 - Caso3
                            irmao.getFilhoEsquerdo().ehRubro(false);
                            irmao.ehRubro(true);
                            rightRotation(irmao);
                            irmao = novo.getPai().getFilhoDireito();
                        }
                        if (irmao.getFilhoDireito().isRubro()) {// Então o filho direito é rubro - Situação 3 - Caso4
                            irmao.ehRubro(novo.getPai().isRubro());
                            novo.getPai().ehRubro(false);
                            irmao.getFilhoDireito().ehRubro(false);
                            leftRotation(novo.getPai());
                            novo = aux.getPai();
                            aux = novo;
                        }
                    }
                } else {

                    if (irmao != null) {

                        if (irmao.isRubro()) { // situação 3 - Caso 1
                            irmao.ehRubro(false);
                            novo.getPai().ehRubro(true);
                            rightRotation(novo.getPai());
                            if (novo.getPai().getFilhoEsquerdo() != null) {
                                irmao = novo.getPai().getFilhoEsquerdo();
                            }
                        }
                        if ((irmao.getFilhoEsquerdo() == null && irmao.getFilhoDireito() == null) ||
                                (!irmao.getFilhoEsquerdo().isRubro() && !irmao.getFilhoDireito().isRubro())) { // situação 3 - Caso 2
                            if (!novo.getPai().isRubro()) { // Caso 2a
                                irmao.ehRubro(true);
                            } else { // Caso 2b
                                irmao.ehRubro(true);
                                novo.getPai().ehRubro(false);
                            }
                            novo = aux.getPai();
                            aux = novo;
                            irmao = novo.getPai().getFilhoDireito();

                        } else {
                            if (!irmao.getFilhoEsquerdo().isRubro() && irmao.getFilhoDireito().isRubro()) { // Então o direito é rubro - Situação 3 - Caso3
                                irmao.getFilhoDireito().ehRubro(false);
                                irmao.ehRubro(true);
                                leftRotation(irmao);
                                irmao = novo.getPai().getFilhoEsquerdo();

                            }
                            if (irmao.getFilhoEsquerdo().isRubro()) {// Então o filho esquerdo é rubro - Situação 3 - Caso4
                                irmao.ehRubro(novo.getPai().isRubro());
                                novo.getPai().ehRubro(false);
                                irmao.getFilhoEsquerdo().ehRubro(false);
                                rightRotation(novo.getPai());
                                novo = aux.getPai();
                                aux = novo;
                            }
                        }
                    }
                }
            }
        }
        novo.ehRubro(false); // situação 2 e em casos restritos pinta a raiz por garantia

    }

        public void printArvore () {
            final String ANSI_RED = "\u001B[31m";
            final String ANSI_RESET = "\u001B[0m";
            ArrayList<No> lista = new ArrayList<>();
            organizador(super.root(), lista);
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("A R V O R E:");
            for (int j = 0; j <= height(super.root()); j++) {
                for (int i = 0; i < size(); i++) {
                    if (depth(lista.get(i)) == j) {
                        if ((lista.get(i)).isRubro()) {
                            System.out.print(ANSI_RED + "(" + (lista.get(i)).getElemento() + ")" + "[R]" + ANSI_RESET);
                        } else {
                            System.out.print("(" + (lista.get(i)).getElemento() + ")" + "[N]");
                        }
                    } else {
                        System.out.print("     ");
                    }
                }
                System.out.println();
            }
        }

        private void organizador (No no, ArrayList < No > lista){
            if (no.getFilhoEsquerdo() != null) {
                organizador(no.getFilhoEsquerdo(), lista);
            }
            lista.add(no);
            if (no.getFilhoDireito() != null) {
                organizador(no.getFilhoDireito(), lista);
            }
        }


}
