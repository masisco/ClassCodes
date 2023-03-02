/**
  * This is my code!  It's goal is to seat people in the dining hall 
  * CS 312 - Assignment 8
  * @author Dave Binkley
  */ 

// a hard-coded test driver.
//    actual HIC calls addTable, addPerson, placeGroup, etc.
//    output should go through HIC classes to make it look nice.

public class Tester
{
  public static void main(String [] args)
  {
    DiningHall dh = new DiningHall();
    dh.addTable(new Table(8, "Jane's Table "));
    dh.addTable(new Table(5, "Bill's Table "));
    // end of pre-boarding dining hall initialization 

    Group g = new Group();
    g.addPerson(new Person("dave", 31));
    g.addPerson(new Person("john", 35));
    g.addPerson(new Person("mat", 21));
    dh.placeGroup(g);
    System.out.println("TRACE 1 - added first group\n" + dh.seatingChart());

    g = new Group();
    Person p = new Person("gram", 56);
    g.addPerson(p);
    g.addPerson(new Person("grandpa", 54));
    dh.placeGroup(g);
    System.out.println("TRACE 2 - added second group\n" + dh.seatingChart());

    g = new Group();
    g.addPerson(new Person("tom", 58));
    g.addPerson(new Person("kathy", 57));
    dh.placeGroup(g);
    System.out.println("TRACE 3 - added third group\n" + dh.seatingChart());

    Table t = dh.lookupTable(p);
    if (t == null)
      System.out.println("Rats! can't find " + p);
    else
      System.out.println("Please seat " + p + "at " + t);
  }
}


/* output:
    TRACE 1 - added first group
    Seating Chart 
      Jane's Table : (average age 29) dave(age 31) john(age 35) mat(age 21) 
      Bill's Table : Empty 
    
    TRACE 2 - added second group
    Seating Chart 
      Jane's Table : (average age 29) dave(age 31) john(age 35) mat(age 21) 
      Bill's Table : (average age 55) gram(age 56) grandpa(age 54) 
    
    TRACE 3 - added third group
    Seating Chart 
      Jane's Table : (average age 29) dave(age 31) john(age 35) mat(age 21) 
      Bill's Table : (average age 56) gram(age 56) grandpa(age 54) tom(age 58) kathy(age 57) 
    
    Please seat gram(age 56) at Bill's Table 
*/
