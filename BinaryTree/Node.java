public class Node <E extends Comparable<E>>
{
    private Node<E> left, right;
    private E value;

    public Node(Node<E> left, Node<E> right, E val)
    {
        this.left = left;
        this.right = right;
        this.value = val;
    }

    public Node<E> advance(boolean goLeft)
    {
        return (goLeft) ? left : right;
    }

    public E getVal()
    {
        return value;
    }

    public void setVal(E val)
    {
        value = val;
    }

    public void setLeft(Node<E> nLeft)
    {
        left = nLeft;
    }
    public void setRight(Node<E> nRight)
    {
        right = nRight;
    }
}