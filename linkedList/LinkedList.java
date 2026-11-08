/*
Hugo Martinez
Last Update: 9/15/26

A class which holds a pointer to the first ListNode
in a lined list as well as methods to start insertion
in the linked list
*/

public class LinkedList <T extends Comparable<T>>
{
  private ListNode<T> first;

//Generic Constructor
  LinkedList(){};

//Attatch to an already given ListNode
  LinkedList(ListNode<T> first)
  {
    this.first = first;
  }

//Deep Copy Constructor
  LinkedList(LinkedList<T> source)
  {
    first = new ListNode<T>(source.get());
  }

//Delete elements
  public ListNode<T> deleteIterative(T val)
  {
    ListNode<T> prev = null;
    ListNode<T> cur = first;

    while(cur != null)
    {
      if(val.compareTo(cur.getVal()) == 0)
      {
        if(prev == null)
        {
          first = first.getNext();
          cur.setNext(null);
          return cur;
        }
        prev.setNext(cur.getNext());
        cur.setNext(null);
        return cur.getNext();
      }
      prev = cur;
      cur = cur.getNext();
    }
    return null;
  }

  public ListNode<T> deleteRecursive(T val)
  {
    if(first != null && val.compareTo(first.getVal()) == 0)
    {
      ListNode<T> temp = first;
      first = first.getNext();
      temp.setNext(null);
      return temp;
    }
    return (first == null) ? null : first.deleteRecursive(val);
  }

  public ListNode<T> removeHead()
  {
    if(first == null)
      return first;
    ListNode<T> temp = first;
    first = first.getNext();
    temp.setNext(null);
    return temp;
  }

//Get the size of the list
public int size()
{
  int count = 0;
  ListNode<T> cur = first;
  while(cur != null)
  {
    count++;
    cur = cur.getNext();
  }
  return count;
}

//insert into a given index
  public void insert(int targetIndex, T value)
  {
    if(first != null)
    {  
      first.insert(targetIndex, value, 0);
      return;
    }
    first = new ListNode<T>(value);
  } 

  public void insertInOrderRecursive(T value)
  {
    if(first == null)
    {
      first = new ListNode<T>(value, null);
      return;
    }  
    if(first.getVal().compareTo(value) >= 0)
    {
      ListNode<T> newNode = new ListNode<T>(value, first);
      first = newNode;
      return;
    }
    first.insertInOrderRecursive(value);
  }

  public void insertInOrderIterative(T value)
  {
    boolean inserted = false;
    ListNode<T> cur = first;
    ListNode<T> prev = null;
    while(!inserted)
    {
      if(cur != null && cur.getVal().compareTo(value) >= 0)
      {
        if(prev == null)
        {
          first = new ListNode<T>(value, cur);
          inserted = true;
        }
        else
        {
          prev.setNext(new ListNode<T>(value, cur));
          inserted = true;
        }
      }
      else if(cur == null)
      {
        cur.setNext(new ListNode<T>(value, null));
        inserted = true;
      }
      else
      {
        prev = cur;
        cur = cur.getNext();
      }
    }
  }

  public void insertAtEndRecursive(T value)
  {
    first.insertAtEndRecursive(value);
  }  

//retrieve the first ListNode item
  public ListNode<T> get()
  {
    return first;
  }

  public void setFirst(ListNode<T> first)
  {
    this.first = first;
  }

  public String toString()
  {
    return "[" + first.toString();
  }
}
