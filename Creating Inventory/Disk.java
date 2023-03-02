/**
* This is my code! Its goal is to create a Disk object, store its info and implement some useful methods; it extends Item
* CS 312 - Assignment 4
* @author Mari Sisco
* @version 1.0, 10/19/2022
*/

abstract class Disk extends Item
{
    protected int releaseYear;

    /*
     * purpose: initialize a new disk
     * input:   the disk's title, cost, newness flag (isNew), and year released
     * output:  the initialized Disk
     */
    public Disk(String title, double cost, boolean isNew, int released) 
    {
        super(title, cost, isNew);
        releaseYear = released;
    }

    /*
     * purpose: determine if a book has a given auhor
     * input:   the author, needle
     * output:  false, as I am not a book!
     */
    @Override
    public boolean isMyAuthor(String needle)
    {
        return false;
    }
    
    /*
     * purpose: convert the Disk to a human pleasing string
     * input:   just the disk
     * output:  the disk's string representation
     */
    @Override
    public String toString() 
    {
        return super.toString() + "\nRelease year = " + releaseYear;
    }
}
