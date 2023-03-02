/**
 * This is my code!  Its goal is to create a table based on groups 
 *   and average ages
 * CS 312 - Assignment 8
 * @author Mari Sisco
 */
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Table
{
    protected Deque<Person> occupants;
    protected int seatsAvailable;
    protected String tableName;

    // constructor is the create method
    public Table(int seats, String name)
    {
        occupants = new ArrayDeque<>();
        seatsAvailable = seats;
        tableName = name;
    }
    public void addPerson(Person p)
    {
        occupants.add(p);
        seatsAvailable--;
    }

    public int averageAge()
    {
        int sum = 0;
        for( Person p: occupants)
        {
            sum += p.age;
        }
	if (occupants.size() == 0)
	  return 0;
        return sum/(occupants.size());
    }

    // display method
    public String toString()
    {
        String s = tableName + " : (average age " + averageAge() + ") ";
        for(Person p: occupants)
        {
            s += p + " ";
        }
        return s;
    }

    public boolean isEmpty()
    {
        return this.occupants.size() == 0;
    }

    public boolean lookupPerson(Person lost)
    {
        for(Person p: occupants)
        {
            if (p.compareTo(lost) == 0)
                return true;
        }
        return false;
    }

    public boolean spaceFor(int need)
    {
        return seatsAvailable >= need;
    }

}
