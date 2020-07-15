package labs.khobfa.tables;

public class BSTest {
    public static void main(String[] args) {
        BST<Character, Integer> bst = new BST<>();
        bst.put('S', 1);
        bst.put('X', 2);
        bst.put('E', 3);
        bst.put('R', 4);
        bst.put('A', 5);
        bst.put('C', 6);
        bst.put('H', 7);
        bst.put('M', 8);

        System.out.println("Tree size >>>> " + bst.size());
    }
}
