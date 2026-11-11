public class Qeue <T extends Comparable<T>>
{
    private ListNode<T> head;

    public Qeue()
    {
        head = null;
    }

    public void append(T value)
    {
        if(head == null)
        {
            head = new ListNode<T>(value, null);
        }
        else
        {
            ListNode<T> cur = head;
            ListNode<T> trail = null;

            while(cur != null)
            {
                trail = cur;
                cur = cur.getNext();
            }
            trail.setNext(new ListNode<T>(value, null));
        }
    }

    public ListNode<T> pop()
    {
        ListNode<T> temp = head;
        head = head.getNext();
        temp.setNext(null);
        return temp;
    }
    T peek()
    {
        return head.getVal();
    }
}