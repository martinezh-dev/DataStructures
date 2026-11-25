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

    public String toString()
    {
        return value.toString();
    }

    public void add(E newKey)
    {
        Node<E> next = advance(newKey.compareTo(value) <= 0);

        if(next == null)
        {
            if(newKey.compareTo(value) <= 0)
            {
                left = new Node<E>(null, null, newKey);
            }
            else
            {
                right = new Node<E>(null, null, newKey);
            }
        }
        else
        {
            next.add(newKey);
        }
    }

    //left child, parent, right child
    public void traverse()
    {
        if(left != null)
        {
            left.traverse();
        }
        System.out.print(value.toString());
        if(right != null)
        {
            right.traverse();
        }
    }
}