/**
* This is our code! Its goal is to interact with the user; it is the command-line interface 
* CS 312 - Assignment 6
* @author(s) Mari Sisco and Dr. David Binkley, in collaboration with Emma Smith and Aidan Shaughnessy
*/

import java.util.Random;
import java.util.List;
import java.util.LinkedList;

public class Driver
{
  private String [] args;
  protected Boolean debug;
  protected Boolean timeit;

  /*
   * purpose: construct Driver class
   * input:   CLI arguments as a String Array
   * result:  updates private variable args, sets debug and timeit to false
   */
  public Driver(String [] a)
  {
    this.args = a;
    this.debug = false;
    this.timeit = false;
  }

  /* purpose: print out usage aka menu with options
   * input:   none
   * results: prints menu in CLI
   */
  private void usage()
  {
    System.out.println("Usage: [-d|-t]  -n <numbers> | -r <count>");
  }


  /*
   * purpose: process the user's command
   * input:   none, uses private String array
   * result:  sorts a list of user-enetered numbers or of n random numbers. 
   *          It is optional to time how long it took and to print the sorting process
   */
  public void parse()
  {
    if (args.length == 0)
    {
      usage();
      return;
    }

    int i = 0;

    if ("-d".equals(args[i]))    // args[0].equals("-d")
    {
      //print function from tree
      this.debug = true;
      i++;

      if (args.length > i && "-t".equals(args[i]))
      {
        this.timeit = true;
        i++;
      }
    }
    else if ("-t".equals(args[0]))
    {
      timeit = true;
      i++;
      
      if (args.length > i && "-d".equals(args[i]))
      {
        debug = true;
        i++;
      }
    }

    // -r and -n args[i]

    if (args.length > i && "-n".equals(args[i]))
    {
      i++;
      List<Integer> list = new LinkedList<Integer>();

      while(args.length > i)
      {
        int n = Integer.parseInt(args[i]);
	list.add(n);
	i++;
      }

      Tree<Integer> tree = new Tree<Integer>(list, this.debug);
       
      // calculates time taken to sort list
      if(timeit == true)
      {
        long startTime_ms = System.currentTimeMillis();

        tree.sort();

        long endTime_ms = System.currentTimeMillis();
	System.out.println("-> Sorting took " + (endTime_ms - startTime_ms) + " milliseconds");
        
	long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("It used "+ memoryUsed/(1024*1024) + "Mb");
      }
     else
       tree.sort();
    }
    
    else if(args.length > i && "-r".equals(args[i]))
    {
      i++;
      int count = Integer.parseInt(args[i]);
      
      List<Integer> list = new LinkedList<Integer>();
      Random r = new Random();
      int j = 0;
      while(j < count)
      {
        list.add(r.nextInt());
	j++;
      }

      Tree<Integer> tree = new Tree<Integer>(list, this.debug);
      
      // calculates time taken to sort list
      if(timeit == true)
      {
        long startTime_ms = System.currentTimeMillis();
        
	tree.sort();
        
        long endTime_ms = System.currentTimeMillis();
        System.out.println("-> Sorting took " + (endTime_ms - startTime_ms) + " milliseconds");
        
	long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("It used "+ memoryUsed/(1024*1024) + "Mb");
      }
     else
       tree.sort();
    }
    
    else
    {
      usage();
      return;
    }
   
    System.out.println("debug = " + debug + " time it = " + timeit);
  }

  /*
   * purpose: run the program
   * input:   command from the user (taken from the command line)
   * result:  perfomrs task depending on the command entered by user
   */
  public static void main(String [] args)
  {
    Driver d = new Driver(args);
    d.parse();
  
  }

}
