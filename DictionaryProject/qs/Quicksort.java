import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort
{
  
  public static ArrayList<Integer> concatenate(ArrayList<Integer> list1, ArrayList<Integer> list2)
  {

    ArrayList<Integer> ret = new ArrayList<Integer>();

    for(Integer i : list1)
    {
       ret.add(i);
    }
    
    for(Integer i : list2)
    {
       ret.add(i);
    }

    return ret;
  }
  
  public static void qs(ArrayList<Integer> input, int lead, int pivIndex)
  {
    if(pivIndex<lead)
    {return;}
    int ogLead = lead;
    int pivot = input.get(pivIndex);
    int trail = lead-1;
    System.out.println("pivot: " + pivot);
    System.out.println("List: " + input);
    System.out.println("Lead: " + lead);
    System.out.println("pivIndex: " + pivIndex);

    while(lead < pivIndex)
    {

      while(input.get(lead) > pivot && lead < pivIndex)
      {
        lead++;
        System.out.println(lead);
      }

      if(input.get(lead) <= pivot && pivIndex > lead)
      {
        System.out.println("\nPre Swap: " + input);
        System.out.println("lead: " + lead + "\tTrail: " + trail);
        trail++;
        int temp = input.get(lead);
        input.set(lead, input.get(trail));
        input.set(trail, temp);
        System.out.println("Post Swap: " + input);
        lead++;
      }
    }

    trail++;
    input.set(pivIndex, input.get(trail));
    input.set(trail, pivot);
    

    System.out.println("\n\nBeginning next sequence. Press enter to confirm"); 
    Scanner scan = new Scanner(System.in);
    scan.nextLine();

    qs(input, ogLead, trail-1);
    qs(input, trail+1, lead);
  }

  public static void qss(ArrayList<String> input, int lead, int pivIndex)
  {
    if(pivIndex<lead)
    {return;}
    int ogLead = lead;
    String pivot = input.get(pivIndex);
    int trail = lead-1;
    System.out.println("pivot: " + pivot);
    System.out.println("List: " + input);
    System.out.println("Lead: " + lead);
    System.out.println("pivIndex: " + pivIndex);

    while(lead < pivIndex)
    {

      while(input.get(lead).compareTo(pivot) > 0 && lead < pivIndex)
      {
        lead++;
        System.out.println(lead);
      }

      if(input.get(lead).compareTo(pivot) <= 0 && pivIndex > lead)
      {
        System.out.println("\nPre Swap: " + input);
        System.out.println("lead: " + lead + "\tTrail: " + trail);
        trail++;
        String temp = input.get(lead);
        input.set(lead, input.get(trail));
        input.set(trail, temp);
        System.out.println("Post Swap: " + input);
        lead++;
      }
    }

    trail++;
    input.set(pivIndex, input.get(trail));
    input.set(trail, pivot);
    

    System.out.println("\n\nBeginning next sequence. Press enter to confirm"); 
    Scanner scan = new Scanner(System.in);
    scan.nextLine();

    qss(input, ogLead, trail-1);
    qss(input, trail+1, lead);
  }

  public static void main(String[] args)
  {

    ArrayList<String> list = new ArrayList<String>();
    list.add("ab");

    list.add("ar"); 
    list.add("ze");
    list.add("ae");
    list.add("zz");
    list.add("py");
    list.add("pa");
    list.add("xq");
 
    qss(list, 0, list.size()-1); 
    System.out.println(list);
  }
}  


