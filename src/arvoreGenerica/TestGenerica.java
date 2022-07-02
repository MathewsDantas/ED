package arvoreGenerica;

import java.util.Iterator;

public class TestGenerica {
    public static void main(String[] args) {
        // Console.WriteLine ("Hello World");
        ArvoreGenerica simples = new ArvoreGenerica(1);
        simples.addChild(simples.root(), 2);
        simples.addChild(simples.root(), 3);
        simples.addChild(simples.root(), 4);
        simples.addChild(simples.root(), 5);

        Iterator<Object> Filhos = simples.children(simples.root());

        while (Filhos.hasNext()) {
            No x = (No) Filhos.next();
            int z = (int) x.element();
            System.out.println(">" + z);
        }

        System.out.println("Altura: "+simples.height(simples.raiz));
        No w = null;
        //adicionando filhos aos filhos da raíz
        for (Iterator<Object> it = simples.children(simples.root()); it.hasNext();){
            w = (No) it.next();
            simples.addChild(w,10);
        }
        System.out.println("Profundidade da raíz: "+simples.depth(simples.root()));
        System.out.println("Profundidade do filho da raiz: "+simples.depth(w));
        System.out.println("Nova Altura: "+simples.height(simples.raiz));
        System.out.println("Elemento da raiz: ");
        System.out.println(simples.root().element());

    }
}
