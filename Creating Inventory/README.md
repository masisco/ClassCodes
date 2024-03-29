# CS 312 Assignment 3
# Creating Inventory

Main Method in CLI.java

# OOA1
### Finding Classes and Objects

->  NewAndUsedStuffStore, Stuff, Disk, Book, DVD, CD, PrintBook, AudioBook

### Finding Attributes (these hold state information)

->  inventory, title, price, condition, releaser year, author, studio, band, genre, reader

### Finding Services

->  add, findTitle, findAuthor, display, sell, thatsMyTitle, thatsMyAuthor, toString

### Finding Inheritance

->  Stuff is the super class. Book and Disk inherit Stuff, is-a relationship and are subclasses. DVD and CD is-a Disk(subclasses of Disk), and PrintBook and AudioBook is-a Book(subclasses of Book).

### Finding Delegation

->  Inventory has-a stuff

### Filtering

->  After filtering, Disk and Book classes are necessary. Two services to find author are provided, thatsMy lives in Book class, while findAuthor lives in Store. Similar situation is used to find title.

# OOA2

## NewAndUsedStuffStore

Attributes:

 -> inventory - an ArrayList of Stuff objects

Services:

-> add() - adds Stuff object to inventory

-> sell() - removes Stuff objects from inventory 

-> display() - displays inventory (everything, stuff with given title or books with given author)

-> findStuff() - return Stuff with a given title, useful service for display(). Utilizes thatsMyTitle

-> findAuthor() - returns Book with a given author, useful service for display(). Utilizes thatsMyAuthor()

## Stuff
-- this is an awkward name ... "a stuff" does not roll off the tung :)

Attributes:

-> title - a String representing the name of item

-> price - a double representing the price of item

-> condition - a String, representing if item is either “NEW” or “USED”

Services:

-> thatsMyTitle() - returns a boolean, whether the user input title is the name of the item.

-> toString() - returns readable String of this Stuff 

## Disk

Attributes:

-> releaseYear - an integer stating the year of release of Disk

Service

-> toString() - returns readable String of Disk object

## Book

Attributes:

-> author - a String stating the author of the Book

Service

-> thatsMyAuthor() - returns a boolean, whether the user input author is the author of the Book.

-> toString() - returns readable String of this Book

## DVD

Attribute:

-> studio - a String of the studio DVD belongs to

Service:

-> toString() - returns readable String of this DVD


## CD

Attribute:

-> band - a String of the band CD belongs to

Service:

-> toString() - returns readable String of this CD


## PrintBook

Attribute:

-> genre - a String of the genre (“sci-fi or other”) of PrintBook

Service:

-> toString() - returns readable String of this PrintBook


## AudioBook

Attribute:

-> reader - a String of the reader of this AudioBook

Service:

-> toString() - returns readable String of this AudioBook


# OOA3
## NewAndUsedStuffStore

Attributes:

 -> inventory - an ArrayList of Stuff objects

Services:

-> add() - adds Stuff object to inventory

-> sell() - removes Stuff objects from inventory 

-> display() - displays inventory (everything, stuff with given title or books with given author)

-> findStuff() - return Stuff with a given title, useful service for display(). Utilizes thatsMyTitle

-> findAuthor() - returns Book with a given author, useful service for display(). Utilizes thatsMyAuthor()

## Interface Stuff

Attributes:

-> title - a String representing the name of item

-> price - a double representing the price of item

-> condition - a String, representing if item is either “NEW” or “USED”

Services:

*-> thatsMyTitle() - returns a boolean, whether the user input title is the name of the item.*

*-> toString() - returns readable String of this Stuff*

## Disk implements Stuff

Attributes:

-> releaseYear - an integer stating the year of release of Disk

Service

*-> toString() - returns readable String of Disk object*

## Book implements Stuff

Attributes:

-> author - a String stating the author of the Book

Service

*-> thatsMyAuthor() - returns a boolean, whether the user input author is the author of the Book.*

*-> toString() - returns readable String of this Book*

## DVD extends Disk

Attribute:

-> studio - a String of the studio DVD belongs to

Service:

*-> toString() - returns readable String of this DVD*


## CD extends Disk

Attribute:

-> band - a String of the band CD belongs to

Service:

*-> toString() - returns readable String of this CD*


## PrintBook extends Book

Attribute:

-> genre - a String of the genre (“sci-fi or other”) of PrintBook

Service:

*-> toString() - returns readable String of this PrintBook*


## AudioBook extends Book

