/**
 * This is my code!  Its goal is to create a person, with a name
 *    and age
 * CS 312 - Assignment 8
 * @author Mari Sisco
 */

public class Person
{
    protected int age;
    protected String name;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    //display method
    public String toString()
    {
        return name +" (age " + age + ") ";
    }

    public int compareTo(Person otherGuy)
    {
        return name.compareTo(otherGuy.name);
    }
}
