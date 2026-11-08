/*
Hugo Martinez
Last Update: 9/26/26

A class to hold the josephus solution function.
Takes a list size and a rotation value and 
returns the last survivor's number as described
in the josephus problem
*/

public class Josephus
{
  public static int JosephusCll(int size, int rotation)
  {
    CLinkedList<Integer> cll = new CLinkedList<Integer>();

    for(int i = 1; i <= size; i++)
    {
      cll.insertInOrder(i);
    }

    while(cll.size() > 1)
    {
      cll.removeAt(rotation);
    }
    return cll.get().getVal();
  }
}
