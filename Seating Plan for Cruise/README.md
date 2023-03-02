

```Grade 94/100 -- nice!!

points
   2 UML diagram
     -- Table has-a Group ... Class Table { protected Deque<Person> occupants; ...
     plateau schedule in README
     2up pdf of code
     git repo derived file check
     git log
     file headers
     oo violation / get/set
     non protected/private attributes
     correct use of .equals (e.g., rather than == )
     appropriate iterator use (e.g., not using "get(i)" favoring the foreach version)
     Deque use
     use of general type in declaration (e.e., List<..> people....)

     compiles (one point per error, max 10)
     my tester

     place group incomplete or wrong order
     format
   4 rebreak -- awkward line or page break
     src

   0 code clones
   0 first class booleans
   0 division by zero check

```



# cruise-masisco

# Plateau Schedule

1. Create Class Person

-> Create attributes, age and name

-> Create constructor

-> Create compareTo method, which compares name of two people

-> Create toString method

2. Create class Group

-> Create attribute people, a list of Person(s)

-> Create constructor

-> Create addPerson method, which adds a person to the list

-> Create averageAge method, which returns the average age of the group of people, 0 if the size is 0

-> Create size method, which returns the size of the list

-> Create toString method 

3. Create class Table

-> Create attributes occupants (a list), seatsAvailable, tableName

-> Create constructor

-> Create addPerson method, which adds a person to occupants 

-> Create averageAge method, which returns the average age of the table

-> Create isEmpty method, which returns true if the list of occupants is empty

-> Create lookupPerson method, which returns true if the person is part of that table

-> Create spaceFor method, which returns true uf there are spots left 

-> Create toString method

4. Create class DiningHall

-> Create attribute tables, a list of Table(s)

-> Create constructor

-> Create addTable method, which adds a table to the list of tables

-> Create all the helper methods: ageMatch, zeroOccupants, freeSeats, FindtableAgeRange, findTableEmpty and findTableWithFreeSeats

-> Create lookupTable method, which returns the table the person is at

-> Create placeGroup method, which first returns the tabel the group may be in, and then add each member to the table

-> Create seating chart method, which returns a string of the way the tables are distributed

5. TESTING!!!
