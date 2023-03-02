/**
* This is my code! Its goal is to create a CD object, store its info and implement some useful methods; It extends Disk
* CS 312 - Assignment 4
* @author Mari Sisco
* @version Version 1, 10/19/2022
*/

public class CD extends Disk
{
    protected String band;

    /*
     * purpose: initialize a CD
     * input:   the CD's title, cost, newness flag (isNew), year released, and band
     * result:  the initialized CD
     */
    public CD(String title, double cost, boolean isNew, int releaseYear, String band)
    {
        super(title, cost, isNew, releaseYear);
        this.band = band;
    }

    /*
     * purpose: serialize a CD
     * input:   only the CD
     * output:  the appropriate semi-colon representation of the CD
     */
    @Override
    public String serialize()
    {
	String state = "USED";
	if (isNew)
	  state = "NEW";
        return title + ";CD;" + cost + ";" + releaseYear + ";" + band + ";" + state;
    }

    /*
     * purpose: generate the string representation of this CD
     * input:   only the CD
     * result:  the string representatio =n of the CD
     */
    @Override
    public String toString()
    {
        return "CD\n" + super.toString() + "\nBand = " + band + "\n";
    }
}
