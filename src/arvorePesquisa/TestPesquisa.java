package arvorePesquisa;

public class TestPesquisa {
    public static void main(String[] args) {

        ArvorePesquisa arvore = new ArvorePesquisa(5);
        No newnode = new No();
        arvore.insert(2);
        arvore.insert(4);
        arvore.insert(7);
        arvore.insert(6);
        arvore.insert(9);
        arvore.insert(8);
        arvore.insert(1);
        arvore.insert(3);


        System.out.println("Size: "+arvore.size());
        System.out.println("Root: "+arvore.root().getElemento());

        System.out.println("preOrder: ");
        arvore.preOrder(arvore.root());
        System.out.println("inOrder: ");
        arvore.inOrder(arvore.root());
        System.out.println("posOrder: ");
        arvore.posOrder(arvore.root());

        //System.out.println("esquerdo: "+arvore.root().getFilhoEsquerdo().getElemento());
        //System.out.println("direito: "+arvore.root().getFilhoDireito().getElemento());

        //System.out.println("Profundidade da chave 9: "+arvore.depth(arvore.root().getFilhoDireito().getFilhoEsquerdo().getFilhoDireito().getFilhoDireito()));
        arvore.printArvore();
        System.out.println("Altura da arvore: "+arvore.height(arvore.root()));
        arvore.remove(3);
        arvore.remove(8);
        //arvore.remove(10);
        arvore.remove(5);
        arvore.printArvore();
        System.out.println("Altura da arvore: "+arvore.height(arvore.root()));
        System.out.println("Size: "+arvore.size());
    }
}
