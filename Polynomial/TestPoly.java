 /*
  * This is Binkley's code!  It's goal is to test the polynomial code 
  * using jUnit.
  * CS 312 - Assignment 5
  * @author Binkley
  * @version 1.2  10/7/2022 
  */  

import org.junit.Test;
import static org.junit.Assert.*;

// for main
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

// for listener
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class TestPoly
{
  public TestPoly() {}

  @Test
  public void termTest() // might go on to test a range of powers
  {
    Term t = new Term(2, 1);
    assertEquals(t.toString(), "2.0x");
  }

  @Test
  public void emptyPolyTest()
  {
    Poly poly1 = new Poly();
    assertEquals(poly1.toString(), "0");
  }

  @Test
  public void singleTerm()
  {
    Poly poly1 = new Poly();
    poly1.insertAtEnd(new Term(5,2));
    assertEquals(poly1.toString(), "5.0x^2 ");
  }

  @Test  
  public void twoTerms()
  {
    Poly poly1 = new Poly();
    poly1.insertAtEnd(new Term(5,2));
    poly1.insertAtEnd(new Term(8,0));
    assertEquals(poly1.toString(), "5.0x^2 + 8.0 ");
  }

  @Test  
  public void middleInsertTest()
  {
    Poly poly1 = new Poly();
    poly1.insertAtEnd(new Term(5,2));
    poly1.insertAtEnd(new Term(3,1));
    poly1.insertAtEnd(new Term(8,0));
    // System.out.println("poly = poly + 3x = " + poly1);
    assertEquals(poly1.toString(), "5.0x^2 + 3.0x + 8.0 ");
  }

  @Test  
  public void addTest()
  {
    Poly poly1 = new Poly();
    poly1.insertAtEnd(new Term(5,2));
    poly1.insertAtEnd(new Term(3,1));
    poly1.insertAtEnd(new Term(8,0));
    poly1 = poly1.add(poly1);
    assertEquals(poly1.toString(), "10.0x^2 + 6.0x + 16.0 ");
  }

  @Test  
  public void polyTimesTerm() 
  {
    Poly poly1 = new Poly();
    poly1.insertAtEnd(new Term(5,2));
    poly1.insertAtEnd(new Term(8,0));
    Term term = new Term(2, 1);
    // System.out.println("times term " + poly1.multiply(term));
    assertEquals(poly1.multiply(term).toString(), "10.0x^3 + 16.0x ");
  }

  @Test  
  public void squared() // a times test
  {
    Poly poly1 = new Poly();
    poly1.insertAtEnd(new Term(5,2));
    poly1.insertAtEnd(new Term(8,0));
    // System.out.println("poly^2 = " + poly1.multiply(poly1));
    assertEquals(poly1.multiply(poly1).toString(), "25.0x^4 + 80.0x^2 + 64.0 ");
  }

  @Test  
  public void twoPloyTimesTest() 
  {
    Poly poly1 = new Poly();
    poly1.insertAtEnd(new Term(5,2));
    poly1.insertAtEnd(new Term(8,0));
    Poly poly2 = new Poly();
    poly2.insertAtEnd(new Term(1,5));
    // System.out.println("add = " + poly1.add(poly2));
    assertEquals(poly1.add(poly2).toString(), "1.0x^5 + 5.0x^2 + 8.0 ");
  }

  @Test  
  public void twoPloySymmetryTest() 
  {
    Poly poly1 = new Poly();
    poly1.insertAtEnd(new Term(5,2));
    poly1.insertAtEnd(new Term(8,0));
    Poly poly2 = new Poly();
    poly2.insertAtEnd(new Term(1,5));
    // System.out.println("add = " + poly1.add(poly2));
    assertEquals(poly2.add(poly1).toString(), "1.0x^5 + 5.0x^2 + 8.0 ");
  }

  public static void main(String[] args) 
  {
    JUnitCore runner = new JUnitCore();
    runner.addListener(new TestListener());
    Result result = runner.run(TestPoly.class);
    // w/o listener: Result result = JUnitCore.runClasses(TestPoly.class);
    // code of testRunFinished could go here ....
  }
}


class TestListener extends RunListener 
{
  public void testStarted(Description description) { }

  public void testFinished(Description description) 
  {
    // System.out.println("Finished "+ description.getMethodName());
  }

  public void testRunFinished(Result result) 
  {
    int ran = result.getRunCount();
    int failed = result.getFailureCount();

    System.out.println("Ran " + ran + " passed " + (ran-failed) 
      + (result.wasSuccessful() ? " all passed!" : " ... Failed:"));
   
    for (Failure failure : result.getFailures())
    { 
      System.out.println(failure.toString());
    }
  
  }
}
