package skipList;

public class TestSkipList {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        skipList.insert(34);
        skipList.insert(50);
        skipList.insert(2);
        skipList.insert(37);
        skipList.print();

    }
}
