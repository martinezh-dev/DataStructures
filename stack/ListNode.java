/*
Hugo Martinez
Last Update: 9/15/26

A class which encapsulates a value of type T
and a pointer to the next node. Also includes
methods for the appropriate placement of new
nodes in the list
*/

public class ListNode <T extends Comparable<T>>
{

  private T value;
  private ListNode<T> next;

//Constructors
  ListNode(T value, ListNode<T> next)
  {
    this.value = value;
    this.next = next;
  }
 
  ListNode(T value)
  {
    this.value = value;
    this.next = null;
  }

//Copy Constructor
  ListNode(ListNode<T> source)
  {
    value = source.getVal();
    next = source.getNext();
    if(next != null)
    {
      next = new ListNode<T>(next);
    }
  }

//Accessors
  public T getVal()
  {
    return this.value;
  }

  public ListNode<T> getNext()
  {
    return next;
  }

//Mutators
  public void setNext(ListNode<T> next)
  {
    this.next = next;
  }

  public void setVal(T newVal)
  {
    value = newVal;
  }

//Deletion Methods
  public ListNode<T> deleteRecursive(T val)
  {
    if(next != null && val.compareTo(next.getVal()) == 0)
    {
      ListNode<T> temp = next;
      next = next.getNext();
      temp.setNext(null);
      return temp;
    }
    return (next == null) ? null : next.deleteRecursive(val);
  }

//Insertion Methods
  public void insert(int targetIndex, T value, int curIndex)
  {
    if(curIndex + 1 == targetIndex || next == null)
    {
      ListNode<T> newNode = new ListNode<T>(value, next);
      setNext(newNode);
      return;
    }
  
    curIndex++;
    next.insert(targetIndex, value, curIndex);
    return;
  }

  public void insertInOrderRecursive(T value)
  {
    if(next == null)
    {
      ListNode<T> newNode = new ListNode<T>(value, next);
      next = newNode;
      return;
    }
    if(next.getVal().compareTo(value) >= 0)
    {
      ListNode<T> newNode = new ListNode<T>(value, next);
      next = newNode;
      return;
    }
    next.insertInOrderRecursive(value);
  }

  public void insertAtEndRecursive(T value)
  {
    if(this.next == null)
      next = new ListNode<T>(value, null);
    else
      next.insertAtEndRecursive(value);
  } 
  
  public String toString()
  {
    String ret = value.toString();
    if(next == null)
      return ret + "]";
    return ret + ", " + next.toString();
  }
}

