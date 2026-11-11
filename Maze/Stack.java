public class Stack <T extends Comparable<T>>
{
    private ListNode<T> head;

    Stack()
    {
        head = null;
    }

    Stack(Stack<T> source)
    {
        head = new ListNode<T>(source.peek());   
    }

    public void push(T newVal)
    {
        ListNode<T> newNode = new ListNode<T>(newVal, head);
        head = newNode;
    }

    public T pop()
    {
        if(head != null)
        {
            T temp = head.getVal();
            head = head.getNext();
            return temp;
        }
        return null;
    }

    public T peek()
    {
        if(head != null)    
            return head.getVal();
        return null;
    }

    public int size()
    {
        int size = 0;
        ListNode<T> temp = head;

        while(temp != null)
        {
            size++;
            temp = temp.getNext();
        }

        return size;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public String toString()
    {
        return "[" + ((head != null) ? head.toString() : "]");
    }
}