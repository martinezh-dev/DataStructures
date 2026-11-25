public class BTreeClient
{
    public static void main(String[] args)
    {
        BTree<Integer> myTree = new BTree<Integer>();

        myTree.add(3);
        myTree.add(2);
        myTree.add(7);
        myTree.add(5);

        myTree.advance(false);
        myTree.advance(true);
        System.out.println("right left Value: " + myTree);
    }
}