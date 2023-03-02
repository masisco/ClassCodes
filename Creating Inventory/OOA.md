# CS 312 Assignment 3
# stuff

[Assignment ](https://moodle.loyola.edu/mod/resource/view.php?id=3450022)

Emma Smith

Aidan Shaughnessy

Maria Sisco

## OOA

## OOA1

Finding classes and objects: 
	DVD, CD, PrintBook, AudioBook

Finding attributes: 
	All items have a title, price, and condition (new or used). 
	DVD has release year, studio. 
	CD has release year, band. 
	PrintBook has author, genre (sci-fi or other). 
	AudioBook has author, reader. 

Finding services: 
	add(), add a item  object to the inventory. 
	display(), display all item objects, can be displayed by a given title or author. 
	sell(), removes all item objects from inventory if they match a given title or author. 

Finding inheritance: 
	DVD and CD is-a Disc. 
	PrintBook and AudioBook is-a Book. 
	Disc and Book is-a item. 
	A collection of item is a NewAndUsedStuffStore. 

Finding delegation: 
	NewAndUsedStuffStore has-a collection of items. 

## OOA 2

class newAndUsedStuffStore()

	attributes
	a list inventory. A list of item objects.

	services
	void add(). Adds a new item object to the inventory ArrayList.
	item findTitle(String title). Returns an item object corresponding to inputted title.
	item findAuthor(String name). Returns an item object corresponding to inputted name.
	void display(). Displays either the entire inventory, the item(s) that correspond to a 
		given title, or the books that correspond to a given author.
	void sell(). Removes all item objects correspondng to a given title or author from 
		the inventory ArrayList.

class item()

	attributes
	String title. The title of the item object.
	double price. The numerical price of the item object.
	String condition. The state of the item object : new or used.

	services
	boolean thatsMyTitle(String searchTitle). Returns true if item object's title matches 
		searchTitle.
	String toString(). Returns a human-readable string representation of the item object.

class disc() extends item()

	attributes
	int releaseYear. The numerical year that the item object was released.

	services
	String toString. Returns a human-readable string representation of the disc.

class DVD() extends disc()

	attributes
	String studio. The studio where the DVD was produced.

	services
	String toString(). Returns a human-readable string representation of the DVD. 
		Uses @Override. May use super().

class CD() extends disc()
	
	attributes 
	String band. The name of the band whose music is on the CD.

	services
	String toString. Returns a human-readable string representation of the CD. 
		Uses @Override. May use super().

class book() extends item()
	
	attributes
	String author. The name of the author of the book.
	
	services
	String toString(). Returns a human-readable string representation of the book.

class printBook() extends book()

	attributes
	String genre. The genre of the book : sci-fi or other.
	
	services
	String toString(). Returns a human-readable string representation of the printBook. 
		Uses @Override. May use super().

class audioBook() extends book()

	attributes
	String reader. The reader of the audioBook.

	services
	String toString(). Returns a human-readable string representation of the audioBook. 
		Uses @Override. May use super().


