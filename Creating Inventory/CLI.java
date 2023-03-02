/**
  * This is my code!  Its goal is to create a program to maintain inventory for 
  * Patrick's New and Used Stuff Store
  * CS 312 - Assignment 4
  * @author Mari Sisco appending onto Dr.Binkley's code
  * @version 1.0, 10/19/2022
  */

/**
  * This is my code!  Its goal is to provide a command-line interface
  * CS 312 - Assignment 4
  * @author Dave Binkley
  * @version 1.0 10/10/22
  */


public class CLI     // the command line interface!
{
  /*
   * purpose: run the program
   * input:   command from the user (taken from the command line)
   * result:  the database of stuff read from stdin is updated and
              written to stdout
   */
  public static void main(String [] args)
  {
    CLI cli = new CLI();
    ItemFactory factory = new ItemFactory();
    Inventory inv = factory.readDatabase(System.in);
    cli.processCommand(args, inv, factory);
  }


  /*
   * purpose: print an error message and the program's command line options
   * input:   an error message
   * result:  message and instructions printed to stdout
   */
  private void usage(String msg)
  {
    System.err.println("\n" + msg + "\nUsage: java CLI [-d|-a|-s] <options>\n"
     + "there are three command line options\n"
     + "  (display) -d [(everything by default) | -t title | -a author ]\n"
     + "  (add)     -a DVD         \"title\" cost year   \"studio\" NEW|USED\n"
     + "  (add)     -a CD          \"title\" cost year   \"band\"   NEW|USED\n"
     + "  (add)     -a BOOK        \"title\" cost author  genre     NEW|USED\n"
     + "  (add)     -a AUDIOBOOK   \"title\" cost author \"reader\" NEW|USED\n"
     + "  (sell)    -s [-t title | -a author]");
  }

  /*
   * purpose: process the user's command
   * input:   the command arguments and the current inventory
   * result:  display requested information or inventory, inv as updated, 
   *          is written to stdout
   */
  private void processCommand(String [] args, Inventory inv, ItemFactory factory)
  {
    if (args.length == 0)
    {
      usage("");
      return;
    }
    if ("-d".equals(args[0]))
    {
      if (args.length == 1)
      {
        System.out.println(inv.displayAll());
      }
      else if ("-t".equals(args[1]) && args.length == 3) 
      {
        System.out.println(inv.displayMatchingTitle(args[2].toString()));
      }
      else if ("-a".equals(args[1]) && args.length == 3)
      {
        System.out.println(inv.displayMatchingAuthor(args[2].toString()));
      }
      else
        usage("Invalid display command");
    }
    else if ("-a".equals(args[0]))
    {
      inv.add(factory.createItem(args[1], args[2], Double.parseDouble(args[3]), args[4], args[5], Boolean.parseBoolean(args[6])));
      System.out.println(inv.serialize());
    }
    else if("-s".equals(args[0]))
    {
      if ("-t".equals(args[1]) && args.length == 3)
      {
        inv.removeMatchingTitle(args[2]);
        System.out.println(inv.displayAll());
      }
      else if ("-a".equals(args[1]) && args.length == 3)
      {
	inv.removeMatchingAuthor(args[2]);
        System.out.println(inv.displayAll());
      }
      else
	usage("Invalid sell command");
    }
    else
    {
      usage("Bummer I don't know how to `" + args[0] + "'");
    }
  }
}
