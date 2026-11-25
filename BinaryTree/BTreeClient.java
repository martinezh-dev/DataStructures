public class BTreeClient
{
    public static void main(String[] args)
    {
        BTree<Integer> myTree = new BTree<Integer>();

        myTree.add(3);
        myTree.add(2);
        myTree.add(7);
        myTree.add(5);

        System.out.println("inOrder: ");
        myTree.inOrder();

        System.out.println("\npostOrder: ");
        myTree.postOrder();

        System.out.println("\npreOrder: ");
        myTree.preOrder();

    }
}