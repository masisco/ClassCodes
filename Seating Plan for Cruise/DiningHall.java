import java.util.Deque;
import java.util.LinkedList;

/**
 * This is my code!  Its goal is to create a seating plan for 
 *    people in a cruise
 * CS 312 - Assignment 8
 * @author Mari Sisco
 */

public class DiningHall
{
  protected Deque<Table> tables;

  // create method in ood
  public DiningHall()
  {
    this.tables = new LinkedList<>();
  }

  public void addTable(Table t)
  {
    tables.add(t);
  }

  public Table lookupTable(Person p)
  {
    for(Table t: tables)
    {
       if(t.lookupPerson(p))
         return t;
    }
    return null;
  }

  public void placeGroup(Group g)
  {
    Table t = findTableAgeRange(g.averageAge(), g.size());
    if (t == null)
    {
      t = findTableEmpty(g.size());
    }
    if (t == null)
    {
      t = findTableWithFreeSeats(g.size());
    }
    if (t == null)
    {
      return;
    }
  
    for(Person p : g.people)
    {
      t.addPerson(p);
    }
  }

  //toString of seating chart
  public String seatingChart()
  {
    String s = "";
    for(Table t: tables)
      s += t + "\n";
    return s;
  }

  private boolean ageMatch(Table t, int targetAge, int seatsNeeded)
  {
    boolean x = false;
    if(t.averageAge() <= (targetAge + 5) && t.averageAge() >= (targetAge - 5))
      x = true;
  
    return !t.isEmpty() && t.spaceFor(seatsNeeded) && x;
  }

  private boolean zeroOccupants(Table t, int seatsNeeded)
  {
    return t.isEmpty() && t.spaceFor(seatsNeeded);
  }

  private boolean freeSeats(Table t, int seatsNeeded)
  {
    return t.spaceFor(seatsNeeded);
  }

  public Table findTableAgeRange(int targetAge, int seatsNeeded)
  {
    for(Table t: tables)
    {
      if(ageMatch(t, targetAge, seatsNeeded))
        return t;
    }
    return null;
  }

  public Table findTableEmpty(int seatsNeeded)
  {
    for(Table t: tables)
    {
       if(zeroOccupants(t, seatsNeeded))
         return t;
    }
    return null;
  }

  public Table findTableWithFreeSeats(int seatsNeeded)
  {
    for(Table t: tables)
    {
      if(freeSeats(t, seatsNeeded))
        return t;
    }
    return null;
  }
}
