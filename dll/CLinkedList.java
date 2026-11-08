/*
Hugo Martinez
Last Update: 9/26/26

This class works with doubly linked CNodes. Provides a first variable
(used as the head when inserting in order) and a cur node, representing
the current position in a circular doubly linked list.
*/

public class CLinkedList <E extends Comparable<E>> implements CircularList<E>
{
  private CNode<E> cur;
  private CNode<E> first;
 
  public CLinkedList()
  {
    first = null;
    cur = null;
  }
 
  public CLinkedList(CNode<E> head, CNode<E> tail)
  {
    cur = head;
    first = head;
    head.setPrev(tail);
    tail.setNext(head);
  }

  //delete the list by assigning list's accessors to null
  public void clear()
  {
    cur = null;
    first = null;
  }

  public int size()
  {
    CNode<E> start = first;
    if(first == null)
      return 0;
    
    int count = 1;
    start = start.getNext();

    while(start != null && start != first)
    {
      count++;
      start = start.getNext();
    }
    return count;
  }

  public String toString()
  {
    String ret = "<- " + first;

    CNode<E> start = first;
    start = (start != null) ? start.getNext() : null;

    while(start != null && start != first)
    {
      ret += start;
      start = start.getNext();
    }

    return ret;
  }

  public boolean contains(E value)
  {
    CNode<E> start = cur;
    
    do
    {
      if(start.getVal().equals(value))
        return true;
      start = start.getNext();
    }while(start != null && start != cur);

    return false;
  }

  public boolean isEmpty()
  {
    return (cur == null);
  }

  public E getData()
  {
    return cur.getVal();
  }

  public void advance()
  {
    cur = cur.getNext();
  }

  public void regress()
  {
    cur = cur.getPrev();
  }

  public CNode<E> get()
  {
    return cur;
  }

  public CNode<E> getHead()
  {
    return first;
  }
  
  //removes the node at index n and returns it's value
  public E removeAt(int n) //throws NoSuchElementException
  {
    //set the appropriate starting point; 1 for positive, -1 for negative, 0 otherwise
    //Must be done this way in order to count the first element as part of the traversal
    int counter = (n==0) ? 0 : Math.abs(n)/n;
    
    if(n >= 0)
    {
      //advance cur to desired node's position
      while(cur != null && counter < n)
      {
        advance();
        counter++;
      }
      //set cur to the next value. Value to be deleted at cur.getPrev()
      advance();
      //store return value
      E ret = cur.getPrev().getVal();
      //re-assign first in case of deletion
      if(cur.getPrev() == first)
        first = cur;
      //re-assign neighboring nodes to delete target value
      cur.setPrev(cur.getPrev().getPrev());
      cur.getPrev().setNext(cur);
      
      return ret;
    }
    //Does the same thing but backwards for negative n values
    while(cur != null && counter > n)
    {
      regress();
      counter--;
    }
    regress();
    E ret = cur.getNext().getVal();
    if(first == cur.getNext())
      first = cur;
    cur.setNext(cur.getNext().getNext());
    cur.getNext().setPrev(cur);
    
    return ret;
  }

  //inserts a new node of value val in ascending order from first
  public void insertInOrder(E val)
  {
    //set a tracker to traverse the list
    CNode<E> track = first;
    //will add value to list if is empty
    if(track == null)
    {
      first = new CNode<E>(val);
      first.setNext(first);
      first.setPrev(first);
      cur = first;
      return;
    }
    //put in a breaking point to prevent track from cycling continuously
    track.getPrev().setNext(new CNode<E>(first, track.getPrev(), null));
    track.setPrev(track.getPrev().getNext());
    //search for the first node between first and the null node greater than val
    while(track.getVal() != null && track.getVal().compareTo(val) < 0)
    {
      track = track.getNext();
    }
    //Case if val belongs at the end
    if(track.getVal() == null)
    {
      track.setVal(val);
      return;
    }
    //assign null node to val and move first if val is smallest value
    if(track == first)
    {
      track.getPrev().setVal(val);
      first = track.getPrev();
      return;
    }
    //else, create new node and insert it in the proper location (before track)
    CNode<E> in = new CNode<E>(track, track.getPrev(), val);
    in.getNext().setPrev(in);
    in.getPrev().setNext(in);

    first.getPrev().getPrev().setNext(first);
    first.setPrev(first.getPrev().getPrev());
  }
}
