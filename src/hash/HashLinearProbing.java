package hash;

public class HashLinearProbing {

    private Object[] hash;
    private int cap_array;
    private int n; /* quantidade de elementos no array */

    public HashLinearProbing(){

    }

    public HashLinearProbing(int tam){
        this.cap_array = tam;
        this.n = 0;
        this.hash = new Object[cap_array];
    }

    public int funcaoHash(Object c){
        return ((int)c % cap_array);
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    public void insert(Object c){
        int indice = funcaoHash(c);
        boolean x = false;
        boolean add = false;
        while (hash[indice] != null) {
            indice++;
            indice = indice%(cap_array);
            if (n == cap_array)
            {
                int new_cap = cap_array * 2;
                Object[] hash_aux = new Object[new_cap];
                for (int i = 0; i < cap_array; i++) {
                    if (hash[i] != null) {
                        int ind_aux = (int) hash[i] % new_cap;
                        while (hash_aux[ind_aux] != null) {
                            ind_aux++;
                            ind_aux = ind_aux%new_cap;
                        }
                        hash_aux[ind_aux] = hash[i];
                    }
                }
                hash = hash_aux;
                cap_array = new_cap;
                if (!add) {
                    insert(c);
                    add = true;
                }
                x = true;
            }
        }
        if (!x) {
            hash[indice] = c;
            n++;
        }
    }

    public Object remove(Object c){
        int indice = funcaoHash(c);
        Object aux;
        while (hash[indice] != null){
            if (hash[indice] == c){
                aux = hash[indice];
                hash[indice] = null;
                n--;
                return aux;
            }
            indice++;
            indice = indice%cap_array;
        }
        return null;
    }

    public Object find(Object c){
        int indice = funcaoHash(c);
        while (hash[indice] != null){
            if (hash[indice] == c){
                return hash[indice];
            }
            indice++;
            indice = indice%cap_array;
        }
        return null;
    }

    public void print(){
        for (int i=0; i<cap_array; i++){
            if (hash[i] != null){
                System.out.print("i"+i+":"+hash[i]+" ");
            }
        }
        System.out.println();
    }
}