Attribute:

-> reader - a String of the reader of this AudioBook

Service:

*-> toString() - returns readable String of this AudioBook*

# plateau schedule

1. Develop abstract Item class

-> Create attributes title, cost and isNew

-> Create constructor for class, with parameters, title cost and isNew

-> Create method isMyCost, parameter needle, which returns whether the Item's cost equals needle

-> Create method isMyTitle, parameter needle, which returns whether the Item's title equals needle

-> Create abstract method isMyAuthor, parameter needle. Two subclasses (Disk and Book) will override method.

-> Create abstract serialize() method, where all subclasses will override. It produces the appropriate semi-colon String representation of each Item

-> toString method is coded.

2. Develop abstract class Disk, which extends item

-> Create attribute, releaseYear

-> Construsctor, with title, cost, isNew and releaseYear as its parameters. It will use super()

-> @Override isMyAuthor class, which returns false as Disk does not have an Author

-> @Override toString, which will use super.toString. 


3. Develop abstract class Book, which extends item

-> Create attribute author

-> Construsctor, with title, cost, isNew and author as its parameters. It will use super()

-> @Override isMyAuthor class, which returns true if needle is the author of this Book

-> @Override toString, which will use super.toString.


4. Develop concrete class CD, which extends Disk

-> Create attribute band

-> Constructor, with title, cost, isNew, releaseYear and band as parameters. Will use super()

-> @Overrile serialize()

-> @Override toString()


5. Develop concrete class DVD, which extends Disk

-> Create attribute studio

-> Constructor, with title, cost, isNew, releaseYear and studio as parameters. Will use super()

-> @Overrile serialize()

-> @Override toString()


6. Develop concrete class PrintBook, which extends Book

-> Create attribute genre

-> Constructor, with title, cost, isNew, author and genre as parameters. Will use super()

-> @Overrile serialize()

-> @Override toString()


7. Develop concrete class AudioBook, which extends Book

-> Create attribute reader

-> Constructor, with title, cost, isNew, author and reader as parameters. Will use super()

-> @Overrile serialize()

-> @Override toString()

8. Test that Items are created properly and 

-> Create tester.java

-> Initialize Item i = new CD ...

-> Ensure that toString/serialize work.


9. Develope Inventory class, which will update or display the inventory depending on the user input from CLI.

-> Create a Deque of Items called stuff, protected attribute

-> Constructor, which initializes an ArrayDeque of Item objects, stuff

-> Create add method, with Item paraemter, which adds item to Deque

-> Create serialize method, which returns String of all Items in Deque in apporpite format. Will use item.serialize();

-> Create displayMatchingTitle method, which will display items that match title, needle (parameter of function). It will make use of item.isMyTitle

-> Create displayMatchingAuthor method, which will display items that match Author, needle (parameter of function). It will make use of item.isMyAuthor

-> Create displayAll method, which will display all Items in Deque.

-> Create toString(), whcih will just call displayAll

-> Create removeMatchingTitle method, which removes item whose title = needle, parameter of method. it will use item.isMyTitle

-> Create removeMatchingAuthor method, which removes item whose author = needle, paramter of method. It will use item.isMyAuthor


10. Continue coding ItemFactory class uploaded by Dr. Binkley

-> Update switch cases, in createItem method.

-> Update else in parseItemString: should call createitem method and pass parameters after using tokenizer to breka down string S


11. Continue coding CLI class uploaded by Dr. Binkley

-> Program requieres user to input data from CLI, so processCommad method must be updated

-> Analyse each of the possible arguments that can be inputted by user


12. TESTING!!!!!!!!!!!!!!!!!!!!!!!!!!!!

# test cases

## Test Case 1

Input:       java CLI -t < testfile

Output:      usage message

Rationale:   Testing if CLI catches error when inputting incorrect string on command line

## Test Case 2

Input:       java CLI -d -t "Pride and Prejudice" < dataLong1.txt > newfile

Output:      Output to be stored in newfile as a toString representation of Item, so in newfile: Title = 

Pride and Prejudice

Cost = $7.5

Condition = USED

Author = Jane Austen

Genre = OTHER

Rationale:  Testing if display method works and if data piping, output and input stream work properly

## Test Case 3

Input:       java CLI -a DVD "Thor: The Dark World" 29.99 2013 "Marvel" false < testfile

Output:      contents of testfile + Thor: The Dark World;DVD;29.99;2013;Marvel;USED (in new line)

Rationale:   Testing if adding method works.
   
