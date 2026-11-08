public class CNode <E extends Comparable<E>>
{

  private CNode<E> next, prev;
  private E value;

  CNode()
  {
    next = null;
    prev = null;
    value = null;
  }
  CNode(CNode<E> next, CNode<E> prev, E value)
  {
    this.next = next;
    this.prev = prev;
    this.value = value;
  }
  CNode(E value)
  {
    this.value = value;
    prev = null;
    next = null;
  }

  public String toString()
  {
    return value + " <-> ";
  }

  public CNode<E> getPrev()
  { return prev; }
  public CNode<E> getNext()
  { return next; }
  public E getVal()
  { return value; }

  public void setPrev(CNode<E> nPrev)
  {
    prev = nPrev;
  }
  public void setNext(CNode<E> nNext)
  {
    next = nNext;
  }
  public void setVal(E nVal)
  {
    value = nVal;
  }

}
