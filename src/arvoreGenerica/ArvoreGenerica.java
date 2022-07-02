package arvoreGenerica;

import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreGenerica {

    No raiz;
    int tamanho;

    public ArvoreGenerica(Object o)
    {
        raiz = new No(null, o);
        tamanho = 1;
    }

    public No root()
    {
        return raiz;
    }

    public No parent(No v)
    {
        return (v.parent());
    }

    public Iterator<Object> children(No v)
    {
        return v.children();
    }

    public boolean isInternal(No v)
    {
        return (v.childrenNumber() > 0);
    }

    public boolean isExternal(No v)
    {
        return (v.childrenNumber() == 0);
    }

    public boolean isRoot(No v)
    {
        return v == raiz;
    }

    public void addChild(No v, Object o)
    {
        No novo = new No(v, o);
        v.addChild(novo);
        tamanho++;
    }
    /** Remove um No
     *  S� pode remover Nos externos e que tenham um pai (n�o seja raiz)
     */
    public Object remove(No v) throws InvalidNoException
    {
        No pai = v.parent();
        if (pai != null || isExternal(v))
            pai.removeChild(v);
        else
            throw new InvalidNoException("No invalido");
        Object o = v.element();
        tamanho--;
        return o;
    }

    public void swapElements(No v, No w)
    {
        Object aux = v.element();
        v.setElement(w.element());
        w.setElement(aux);
    }

    public int depth(No v)
    {
        int profundidade = profundidade(v);
        return profundidade;
    }

    private int profundidade(No v)
    {
        if (v == raiz)
            return 0;
        else
            return 1 + profundidade(v.parent());
    }
    /** Retorna a altura da �rvore */
    public int height(No v)
    {
       if(isExternal(v)){
           return  0;
       }
       else {
           int h = 0;
           for (Iterator<Object> it = v.children(); it.hasNext(); ) {
               No w = (No) it.next();
               if (h < height(w)){
                   h = height(w);
               }
           }
           return 1+h;
       }
    }
    /** Retorna um iterator com os elementos armazenados na �rvore */
    public Iterator elements()
    {
        return auxElements(raiz);
    }
    /** Retorna um iterator com as posi��es (Nos) da �rvore */
    public Iterator Nos()
    {
        return auxNos(raiz);
    }

    public int size()
    {
        return tamanho;
    }
    /** Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos remover a raiz
     */
    public boolean isEmpty()
    {
        return false;
    }

    public Object replace(No v, Object o)
    {
        Object aux = v.element();
        v.setElement(o);
        return aux;
    }

    private Iterator auxElements(No v) {
        ArrayList<Object> aux_elements = new ArrayList<>();
        if (isRoot(v)){
            aux_elements.add(v.element());
        }
        for (Iterator<Object> it = v.children(); it.hasNext(); ) {
            No w = (No) it.next();
            aux_elements.add(w.element());
            auxElements(w);
        }
        return aux_elements.iterator();
    }

    private Iterator auxNos(No v) {
        ArrayList<Object> aux_nos = new ArrayList<>();
        if (isRoot(v)){
            aux_nos.add(v);
        }
        for (Iterator<Object> it = v.children(); it.hasNext(); ) {
            No w = (No) it.next();
            aux_nos.add(w);
            auxNos(w);
        }
        return aux_nos.iterator();
    }
}
