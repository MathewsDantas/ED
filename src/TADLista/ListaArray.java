package TADLista;


public class ListaArray implements ILista{

    private Object[] list;
    private int capacity;
    private int header;
    private int trailer;

    ListaArray(int capacity){
        this.capacity = capacity;
        this.header = 0;
        this.trailer = -1;
        this.list = new Object[capacity];
    }

    @Override
    public int size() {
        return trailer+1;
    }

    @Override
    public boolean isEmpty() {
        return trailer == -1;
    }

    @Override
    public boolean isFirst(int p) throws ListaVaziaException {
        if (p < 0 || p > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        return p == header;
    }

    @Override
    public boolean isLast(int p) throws ListaVaziaException {
        if (p < 0 || p > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        return p == trailer;
    }

    @Override
    public Object first() {
        return list[header];
    }

    @Override
    public Object last() {
        return list[trailer];
    }

    @Override
    public Object before(int p) throws ListaVaziaException {
        if (p < 0 || p > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        return list[p-1];
    }

    @Override
    public Object after(int p) throws ListaVaziaException {
        if (p < 0 || p > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        return list[p+1];
    }

    @Override
    public Object insertBefore(int p, Object o) throws ListaVaziaException {
        if (p < 0 || p > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        if(size() >= capacity){
            capacity*=2;
            Object[] new_list = new Object[capacity];
            for (int i = 0; i < size(); i++){
                new_list[i] = list[i];
            }
            list = new_list;
        }
        if (p < size()){
            for (int i = size(); i >= p; i--){
                list[i] = list[i - 1];
            }
        }
        list[p-1] = o;
        trailer++;
        return list[p-1];
    }

    @Override
    public Object insertAfter(int p, Object o) throws ListaVaziaException {
        if (p < 0 || p > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        if(size() >= capacity){
            capacity*=2;
            Object[] new_list = new Object[capacity];
            for (int i = 0; i < size(); i++){
                new_list[i] = list[i];
            }
            list = new_list;
        }
        if (p < size()){
            for (int i = size(); i > (p+1); i--){
                list[i] = list[i - 1];
            }
        }
        list[p+1] = o;
        trailer++;
        return list[p+1];
    }

    @Override
    public Object insertFirst(Object o) {
        if (size() == 0){
            list[header] = o;
        }
        else {
            if(size() >= capacity){
                capacity*=2;
                Object[] new_list = new Object[capacity];
                for (int i = 0; i < size(); i++){
                    new_list[i] = list[i];
                }
                list = new_list;
            }
            for (int i = size(); i > header; i--){
                list[i] = list[i - 1];
            }
            list[header] = o;
        }
        trailer++;
        return list[header];
    }

    @Override
    public Object insertLast(Object o) {
        if (size() == 0){
            list[header] = o;
        }
        else {
            if(size() >= capacity){
                capacity*=2;
                Object[] new_list = new Object[capacity];
                for (int i = 0; i < size(); i++){
                    new_list[i] = list[i];
                }
                list = new_list;
            }
            list[size()] = o;
        }
        trailer++;
        return list[trailer];
    }

    @Override
    public Object remove(int p) throws ListaVaziaException {
        if (p < 0 || p > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        Object element = list[p];
        for (int i = p; i < size()-1 ; i++){
            list[i] = list[i+1];
        }
        trailer--;
        return element;
    }

    @Override
    public Object replaceElement(int p, Object o) throws ListaVaziaException {
        if (p < 0 || p > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        Object old_element = list[p];
        list[p] = o;
        return old_element;
    }

    @Override
    public void swapElements(int p1, int p2) throws ListaVaziaException {
        if (p1 < 0 || p1 > trailer || p2 < 0 || p2 > trailer){
            throw new ListaVaziaException("Fora do limite");
        }
        if (isEmpty()) {
            throw new ListaVaziaException("Vazio");
        }
        Object element1 = list[p1];
        list[p1] = list[p2];
        list[p2] = element1;
    }

    public void print(){
        System.out.println("----------------------------------------");
        for (int i = 0; i < size(); i++){
            System.out.println("Position: "+i+" Valor: "+list[i]);
        }
        System.out.println("----------------------------------------");
    }
}
