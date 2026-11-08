public interface CircularList<E extends Comparable<E>>
{
  public void clear();

  public int size();
 
  public String toString();

  public boolean contains(E value);

  public boolean isEmpty();

  public E getData();

  public E removeAt(int n); //throws NoSuchElementException;
}
