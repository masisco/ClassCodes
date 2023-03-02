/**
* This is my code! Its goal is to create an Item object in this abstract class 
* CS 312 - Assignment 4
* @author Mari Sisco
* @version 1.0, 10/19/22
*/

abstract class Item
{
    protected String title;
    protected double cost;
    protected boolean isNew;

    /*
     * purpose: initialize a new item
     * input:   the item's title,cost, and newness flag, isNew
     * result:  the item is initialized
     */
    public Item(String title, double cost, boolean isNew)
    {
        this.title = title;
        this.cost = cost;
        this.isNew = isNew;
    }
    
    /*
     * purpose: support lookup by cost
     * input:   the target cost, needle
     * result:  true if my cost == needle
     */
    public boolean isMyCost(double needle)
    {
	return cost == needle;
    }
    
    /*
     * purpose: support lookup by title
     * input:   the target title, needle
     * result:  true if my title == needle
     */
    public boolean isMyTitle(String needle)
    {
        return title.equals(needle);
    }

    /*
     * [ needed for Java's static typing. non-Books return false ]
     * purpose: determines if a book has a given author
     * input:   the author, needle
     * result:  true if needle is my author
     */

    abstract boolean isMyAuthor(String needle);

    /*
     * [ needed for Java's static typing, so that item.serialize() compiles. ]
     * purpose: serialize an item
     * input:   only this item
     * result:  the appropriate semi-colon separated string
     */
    abstract String serialize();

    /*
     * purpose: produce a human-readable string representation of the item 
     * input:   just the item
     * result:  the item's string representation
     */
    public String toString()
    {
        String state = "USED";
	if (isNew)
	  state = "NEW";
	  
        return "Title = " + title + "\nCost = $" + cost + "\nCondition = " + state;
    }
}
