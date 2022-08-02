package hash;

public class TestHash {
    public static void main(String[] args) {
        Hash hash = new Hash(5);

        System.out.println(hash.isEmpty());

        hash.insert(2);
        hash.print();
        hash.insert(12);
        hash.print();
        hash.insert(10);
        hash.print();
        hash.insert(5);
        hash.print();
        hash.insert(11);
        hash.print();
        hash.insert(21);
        hash.print();
        hash.insert(8);
        hash.print();
        hash.insert(18);
        hash.print();

        System.out.println("Removido: "+hash.remove(5));
        hash.print();

        System.out.println("Size: "+ hash.size());

    }

}
