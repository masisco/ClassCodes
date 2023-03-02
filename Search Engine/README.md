# search


```
Grade 84/100 

     OOA.pdf, OOD.pdf, and mycode.pdf
     use case diagram
     two use cases
     UML class diagram
   1 two OOA iterations
     HashMap is geek speak and thus not for the OOA
   2 two OOD iterations -- OOD1 missing

     file headers
     javadoc: comments use javadoc style
   4 javadoc: online javadoc URL working -- missing
     non protected/private attributes

   1 Map's type - good intensional choice properly declared
      -- protected HashMap<String, Set<Document>> invertedIndex
         should be
         protected Map<String, Set<Document>> invertedIndex
     Set's type - good intensional choice properly declared

   1 method complexity given for each method
     -- why is Iterator O(n) and not O(1)?
     oo violation / get/set check

   4 src
     -- why both 
        private String [] args;
        protected Boolean display;
     -- proof read the pdf for awkward page breaks and code indentation
     -- "catch(NullPointerException e)"  better to include explicit appropriate tests rath than this catch all
     -- only the CLI shoud ldo any IO  System.out.println("−> " + entry.getKey() + " FOUND IN: \n "

     - import .* :(
     - needless use of ArrayList
     - naming  e.g., "boolean flag" ... really?
     - magic numbers

     compiles
     test t1    (multi-doc test + stopword test)
     test t2    (intersection versus union test)
   1 test t3    (test that -d produces an exact copy + @@debug test)  -- @@debug test failed
   1 stress q1  -- answered 41120 of 32206 queries with first mistake at abotu 3600 
   1 stress q2  -- similar
```






my first search engine!


## Examples

The JavaDoc for the game OneRowNim can be fount at

  <a href="https://cs-312.github.io/nim"> JavaDoc served from GitHub Pages </a>
  
  <a href="http://www.cs.loyola.edu/~binkley/312/src/javadoc-examples/Nim.docs"> JavaDoc served from Linux </a>


The directory `testing` includes a simple test case.  Note that the script 
`test0` assumes that your code is in its parent directory.

