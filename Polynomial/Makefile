  
Tester.class: Tester.java
	javac Tester.java 

TestPoly.class: TestPoly.java
	javac TestPoly.java

Grader.class: Grader.java
	javac Grader.java

Poly.class: Poly.java
	javac Poly.java

Term.class: Term.java
	javac Term.java

test: Tester.class Poly.class Term.class
	javac Tester.java 
	java Tester add
	java Tester term
	java Tester poly


junit: TestPoly.class Poly.class Term.class
	java TestPoly

.PHONY: clean
clean:
	/bin/rm *class

.PHONY: print
print:
	a2ps --delegate=no -T 4 -q -Avirtual -2 -L 70 -o xd FIX ME

.PHONY: handout
handout:
	a2ps --delegate=no -T 4 -q -Avirtual -2 -L 70 -o xd FIX ME


