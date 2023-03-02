/**
* This is my code!  Its goal is to read command line arguments and execute search 
* engine functions
* CS 312 - Assignment 9
* @author Mari Sisco
*/

import java.util.Scanner;
import java.util.Arrays;

public class CLI
{
  private String [] args;
  protected Boolean display;

  /** Creates a CLI object to read and interpret command line arguments
   * @param a, a String array containing command line arguments
   */
  public CLI(String [] a)
  {
    this.args = a;
    this.display = false;

    parse();
  
  }

  /** Prints a usage message
   */
  private void usage()
  {
    System.out.println("Usage: [-d] <Path to stoplist> <Path to document(s)>");
  }

  /** Interprets String arguments, parses arguments as parameters to specific functions
   */
  public void parse()
  {
    if (args.length == 0)
    {
      usage();
      return;
    }

    int i = 0;

    if ("-d".equals(args[i]))
    {
      this.display = true;
      i++;
    }

    if (args.length > i)
    {
      Stoplist sl = new Stoplist(args[i]);
      i++;
      SearchEngine se = new SearchEngine(sl, display); 
      for( int j = i; j < args.length; j++)
      {
        Document doc = new Document(args[j]);
	se.buildIndex(doc);
      }
      
      Scanner sc = new Scanner(System.in);
      long startTime = System.currentTimeMillis();
      while (sc.hasNextLine())
      {
	String query = sc.nextLine();
        if (query.equals("@@debug"))
	{
	  se.displayInvertedIndex();
	}
	else
	{
	  String [] words = query.split("\\W+");
	  //System.out.println(Arrays.toString(words));
	  if(words.length == 1)
            se.findQuery(query);
	  else
            se.findMultiWord(words, query);
	}
      }
      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println("@@ processing took " + elapsedTime + "ms");
    }
  }

  public static void main (String [] args)
  {
    CLI cli = new CLI(args);
    //cli.parse();

  }
}
