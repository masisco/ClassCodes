/**
* This is my code! Its goal is to create a DVD object, store its info and implement some useful methods; It extends Disk
* CS 312 - Assignment 4
* @author Mari Sisco
* @version Version 1, 10/19/2022
*/

public class DVD extends Disk
{
    protected String studio;
    
    /*
     * purpose: initialize a DVD
     * input:   the DVD's title, cost, newness flag (isNew), year released, and the studio
     * result:  the initialized DVD
     */
    public DVD(String title, double cost, boolean isNew, int releaseYear, String studio)
    {
        super(title, cost, isNew, releaseYear);
        this.studio = studio;
    }

     /*
     * purpose: serialize a DVD
     * input:   only the DVD
     * output:  the appropriate semi-colon representation of the DVD
     */
    @Override
    public String serialize()
    {
        String state = "USED";
        if (isNew)
          state = "NEW";
        return title + ";DVD;" + cost + ";" + releaseYear + ";" + studio + ";" + state;
    }

    /*
     * purpose: generate the string representation of this DVD
     * input:   only the DVD
     * result:  the string representation of the DVD
     */
    @Override
    public String toString()
    {
        return "DVD\n" + super.toString() + "\nStudio = " + studio  + "\n";
    }
}
