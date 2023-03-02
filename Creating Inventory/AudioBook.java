/**
* This is my code! Its goal is to create an Item object, AudioBooK and store its information
* CS 312 - Assignment 4
* @author Mari Sisco
* @version Version 1, 10/19/2022
*/

public class AudioBook extends Book
{
    protected String reader;
    
    /*
     * purpose: initialize an audio book
     * input:   the AudioBook's title, cost, newness flag (isNew), author and genre
     * result:  the initialized AudioBook
     */
    public AudioBook(String title, double cost, boolean isNew, String author, String reader)
    {
        super(title, cost, isNew, author);
        this.reader = reader;
    }

     /*
     * purpose: serialize an AudioBook
     * input:   only the AudioBook
     * output:  the appropriate semi-colon representation of the AudioBook
     */
    @Override
    public String serialize()
    {
        String state = "USED";
        if (isNew)
          state = "NEW";
        return title + ";AUDIOBOOK;" + cost + ";" + author + ";" + reader + ";" + state;
    }

    /*
     * purpose: generate the string representation of this AudioBook
     * input:   only the audio book
     * result:  the string representation of the audio book
     */
    @Override
    public String toString()
    {
        return "AUDIOBOOK\n" + super.toString() + "\nReader = " + reader + "\n";
    }
}

