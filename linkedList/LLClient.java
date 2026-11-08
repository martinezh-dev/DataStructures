/*
Hugo Martinez
Last Update: 9/15/26

A client class to test methods of the Linked List and List Node classes
and implements those classes and methods with SimpleDate class
*/
import java.util.Scanner;
import java.io.*;

public class LLClient
{
  public static void main(String[] args) throws IOException
  {
    /*LinkedList<SimpleDate> dates = new LinkedList<>();
    Scanner scan = new Scanner(new File("football_dates.txt"));

    SimpleDate curDate = SimpleDate.parse(scan.nextLine());

    dates.setFirst(new ListNode<SimpleDate>(curDate));

    while(scan.hasNext())
    {
      curDate = SimpleDate.parse(scan.nextLine());
      dates.insertInOrderRecursive(curDate);
    }

    System.out.println(dates);*/

    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.insertInOrderRecursive(7);
    ll.insertInOrderRecursive(2);
    ll.insertInOrderRecursive(5);

    System.out.println(ll);

    /* ListNode<Integer> deleted = ll.removeHead();
    System.out.println(ll);
    System.out.println(ll.size());
    System.out.println(deleted.getNext());*/
    
  }
}
    
