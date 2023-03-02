/**
  * This is my code!  Its goal is to create a program to maintain inventory for 
  * Patrick's New and Used Stuff Store
  * CS 312 - Assignment 4
  * @author Mari Sisco appending onto Dr.Binkley's code
  * @version 1.0, 10/19/2022
  */

/**
  * This is my code!  Its goal is to create items
  * CS 312 - Assignment 4
  * @author Dave Binkley
  * @version 1.0 10/10/22 
  */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;

public class ItemFactory     // the maker of Items
{
  public final static int CURRENT_YEAR = 2022;  
  public final static int EXPECTED_ARGS = 6;


  // [ an example of the *factory* pattern ]
  /*
   * purpose: create a new item based on the mediaKind
   * input:   the new items data
   * result:  a new Item of the appropriate subclass
   */
  public Item createItem(String title, String mediaKind, Double cost, 
                         String authorOrYear, String property2, Boolean isNew)
  {
    Item it = null;
    int year = CURRENT_YEAR;
    int released = -1;

    switch (mediaKind) 
    {
      case"AUDIOBOOK":       
        it = new AudioBook(title, cost, isNew, authorOrYear, property2);
        break;
      
      case "DVD":
	released = Integer.parseInt(authorOrYear);
	if (released > year)
	{
          it = new DVD(title, cost, isNew, year, property2);
	}
        else
	  it = new DVD(title, cost, isNew, released, property2);
        break;
      
      case "BOOK":
 	if (!property2.equals("SCIFI"))
	  property2 = "OTHER";	
      	it = new PrintBook(title, cost, isNew, authorOrYear, property2);
        break;
      
      case "CD":
	released = Integer.parseInt(authorOrYear);
        if (released > year)
        {
          it = new CD(title, cost, isNew, year, property2);
        }
        else
          it = new CD(title, cost, isNew, released, property2);
        break;

      default:
        System.err.println("I'll pretend i didn't see the media kind " 
                           + mediaKind);
    }

    return it;  
  }

  /*
   * purpose: create a new Item based on a database record (line from the file)
   * input:   a semicolon separated string
   * result:  a new Item of the appropriate subclass
   */
  private Item parseItemString(String s)
  {
    StringTokenizer tok = new StringTokenizer(s, ";");
    if (tok.countTokens() != EXPECTED_ARGS)   // [ some defensive programming ]
      return null;  // hey I was promised that the input was valid!
    else
    {
      String [] arr = new String [6];
      for(int i = 0; tok.hasMoreTokens(); i++)
      {
	      arr[i] = tok.nextToken();
      }
    return createItem(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3], arr[4], Boolean.parseBoolean(arr[5]));
    }
  }

  /*
   * purpose: read the inventory from a Java reader
   * input:   the reader
   * result:  a populated inventory
   */
  public Inventory readDatabase(BufferedReader reader)
  {
    Inventory inv = new Inventory();
    try
    {
      String line;

      for(line = reader.readLine(); line != null; line = reader.readLine())
      {
        if (line.length() == 0)
          continue;   // ignore blank lines

        Item it = parseItemString(line);
        if (it == null) 
          System.err.println("Someone needs to take a look at this! " + line);
        else
          inv.add(it);
      }
    }
    catch (Exception E)
    {
      System.err.println("ah sorry but " + E);
    }

    return inv;
  }

  // [ an example of the *wrapper* pattern ]
  /* [ overload the readDatabase method ] 
   *
   * purpose: read the inventory from an input stream
   * input:   the stream, in (e.g., stdin)
   * result:  returns the populated inventory
   */
 
  public Inventory readDatabase(InputStream in) 
  {
    return readDatabase(new BufferedReader(new InputStreamReader(in)));
  }


  // [ another example of the *wrapper* pattern ]
  /* [ overload the readDatabase method ] 
   *
   * purpose: read the inventory from a disk file
   * input:   the file name, fileName
   * result:  returns the populated inventory
   */
  public Inventory readDatabase(String fileName) 
  {
    try
    {
      return readDatabase(new BufferedReader(new FileReader(fileName)));
    }
    catch (Exception E)
    {
      System.err.println("ah sorry but " + E);
      return null;
    }
  }
}
