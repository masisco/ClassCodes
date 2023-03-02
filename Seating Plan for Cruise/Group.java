/**
 * This is my code!  Its goal is to create a group of people 
 * CS 312 - Assignment 8
 * @author Mari Sisco
 */


import java.util.Deque;
import java.util.ArrayDeque;

public class Group
{
    protected Deque<Person> people;

    public Group()
    {
        people = new ArrayDeque<Person>();

    }

    public void addPerson(Person p)
    {
        people.add(p);
    }

    public int averageAge()
    {
        int sum = 0;
        for(Person p: people)
            sum = sum + p.age;
        return sum/size();
    }

    public int size()
    {
        return people.size();
    }

    public String toString()
    {
        String s = "(average age " + averageAge() + ") ";

        for(Person p: people)
            s += "-> " + p + "\n";

        return s;
    }
}

