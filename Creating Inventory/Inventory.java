/**
* This is my code! Its goal is to maintain order on Patrick's stuff and define methods for some tasks (display, add or remove items)
* CS 312 - Assignment 4
* @author Mari Sisco
* @version Version 1, 10/19/2022
*/

import java.util.Deque;
import java.util.ArrayDeque;

public class Inventory
{
    protected Deque <Item> stuff;

    /*
     * purpose: initialize an empty inventory
     * input:   nothing
     * result:  an empty inventory
     */
    public Inventory()
    {
        stuff = new ArrayDeque<Item>();
    }

    /*
     * purpose: add an item to the inventory
     * input:   the new item, it
     * result:  the inventory is updated
     */
    public void add(Item it)
    {
        stuff.add(it);
    }

    /*
     * purpose: serialize the items of the inventory
     * input:   only the inventory
     * result:  the serialized (semicolon separated) strings with newlines between items
     */
    public String serialize()
    {
	String ans = "";
	for( Item i : stuff)
          ans +=  i.serialize();
        return ans;
    }

    /*
     * purpose: return the sze of the inventory (used for testing)
     * input:   only the inventory
     * result:  the number of items in the inventory
     */
    public int size()
    {
        return stuff.size();
    }

    /*
     * purpose: display items having a given title
     * input:   the title, needle
     * result:  String reperesentation of matching items
     */
    public String displayMatchingTitle(String needle)
    {
	String display = "";
	for (Item i : stuff)
	{
	  if (i.isMyTitle(needle))
            display += "\n" + i;
	}
        return display;
    }

    /*
     * purpose: display items having a given author
     * input:   the author, needle
     * result:  string representation of the matchin items
     */
    public String displayMatchingAuthor(String needle)
    {
	String display = "";
        for (Item i : stuff)
        {
          if (i.isMyAuthor(needle))
            display += "\n" + i;
        }
        return display;
    }

    /*
     * purpose: display all items
     * input:   nothing
     * result:  string representation of all items
     */
    public String displayAll()
    {
	String display = "";
	if (stuff.size() == 0)
	  return display;
	else
	{
          for (Item i : stuff)
          {
            display += "\n" + i.toString();
          }
	}
        return display;
    }

    /*
     * purpose: convert the inventory to a human pleasing string
     * input:   just the inventory
     * result:  the inventory's string representation
     * [takes use of displayAll() as it does the same thing]
     */
    public String toString()
    {
        return displayAll();
    }

    /*
     * purpose: remove all items with a given author
     * input:   the title, needle
     * result:  the updated inventory
     */
    public void removeMatchingTitle (String needle)
    {
       Deque<Item> copyStuff = new ArrayDeque<Item>(stuff);
       
       for (Item i : copyStuff)
       {
          if (i.isMyTitle(needle))
            stuff.remove(i);
       }
    }

    /*
     * purpose: remove all items with a given author
     * input:   the author needle
     * result:  the updated inventory
     */
    public void removeMatchingAuthor (String needle)
    {
       Deque<Item> copyStuff = new ArrayDeque<Item>(stuff);
       
       for (Item i : copyStuff)
       {
          if (i.isMyAuthor(needle))
            stuff.remove(i);
       }
    }
}
