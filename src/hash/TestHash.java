package hash;

public class TestHash {
    public static void main(String[] args) {
        HashLinearProbing hash = new HashLinearProbing(1);

        System.out.println(hash.isEmpty());

        hash.insert(10);
        hash.print();
        hash.insert(14);
        hash.print();
        hash.insert(18);
        hash.print();
        hash.insert(5);
        hash.print();


        System.out.println("Removido: "+hash.remove(5));
        hash.print();
        hash.insert(5);
        hash.print();
        System.out.println("Size: "+ hash.size());

    }

}
