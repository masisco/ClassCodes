/**
  * This is my code! Its goal is to create a polynomial, where addition and 
  * multiplication may occur
  * CS 312 - Assignment 5
  * @author Mari Sisco
  */

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.lang.Iterable;

public class Poly
{
  //protected Deque<Term> polynomial;
  protected List<Term> polynomial;

  /*
   * purpose: construct a polynomial, an array deque or a linked list of terms
   * input: none
   * result: initialized polynomial
   */
  public Poly()
  {
    //polynomial = new ArrayDeque<>();
    polynomial = new LinkedList<>();
  }

  /*
   * purpose: insert a Term to this polynomial at the end
   * input: none
   * result: updated polynomial 
   */
  public void insertAtEnd(Term t)
  {
    polynomial.add(t);
  }

  /*
   * purpose: sorts polynomial from Term with the highest exponent to term with 
   *          the lowest exponent
   * input: none
   * result: sorted polynomial
   */
  public Poly sortPoly()
  {
     Poly result = new Poly();
     for (Integer i = degree(); i>= 0 ; i--)
     {
       for (Term t : polynomial)
       {
         if (t.exponent.compareTo(i) == 0)
           result.insertAtEnd(t);
       }
     }
     return result;
  }

  /*
   * purpose: adds the terms of this polynomial with terms of another polynomial
   * input: polynomial we want to add
   * result: a polynomial, result, of addition
   */
  public Poly add(Poly newPoly)
  {
    Poly result = new Poly();
    
    Poly polynomial = sortPoly();
    newPoly = newPoly.sortPoly();
    
    Iterator<Term> i1 = this.polynomial.iterator();
    Iterator<Term> i2 = newPoly.polynomial.iterator();
    
    if (polynomial == null)
      return newPoly;
    
    else if (newPoly == null)
        return polynomial;    
    else
    {
      while(i1.hasNext() && i2.hasNext())
      {
        Term t1 = i1.next();
        Term t2 = i2.next();
      
        if( t1.exponent.compareTo(t2.exponent)  == 0)
        {
	  Term t3 = new Term (t1.coefficient + t2.coefficient, t1.exponent);
      	  result.insertAtEnd(t3);
        }
        else if( t1.exponent.compareTo(t2.exponent) == 1)
        {
          result.insertAtEnd(t1);
	  result.insertAtEnd(t2);
        }
        else if (t1.exponent.compareTo(t2.exponent) == -1)
        {
          result.insertAtEnd(t2);
	  result.insertAtEnd(t1);
        }
      }

      //inserting remaining Terms
      if (i1.hasNext())
      {
        while(i1.hasNext())
        {
          result.insertAtEnd(i1.next());
        }
      } 

      else if(i2.hasNext())
      {
        while(i2.hasNext())
        {
          result.insertAtEnd(i2.next());
        }
      }
    }
    
    result = result.sortPoly();
    result = result.addingLikeTerms();

    return result;
  }

  /*
   * purpose: combining terms with the same exponent together
   * input: none
   * output: a polynomial with all like terms together
   */
  public Poly addingLikeTerms()
  {
    Poly result = new Poly();

    Iterator<Term> i1 = this.polynomial.iterator();
    Iterator<Term> i2 = this.polynomial.iterator();

    i2.next();

    while(i1.hasNext() && i2.hasNext())
    {
      Term t1 = i1.next();
      Term t2 = i2.next();

      if(t1.exponent.compareTo(t2.exponent) == 0)
      {
        result.insertAtEnd(new Term(t1.coefficient + t2.coefficient, 
				t1.exponent));
        if(i1.hasNext())
	{
	  i1.next();
	}
	if(i2.hasNext())
	{
          i2.next();
	}
      }
      else
        result.insertAtEnd(t1);
    }

    if(i1.hasNext())
    {
      result.insertAtEnd(i1.next());
    }
    else if (i2.hasNext())
    {
      result.insertAtEnd(i2.next());
    }

    return result;
  }


  /*
   * purpose: multiply two polynomials together
   * input: polynomial we want to multiply by
   * result: the product of this polynomial and input polynomial
   */
  public Poly multiply(Poly newPoly)
  {
    Poly polinomial = sortPoly();
    newPoly = newPoly.sortPoly();

    Poly result = new Poly();
    Poly finalResult = new Poly();

    for (Term t1 : newPoly.polynomial)
    {
      Iterator<Term> itr = this.polynomial.iterator();
      while(itr.hasNext())
      {
	Term t2 = itr.next();
	Term product = new Term(t1.coefficient * t2.coefficient , 
			t1.exponent + t2.exponent);
	result.insertAtEnd(product);
      }

      finalResult = finalResult.add(result);
      result.polynomial.clear();
    }

     finalResult = finalResult.sortPoly();
     finalResult = finalResult.addingLikeTerms();
     return finalResult;
  }

  /*
   * purpose: find the highest degree of all terms in polynomial
   * input: none
   * result: int with the highest degree
   */
  public int degree()
  {
    int highestDegree = 0;
    for( Term t : polynomial)
    {
      if(t.exponent > highestDegree)
        highestDegree = t.exponent;
    }
    return highestDegree;
  }

  /*
   * purpose: produce a human-readable polynomial
   * input: none
   * result: String with representation of this polynomial
   */
  @Override
  public String toString()
  {
    String s = "";
    for(Term t: polynomial)
    {
      s += " " + t + " +";
    }
    if (s.length() == 0)
      return s;
    else
      return s.substring(0, s.length()  - 1);
  }

  /*
   * purpose: print a polynomial
   * input: none
   * result: String from toString()
   */
  public String print()
  {
    return toString();
  }
}

