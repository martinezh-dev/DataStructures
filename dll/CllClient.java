/*
Hugo Martinez
Last Update: 9/26/26

A test class designed to test Circular Linked Lists and the Josephus 
solution function.
*/

public class CllClient
{
  public static void main(String[] args)
  {
    //test cases 
    System.out.println("Josephus(5, 2): " + Josephus.JosephusCll(5,2));
 
    System.out.println("Josephus(5, -10): " + Josephus.JosephusCll(5,-10));   

    System.out.println("Josephus(5, 1): " + Josephus.JosephusCll(5,1));

    System.out.println("Josephus(5, -5): " + Josephus.JosephusCll(5,-5));

    System.out.println("Josephus(1, 5): " + Josephus.JosephusCll(1,5));

    System.out.println("Josephus(13, 1): " + Josephus.JosephusCll(13,1));

    System.out.println("Josephus(40, 7): " + Josephus.JosephusCll(40,7));

    System.out.println("Josephus(40, -7): " + Josephus.JosephusCll(40,-7));

    System.out.println("Josephus(100, -2): " + Josephus.JosephusCll(100,-2));

    System.out.println("Josephus(66, 1): " + Josephus.JosephusCll(66,1));

    System.out.println("Josephus(66, 100): " + Josephus.JosephusCll(66, 100));

    System.out.println("Josephus(66, -100): " + Josephus.JosephusCll(66,-100));

    System.out.println("Josephus(1000, -123): " + Josephus.JosephusCll(1000,-123));

    System.out.println("Josephus(1000, 123): " + Josephus.JosephusCll(1000, 123));

    System.out.println("Josephus(1000, 1000): " + Josephus.JosephusCll(1000,1000));

    System.out.println("Josephus(1000, -1000): " + Josephus.JosephusCll(1000, -1000));

    //These Two Throw Exceptions
    //System.out.println("Josephus(-3, 2): " + Josephus.JosephusCll(-3,2));

    System.out.println("Josephus(3, 0): " + Josephus.JosephusCll(3,0));



 
  /*  System.out.println("Josephus(5, 2): " + Josephus.JosephusCll(5,2));  /* System.out.println(cll);

    cll.insertInOrder(1);

    System.out.println("Post add 1: " + cll);
    System.out.println("head next: " + cll.getHead().getNext());
    System.out.println("head prev: " + cll.getHead().getPrev());

    cll.insertInOrder(2);
    cll.advance();

    System.out.println("Post add 2: " + cll);
    System.out.println("cur next: " + cll.get().getNext());
    System.out.println("cur prev: " + cll.get().getPrev());


    
    
    System.out.println("Tail previous: " + tail.getPrev());
    System.out.println("Accessor data: " + cll.getData());
    System.out.println("Whole List: " + cll);

    System.out.println("\nSize: " + cll.size());
    System.out.println("Contains 1: " + cll.contains(1));
    System.out.println("Contains 2: " + cll.contains(2));
    System.out.println("Contains 3: " + cll.contains(3));
    System.out.println("Is Empty: " + cll.isEmpty());
    
    System.out.println("\nAdding 4");
    cll.insertInOrder(4);
    System.out.println("Post Add 4: " + cll);

    System.out.println("\nAdding 3");
    cll.insertInOrder(3);
    System.out.println("Post Add 3: " + cll);

    System.out.println("\nAdding -1");
    cll.insertInOrder(-1);
    System.out.println("Post Add -1: " + cll);
    System.out.println("Head next: " + cll.get().getNext());

    System.out.println("\nRemoving 1st Element: " + cll.removeAt(-1));
    System.out.println("Post Remove: " + cll);
    System.out.println("head next: " + cll.getHead().getNext());
    System.out.println("Head's prev: " + cll.getHead().getPrev());
 

    cll.clear();
    System.out.println("\nPost Clear: " + cll);
    System.out.println("Is Empty: " + cll.isEmpty());
    */
  }
}

