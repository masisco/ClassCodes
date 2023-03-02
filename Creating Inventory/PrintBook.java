/**
* This is my code! Its goal is to create a PrintBook object, store its info and implement some useful methods; It extends Book
* CS 312 - Assignment 4
* @author Mari Sisco
* @version Version 1, 10/19/2022
*/
public class PrintBook extends Book
{
    protected String genre;

    /*
     * purpose: initialize a print book
     * input:   the PrinBook's title, cost, newness flag (isNew), author and genre
     * result:  the initialized PrintBook
     */
    public PrintBook(String title, double cost, boolean isNew, String author, String genre)
    {
        super(title, cost, isNew, author);
        this.genre = genre;
    }
    
    /*
     * purpose: serialize a PrintBook
     * input:   only the PrintBook
     * output:  the appropriate semi-colon representation of the book
     */
    @Override
    public String serialize()
    {
        String state = "USED";
        if (isNew)
          state = "NEW";
        return title + ";BOOK;" + cost + ";" + author + ";" + genre + ";" + state;
    }

    /*
     * purpose: generate the string representation of this book
     * input:   only the book
     * result:  the string representation of the book
     */
    @Override
    public String toString()
    {
        return "BOOK\n" + super.toString() + "\nGenre = " + genre + "\n";
    }
}
