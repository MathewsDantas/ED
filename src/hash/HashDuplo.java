package hash;

public class HashDuplo {
    private Object[] hash;
    private int cap_array;
    private int n; /* quantidade de elementos no array */

    public HashDuplo(){

    }

    public HashDuplo(int tam){
        this.cap_array = tam;
        this.n = 0;
        this.hash = new Object[cap_array];
    }

    public int funcaoHash(Object c, int new_cap,int mult){
        return ((int)c +(mult*funcaoHashDuplo(c)))% new_cap;
    }

    public int funcaoHashDuplo(Object c){
        int aux = (3 - (int)c) % 3;
        if(aux == 0) {
            return 1;
        } else {
            return aux;
        }
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    public int VerificaCapacidadePrimo(int capacidade)
    {
        int new_cap = capacidade*2;
        while (!ehPrimo(new_cap)){
            new_cap++;
        }
        return new_cap;
    }

    private boolean ehPrimo(int capacidade){
        for (int j =2; j < capacidade/2; j++){
            if (capacidade % j == 0){
                return false;
            }
        }
        return true;
    }

    public void insert(Object c){
        int mult =0;
        int indice = funcaoHash(c, cap_array, mult);
        boolean x = false;
        boolean add = false; // já adicionou o numero na primeira vez que dobrou.
        while (hash[indice] != null && hash[indice] != "AV") {
            mult++;
            indice = funcaoHash(c, cap_array, mult);
            if (n == cap_array-1)
            {
                int new_cap = VerificaCapacidadePrimo(cap_array);
                Object[] hash_aux = new Object[new_cap];
                for (int i = 0; i < cap_array; i++) {
                    if (hash[i] != null) {
                        mult = 0;
                        int ind_aux = funcaoHash(hash[i],new_cap,mult);
                        while (hash_aux[ind_aux] != null) {
                            mult++;
                            ind_aux = funcaoHash(hash[i],new_cap,mult);
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
        int mult =0;
        int indice = funcaoHash(c, cap_array, mult);
        Object aux;
        while (hash[indice] != null){
            if (hash[indice] == c){
                aux = hash[indice];
                hash[indice] = "AV";
                n--;
                return aux;
            }
            mult++;
            indice = funcaoHash(c,cap_array,mult);
        }
        return null;
    }

    public Object find(Object c){
        int mult =0;
        int indice = funcaoHash(c, cap_array, mult);
        while (hash[indice] != null){
            if (hash[indice] == c){
                return hash[indice];
            }
            mult++;
            indice = funcaoHash(c,cap_array,mult);
        }
        return null;
    }

    public void print(){
        for (int i=0; i<cap_array; i++){
            if (hash[i] != null && hash[i] != "AV"){
                System.out.print("i"+i+":"+hash[i]+" ");
            }
        }
        System.out.println();
    }
}
