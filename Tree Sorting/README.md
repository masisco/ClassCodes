# Tree Sorting


## Mari Sisco, in collaboration with Emma Smith and Aidan Shaughnessy


## One Paragraph Requirements Summary

For this assignment, I am requiered to understand the concept of building trees from the leaves to the top in order to sort a list of objects. The list should accept generic data values, however the command line interface should focus on sorting integers. Class Tree is needed, containing a linkedlist attribute of objects to be sorted. A nested Node class is inside of tree class. Driver class, aka CLI, is also needed.


## OOA1

Finding classes and objects: Tree, Node (nested in Poly), Driver

Finding attributes:

-> Tree stores values as a list, and has a debug boolean

-> Node stores date E of the node, and its right and left children

-> Driver stores the string arguments of CLI, and a boolean of timing and debugging

Services:

For Tree:

-> sort() - sorts values in tree 

-> promote() - combines two nodes, with smallest being promoted

-> atRoot() - outputs root value and promotes the two children

For Node:

-> bothAreNull() - checks if both nodes are null

-> leftINull() - checks if left node is null

-> rightIsNull() - checks if right node is null

-> noneAreNull() - checks if neither are null

-> compareTo() - compares coefficient of two terms

For Driver:

-> usage() - shows usage message

-> parse() - analyses commands from user and performs task

Finding Inheritence/ delegation

-> Tree contains generic types E that extend comparable

-> Tree has-a collection of values, a LinkedList

## OOA2

class Tree()

Attributes:

LinkedList list - stores values to be sorted

boolean debug - true if user wishes to see how tree is built

services:

-> List<E> sort() - returns sorted list

-> Node promote() - returns combined node made up of two nodes, with the smallest being promoted

-> List<E> atRoot() - returns sorted data by breaking down tree from root

-> String toString() - returns a human-readable string representation of Tree

Nested class Node()
  
Attributes:

E data - contains the data Node is storing

Node left - contains left child, a Node

Node right - contains right child, a Node

services:
  
-> boolean bothAreNull() - returns true if both nodes are null

-> boolean leftINull() - returns true if left node is null

-> boolean rightIsNull() - returns true if right node is null

-> boolean noneAreNull() - returns true if neither are null

-> int compareTo() - compares coefficient of two terms, returns int. return an int > 0 if node > otherGuy, < 0 if node < otherGuy, = 0 if node = otherGuy
 
-> String toString() - return human-readable string representation of the Node

## OOD1

### class Tree<E extends Comparable<E>>

```
List<E> list - stores values of generic type to be sorted

boolean debug - true if user wishes to see how tree is built
 
/*
    * purpose: initializes an empty tree
    * input:   none
    * result:  a Tree with nothing in it
    */

Tree()

 
/*
    * purpose: constructs a tree from a List of generic items
    * input:   the list and a debug flag
    * result:  a Tree with this.list = list. If debug == true print status information
    */

Tree(List<E> list, Boolean debug)  


/*
    * purpose: sort tree
    * input:   just the tree and the list
    * result:  the sorted list
    */
 
List<E> sort()
  

/* 
    * purpose: combine two Nodes into one while promoting the smallest Node
    * input:   nodes to be combined, n1 and n2
    * result:  promoted node with n1 and n2
    */

Node promote(Node n1, Node n2)
  

/*
    * purpose: At root, output root value and promote the two children
    * input:   node n
    * result:  List<E> of the sorted data
    */    

List<E> atRoot(Node n)
 

/*
    * purpose: create a human readable representation of a Tree
    * input:   none
    * result:  a String representation of the tree
    */
 
@Override

String toString()
```

