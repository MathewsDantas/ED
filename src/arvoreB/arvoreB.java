package arvoreB;

public class arvoreB {

    No raiz;
    int tamanho;

    public arvoreB(Object o){
        raiz.setChave(o);
    }

    public No raiz()
    {
        return raiz;
    }

    public No busca(Object chave, No no){
        int i = 0;

        while ( i < no.getChaves().size() &&
                (int) chave > (int) no.getChaves().get(i)) {
                i++;
        }
        if ( chave == no.getChaves().get(i) ) {
            return no;
        }
        // Sempre 1 filho a mais q as chaves
        else if (no.getFilhos().get(i) != null) {
            busca(chave, no.getFilhos().get(i));
        }

        return no; // Nó folha
    }

    public void insere(Object chave) {
        No no = busca(chave, raiz());
        int i = 0;

        while (i < no.getChaves().size() &&
                (int) chave > (int) no.getChaves().get(i)) {
            i++;
        }
        no.setChave(chave); // adicionar entre
    }
}
