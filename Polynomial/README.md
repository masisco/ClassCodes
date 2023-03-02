# Polynomial, Adding + Subtracting

```
grading

OOP 83/100


You can used either the hard coded tester of the JUnit tester ... or both :)

## OOA

## OOA1

Finding classes and objects: Term and Poly

Finding attributes:

-> All polynomials store Terms as a List

-> All Terms have a coefficient and an exponent

Services:

For Poly:

-> insertAtEnd() - inserts term at the end of object

-> sortPoly - sorts terms in polynomial in descending order

-> add() - adds two polynomials together

-> addingLikeTerms() - adds like terms (terms with same exponent) together

-> multiply() - multiplies two polynomials

-> degree() - returns the highest exponent that one of the terms has

For Term:

-> compareTo() - compares the coefficient of two Terms

Finding Inheritance/delegation:

-> Poly has-a collection of terms 


## OOA2

class Poly()

Attributes:

ArrayDeque/Linked List polynomial - a list of Term objects

servies:

-> void insertAtEnd() - inserts term at the end of object

-> Poly sortPoly() - sorts terms in polynomial in descending order

-> Poly add() - adds two polynomials together, returns a Poly of addition

-> Poly addingLikeTerms() - adds like terms (terms with same exponent, e.g 2x^2 + 4x^2) together, returns poly

-> Poly multiply() - returns a Poly of the product of two polynomials (2x^2 * 3x = 6x^3, (coeff times coeff)x^(exp + exp))

-> int degree() - returns the highest exponent that one of the terms has

-> String toString() - returns a human-readable string representation of polynomial

class Term()

Attributes:

double coefficient - stores value of coefficient of term

Integer exponent - stores value of exponent of term

Services:

-> int compareTo() - compares exponent of two terms, returns either -1, 0 or 1

-> String toString() - returns a human-readable string representation of the Term 


## OOD

###class Poly
```
Deque<Term> or List<Term> polynomial - collection of Terms


/*
   * purpose: construct a polynomial, an array deque or a linked list of terms
   * input: none
   * result: initialized polynomial
   */

Poly()


/*
   * purpose: insert a Term to this polynomial at the end
   * input: none
   * result: updated polynomial 
   */

void insertAtEnd(Term t)


/*
   * purpose: sorts polynomial from Term with the highest exponent to term with the lowest exponent
   * input: none
   * result: sorted polynomial
   */


Poly sortPoly()

/*
   * purpose: using iterators, adds the terms of this polynomial with terms of another polynomial
   * input: polynomial we want to add
   * result: a polynomial, result, of addition
   */


Poly add(Poly newPoly)

/*
   * purpose: combining terms with the same exponent together
   * input: none
   * output: a polynomial with all like terms together
   */


Poly addingLikeTerms()


/*
   * purpose: multiply two polynomials together
   * input: polynomial we want to multiply by
   * result: the product of this polynomial and input polynomial
   */
 
Poly multiply(Poly newPoly)


/*
   * purpose: find the highest degree of all terms in polynomial
   * input: none
   * result: int with the highest degree
   */
 
int degree()

/*
   * purpose: produce a human-readable polynomial
   * input: none
   * result: String with representation of this polynomial
   */

  @Override

String toString()

/*
   * purpose: print a polynomial
   * input: none
   * result: String from toString()
   */

String print()
```

###class Term implements Comparable<Term>

```
double coefficient;

Integer exponent;

/*
  * purpose: construct a Term
  * input: coefficient and exponent
  * result: intialized Term
  */

Term()


/*
  * purpose: compares the exponent of two terms
  * input: term we want to compare this term to
  * result: -1, 0 or 1, depending on which term is bigger, or if they are equal.
  */
  
@Override
  
int compareTo(Term newTerm)

/*
   * purpose: produce a human-readable Term
   * input: none
   * result: String with representation of this Term
   */

  @Override

String toString()

```
## Plateau Schedule

notesL ensure each method works for both Deque and List

1. Develop class Term, which implement comparable

-> Create attributes, coefficient and exponent

-> Create constructor for class, with parameters coefficient and exponent

-> Create compareTo method, parameter another Term, which returns -1 0 or 1 depending on which Terms exponent is bigger. @Override

-> Create method toString()

2. Develop class Poly

-> Create attribute Deque/List polynomial, a collection of Terms

-> Create constructor, initializing empty list

-> Create insertAtEnd() method, inserting term at end of list, updating polynomial

-> Create degree method

-> Create sortPoly method

-> Create addingLikeTerms method

-> Create add method

-> Create multiply method

-> Create toString/print method

3. TESTING WITH TESTER, but also throughout the making of each class

4. Empirical Data Analysis done

## Empirical Data Analysis

###ArrayDeque Polynomial:

K1 = 16000000, add test took 6.732s
 
K2 = 19000, multiply term test took 9.816s

K3 = 9, multiply poly test took 5.870s

###LinkedList Polynomial:

K1 = 16000000, add test took 7.174s 

K2 = 19000, multiply term test took 12.899s 

K3 = 9, multiply poly test took  11.553ms

In general, it takes more time for LinkedLists than for ArrayDeques to perform a certain action. The complexity of the multiply poly test of LinkedList is twice the value of ArrayDeque, therefore LinkedLists are less efficient.
