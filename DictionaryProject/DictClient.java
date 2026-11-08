/*
Hugo Martinez
Last Update: 9/2/26

This class is designed to provide a dedicated main
class to run programs related to Dictionary
and DictionaryEntry classes
*/

import java.util.Scanner;
import java.io.*;

public class DictClient
{
  public static void main(String[] args) throws IOException
  {
    String filename = "OPTED-Dictionary.txt";
    Scanner scan = new Scanner(new File(filename));
    String curLine = scan.nextLine();

    Dictionary dict = new Dictionary();

    //read from source file into dict
    while(scan.hasNext())
    {
      curLine = scan.nextLine();
      String[] lineParts = curLine.split(",");

      String word = lineParts[0];
      String def = lineParts[3];

      dict.addEntry(new DictionaryEntry(word, def));
    }

    //print out snapshot of state before shuffle
    for(int i = 0; i < 20; i++)
    {
      System.out.println(dict.getByIndex(i));
    }

    //shuffle and create a duplicate dictionary
    dict.shuffle();
    Dictionary dict2 = new Dictionary(dict);
    //create a stop watch to test time complexty
    StopWatch watch = new StopWatch(1);
    
    //print out snapshot of state after shuffle
    System.out.println("post shuffle\n");
    for(int i = 0; i < 20; i++)
    {
      System.out.println(dict.getByIndex(i));
    }
    
    //implement and time quicksort
    watch.start();
    dict.quicksort(0, dict.getSize()-1);

    System.out.println("\n quicksort time: "+ watch.stop() + "ms");
    watch.reset();
    
    //make sure quicksort is properly functioning; print snapshot
    System.out.println("post quicksort");
    for(int i = 0; i < 20; i++)
    {
      System.out.println(dict.getByIndex(i));
    }

    //run and time selection sort    
    watch.start();
    dict2.selectionSort();

    System.out.println("\n selectionsort time: "+ watch.stop() + "ms");
    watch.reset();

    //make sure selection sort is properly funcioning; print snapshot
    System.out.println("post selectionsort");
    for(int i = 0; i < 20; i++)
    {
      System.out.println(dict2.getByIndex(i));
    }
  }
}
