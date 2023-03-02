# Cruise Seating Plan

Main Method in tester.java

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
