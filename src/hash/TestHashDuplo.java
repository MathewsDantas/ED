package hash;

public class TestHashDuplo {
    public static void main(String[] args) {

        HashDuplo hash = new HashDuplo(7);


        System.out.println(hash.isEmpty());

        hash.insert(10);
        hash.print();
        hash.insert(14);
        hash.print();
        hash.insert(12);
        hash.print();
        hash.insert(3);
        hash.print();

        hash.remove(10);
        hash.print();


        System.out.println("Size: "+ hash.size());
    }
}
