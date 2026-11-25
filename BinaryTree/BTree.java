public class BTree <E extends Comparable<E>>
{
    private Node<E> root, cur;

    public BTree()
    {
        root = null;
        cur = null;
    }

    public void add(E newKey)
    {
        if(root == null)
        {
            root = new Node<E>(null, null, newKey);
            cur = root;
            return;
        }

        root.add(newKey);
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
}