package skipList;

public class TestSkipList {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        skipList.insert(34);
        skipList.insert(50);
        skipList.insert(20);
        skipList.insert(37);
        skipList.print();
        skipList.remove(20);
        skipList.print();
        skipList.remove(37);
        skipList.print();
        skipList.insert(79);
        skipList.print();
        System.out.println("Busca: "+skipList.busca(34));
        System.out.println("Busca: "+skipList.busca(10));

    }
}
