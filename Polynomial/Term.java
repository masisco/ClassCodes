/**
  * This is my code! Its goal is to create a term, containing a coefficient 
  * and an exponent
  * CS 312 - Assignment 5
  * @author Mari Sisco
  */

public class Term implements Comparable<Term>
{
  protected double coefficient;
  protected Integer exponent;

 /*
  * purpose: construct a Term
  * input: coefficient and exponent
  * result: intialized Term
  */
  public Term(double coefficient, int exponent)
  {
    this.coefficient = coefficient;
    this.exponent = exponent;
  }

 /*
  * purpose: compares the exponent of two terms
  * input: term we want to compare this term to
  * result: -1, 0 or 1, depending on which term is bigger, or if they are 
  *         equal.
  */
  @Override
  public int compareTo(Term newTerm)
  {
    return this.exponent.compareTo(newTerm.exponent);
  }

  /*
   * purpose: produce a human-readable Term
   * input: none
   * result: String with representation of this Term
   */
  public String toString()
  {
    if(exponent == 1)
      return coefficient + "x";
    if(exponent == 0)
      return coefficient + "";

    return coefficient + "x^" + exponent;
  }

}
