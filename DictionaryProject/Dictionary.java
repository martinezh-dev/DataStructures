/*
Hugo Martinez
Last Update: 9/3/26

Dictionary class maintains a list of dictionary entrys.
Various accessors and mutators to add and retrieve
data from that list, as well as selection sort, 
quicksort, and a random shuffle method. The 
implementation of selection and quick sort are limited
in that they are based on unicode character order;
any unicode characters preceeding the alphabet
will be given prescedence. Also, the random nature
of shuffle means that words with the same spelling 
will be arranged in a random order.
*/
import java.util.ArrayList;

public class Dictionary
{
  //this property holds all data
  private ArrayList<DictionaryEntry> dict = new ArrayList<DictionaryEntry>();
  
  //copy constructor
  Dictionary(Dictionary source)
  {
    for(int i = 0; i < source.getSize(); i++)
    {
      this.addEntry(source.getByIndex(i));
    }
  }

  //generic constructor
  Dictionary(){}
  
  //returns the removed entry
  public DictionaryEntry removeEntry(int index)
  {
    return dict.remove(index);
  }

  //returns the definition of the first entry with word=word
  public String findDef(String word)
  {
    for(DictionaryEntry e : dict)
    {
      if(e.getWord().equals(word))
        return e.getDef();
    }
    return (word + " not found");
  }

  //return the entry at a known index
  public DictionaryEntry getByIndex(int index)
  { return dict.get(index);}

  public int getSize()
  {return dict.size();}

  public void addEntry(DictionaryEntry entry)
  {
    dict.add(entry);
  }

  //randomly shuffle the elements of dict
  public void shuffle()
  {
    for(int i = 0; i < getSize(); i++)
    {
      int index = (int)(Math.random()*getSize());
      DictionaryEntry temp = dict.get(index);
      dict.set(index, dict.get(i));
      dict.set(i, temp);
    }
  }
 
  public String toString()
  {
    String ret = "";

    for(DictionaryEntry e : dict)
    {
      ret += e.getWord() + ":\n" + e.getDef() + "\n\n";
    }
    return ret;
  }
 
  public void selectionSort()
  {

    for(int i = 0; i < dict.size()-1; i++)
    {

      int minIndex = i;
      for(int j = i+1; j < dict.size(); j++)
      {
        if(dict.get(minIndex).getWord().compareTo(dict.get(j).getWord()) >= 0 )
        {
          minIndex = j;
        }
      }
      DictionaryEntry temp = dict.get(i);
      dict.set(i, dict.get(minIndex));
      dict.set(minIndex, temp);
    }
  }

  public void quicksort(int lead, int pivIndex)
  {
    //base case
    if(pivIndex<lead)
    {return;}

    //set the trailing marker and get the pivot value
    int ogLead = lead;
    String pivot = dict.get(pivIndex).getWord();
    int trail = lead-1;

    //until leader reaches pivot
    while(lead < pivIndex)
    {
      //move lead until it reaches a value of the left half of the Sorted list
      while(dict.get(lead).getWord().compareTo(pivot) > 0 && lead < pivIndex)
      {
        lead++;
      }

      //swap the lead and the trail
      if(dict.get(lead).getWord().compareTo(pivot) <= 0 && pivIndex > lead)
      {
        //incrament trail to next right-half value
        trail++;
        //swap
        DictionaryEntry temp = dict.get(lead);
        dict.set(lead, dict.get(trail));
        dict.set(trail, temp);
        lead++;
      }
    }
    //since trail always ends with a left half value, the next
    //right half value is at trail+1
    trail++;
    //swap first val of right half with pivot
    DictionaryEntry pivElement = dict.get(pivIndex);
    dict.set(pivIndex, dict.get(trail));
    dict.set(trail, pivElement);
    
    //recursion
    quicksort(ogLead, trail-1);
    quicksort(trail+1, lead);
  }
}
