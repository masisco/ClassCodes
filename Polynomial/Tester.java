/**
  * This is Binkley's code!  It's goal is to test the polynomial code.
  * CS 312 - Assignment 5
  * @author Binkley
  * @version 1.2  10/15/2022
  */  

// Squidward's test driver for Assignment 5 "Poly want a nomial?"

/* 
 * purpose: test the polynomial class (including a stress test)
 * input:   nada
 * result:  output from a series of polynomial additions and multiplications
 */
class Tester
{
  public static void main(String [] args)
  {
    Poly poly1 = new Poly();
    System.out.println("poly = " + poly1);

    poly1.insertAtEnd(new Term(5,2));
    System.out.println("poly = " + poly1);

    poly1.insertAtEnd(new Term(8,0));
    System.out.println("poly = " + poly1);

    System.out.println("poly^2 = " + poly1.multiply(poly1));

    Poly poly2 = new Poly();
    poly2.insertAtEnd(new Term(3,1));
    poly1 = poly1.add(poly2);
    System.out.println("poly = poly + 3x = " + poly1);

    Poly p = poly1.add(poly1);
    System.out.println("p = poly + poly = " + p);

    Poly p2 = new Poly();
    p2.insertAtEnd(new Term(1,5));
    System.out.println("p2 = " + p2);
    System.out.println("p + p2 = " + p.add(p2));
    System.out.println("p2 + p = " + p2.add(p)); 

    Term t = new Term(2, 1);
    System.out.println("t = " + t);
    Poly testing = new Poly();
    testing.insertAtEnd(t);
    Poly pp = p.multiply(testing);
    System.out.println("p*t = " + p + " * " + t + " = " + pp);

    long startTime, time, memoryUsed;

    startTime = System.currentTimeMillis();
    time = startTime;
    memoryUsed = Runtime.getRuntime().totalMemory() 
                 - Runtime.getRuntime().freeMemory();
    System.out.println("start stress test starts at " + startTime +
      "ms, using " + memoryUsed/(1024*1024) + "Mb");

    // stress test!
    int K1 = 16000000;
    int K2 = 19000;
    int K3 = 9;

    // at this point you will get better data if you only perform one of 
    // the following stress tests at a time!
    // consider adding support for command-line selection:
    //  System.out.println("stress test usage: java Tester add | term | poly");

   /* 
    for(int i=0; i<K1; i++)
      pp = pp.add(pp);

    time = System.currentTimeMillis();
    memoryUsed = Runtime.getRuntime().totalMemory() 
                 - Runtime.getRuntime().freeMemory();
    System.out.println("post add test took " + (time - startTime) 
      + "ms, using " + memoryUsed/(1024*1024) + "Mb");
    System.out.println("pp.degree = " + pp.degree() );
*/

    /*
    startTime = time;
    pp = p.multiply(testing);
    for(int i=0; i<K2; i++)
       pp = pp.multiply(testing);

    time = System.currentTimeMillis();
    memoryUsed = Runtime.getRuntime().totalMemory() 
                 - Runtime.getRuntime().freeMemory();
    System.out.println("post multiply term test took " + (time - startTime) 
      + "ms, using " + memoryUsed/(1024*1024) + "Mb");
    System.out.println("pp.degree = " + pp.degree() );
   */

    startTime = time;
    pp = p.multiply(testing);
    for(int i=0; i<K3; i++)
      pp = pp.multiply(pp);

    time = System.currentTimeMillis();
    memoryUsed = Runtime.getRuntime().totalMemory() 
                 - Runtime.getRuntime().freeMemory();

    System.out.println("post multiply poly test took " + (time - startTime) 
      + "ms, using " + memoryUsed/(1024*1024) + "Mb");
    System.out.println("pp.degree = " + pp.degree() );
  
  }
}

