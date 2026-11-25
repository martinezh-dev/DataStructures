public class BTree <E extends Comparable<E>>
{
    private Node<E> root, cur;

    private int levels;

    public BTree()
    {
        root = null;
        cur = null;
        levels = 0;
    }

    public void add(E newKey)
    {
        if(root == null)
        {
            root = new Node<E>(null, null, newKey);
            cur = root;
            levels = 1;
            return;
        }

        int tempLv = root.add(newKey, 1);
        if(tempLv > levels)
        {
            levels = tempLv;
        }
    }
    
    public String toString()
    {
        return (cur == null) ? null : cur.getVal().toString();
    }

    public E advance(boolean goLeft)
    {
        cur = cur.advance(goLeft);
        return (cur == null) ? null : cur.getVal();
    }

    public void reset()
    {
        cur = root;
    }

    public void inOrder()
    {
        root.inOrder();
        System.out.println();
    }
    public void preOrder()
    {
        root.preOrder();
        System.out.println();
    }
    public void postOrder()
    {
        root.postOrder();
        System.out.println();
    }

    public int getLevels()
    {
        return levels;
    }
}