### class Node
```
E data - contains the data Node is storing

Node left - contains left child, a Node

Node right - contains right child, a Node

/*
    * purpose: instantialize a Node
    * input:   none
    * result:  an empty node
    */

Node()


/*
    * purpose: construct a Node
    * input:   E data, Node left, Node right
    * result:  this node
    */

Node(E data, Node left, Node right)
  

/*
    * purpose: tell whether both children are null
    * input:   none
    * result:  true if both are null
    */
  
boolean bothAreNull()
  
  
/*
    * purpose: tell whether left is null and right is not null
    * input:   none
    * result:  true if left is null and right is not null
    */
	
boolean leftIsNull()
  

/*
    * purpose: tell whether left is not null and right is null
    * input:   none
    * result:  true if left is not null and right is null
    */
	
boolean rightIsNull()


/*
    * purpose: tell whether neither children are null
    * input: none
    * result: true if both are null
    */

boolean noneAreNull()
  

/*
    * purpose: compare data of two nodes
    * input: none
    * result: >0 if node > otherGuy, <0 if node < otherGuy, = 0 if node = otherGuy
    */
	
int compareTo(Node otherGuy)

  
/*
    * purpose: create a human readable representation of a node
    * input: none
    * result: a string represntation of the node
    */
  
@Override

String toString()
```
### class Driver
```
String [] args - string arguments from command line
Boolean debug - true if user wishes to see how tree is built
Boolean timeit - true if user wishes to get the time taken for sorting to take place

  
/*
     * purpose: construct Driver class
     * input:   CLI arguments as a String Array
     * result:  updates private variable args, sets debug and timeit to false
     */

Driver(String [] a)


  /* 
     *purpose: print out usage aka menu with options
     * input:   none
     * results: prints menu in CLI
     */

void usage()
  
  
/*
     * purpose: process the user's command
     * input:   none, uses private String array
     * result:  sorts a list of user-enetered numbers or of n random numbers. 
     *          It is optional to time how long it took and to print the sorting process
     */

void parse()

  
/*
     * purpose: run the program
     * input:   command from the user (taken from the command line)
     * result:  perfomrs task depending on the command entered by user
     */

static void main(String [] args)
  
```
## Plateau Schedule

1. Create class Tree

-> Create attributes, list and debug

-> Create constructor for class

2. Before continuing, create nested class Node

-> Create attibutes, data, right and left

-> Create constructor for class

-> Create bothAreNull method

-> Create rightIsNull method

-> Create leftIsNull method

-> Create noneAreNull method

-> Create compareTo method, >0 if node > otherGuy, <0 if node < otherGuy, = 0 if node = otherGuy

-> toString method

3. Continue with Tree class

-> Create promote method for nodes

-> Create atRoot method, which will call promote

-> Create sort method. It will call promote and atRoot

4. Create Driver (which is the CLI)

-> Create attibutes: args, debug and timeit

-> Create constructor

-> Create usage method, which prints out usage aka menu with options

-> Create parse method, that processes the user's command

5. TESTING using Driver, meaning CLI, but also test through the creation of each class, specifically promoting and atRoot

## Test Plan

-> Main Tests will happen with java Driver 

### Test Case 1

Input: java CLI -x

Output: usage message, Usage: [-d|-t]  -n <numbers> | -r <count>

Rationale: Testing if Driver catches error when inputting incorrect string on command line

	
### Test Case 2

Input: java Driver -d -t -n 4 89 76 5 63 35 42 12 10 7 19

Output: the time taken for sorting to take place, the debugging should happen and a sorted list 

Rationale: Testing if debugging, time and sorting all work, [4, 5, 7, 10, 12, 19, 35, 42, 63, 76]

### Test Case 3

Input: java Driver -d -n 4

Output: [4]

Rationale: Testing if sorting one item works

	
### Test Case 4
	
Input: java Driver -t -r 89

Output: Sorting took x milliseconds

Rationale: Testing if time taken for random integers works
	

### Test Case 5
	
Input: java Driver -t -d -r 5

Output: Sorting took x milliseconds, also a sorted list and the debugging

Rationale: Testing if rnadoom integers are correctly sorted. Also swapping order of -d and -t to see if it works.
	
## Data Analysis

N = largest number of random values program can sort in 5 seconds

N = 2050000, took 5.012 seconds

when...

2N = 4100000, took 10.970 seconds

4N = 8200000, took 23.279 seconds

8N = 16400000, took 54.596 seconds

-> This is showing how n doubles, the nnumber of time taken to sort also almost doubles. This means that there is almost an O(n) complexity in sort.
