/*
Hugo Martinez
Last Update: 9/3/26

This class represents a dictionary entry based
on input strings of a word and its definition
*/

public class DictionaryEntry
{
  //properties representing word and definition
  private String word, def;

  //constructor must be given a word and a definition  
  DictionaryEntry(String word, String def)
  {
    this.word = word;
    this.def = def;
  }
  
  //accessors
  public String getWord()
  {return word;}

  public String getDef()
  {return def;}

  //mutators
  public void setWord(String newWord)
  {
    word = newWord;
  }

  public void setDef(String newDef)
  {
    def = newDef;
  }

  public String toString()
  {
    return getWord() + ": " + getDef();
  }
}
