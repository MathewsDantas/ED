package fila;


public class testeFila {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FilaArray f = new FilaArray(1,0); //criando fila tamnho 1 e duplicação

        f.enqueue(10);
        f.enqueue(20);
        f.enqueue(30);
        f.dequeue();
        f.enqueue(40);
        f.enqueue(50);
        f.enqueue(12);
        f.print();
    }
}

