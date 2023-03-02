/**
* This is my code! Its goal is to create an Book object, store its info and implement useful methods; It extends Item
* CS 312 - Assignment 4
* @author Mari Sisco
* @version Version 1, 10/19/2022
*/

abstract class Book extends Item
{
    protected String author;

    /*
     * purpose: initialize a new book
     * input:   the book's title, cost, newness flag (isNew), and author
     * output:  the initialized Book
     */
    public Book(String title, double cost, boolean isNew, String author)
    {
        super(title, cost, isNew);
        this.author = author;
    }

    /*
     * purpose: determine if this book has a given auhor
     * input:   the author, needle
     * output:  true if needle = author
     */
    @Override
    public boolean isMyAuthor(String needle)
    {
        return author.equals(needle);
    }

     /*
     * purpose: convert the Book to a human pleasing string
     * input:   just the book
     * output:  the book's string representation
     */
    @Override
    public String toString()
    {
        return super.toString() + "\nAuthor = " + author;
    }
}
