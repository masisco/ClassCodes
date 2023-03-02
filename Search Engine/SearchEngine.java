/**
 * This is my code!  Its goal is to create a SearchEngine to find the documents a word query
 * is associated with
 * CS 312 - Assignment 8
 * @author Mari Sisco
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.lang.NullPointerException;

public class SearchEngine
{
  protected HashMap<String, Set<Document>> invertedIndex;
  protected Stoplist stoplist;
  protected boolean display;
  
  /** Creates a SearchEngine, containing an invertedIndex hashmap
   * @param stoplist, Stoplist with all stopwords
   * @param display, a Boolean deciding the way to display
   */
  public SearchEngine(Stoplist stoplist, boolean display)
  {
    invertedIndex = new HashMap<>();
    this.stoplist = stoplist; 
    this.display = display;
  }
  
  /** Builds the Hashmap, with a String key (the word) that is associated to a set of 
   * documents it is found in
   * @param doc, a Document to be analysed and added to invertedIndex
   * complexity = O(n)
   */
  public void buildIndex(Document doc)
  {
    Set<String> words = makeClean(doc);
    for (String w: words)
    {
      if(invertedIndex.containsKey(w))
      {
        // key of w exists
	invertedIndex.get(w).add(doc);
      }
      else
      {
        Set<Document> documents = new HashSet<Document>();
        documents.add(doc);
        invertedIndex.put(w, documents);
      }
    }
  }

  /** Removes all stop words and punctuation from the content of a document
   * @param doc, Document to be cleaned
   * @return a Set of Strings containing all the words in the document
   * complexity = O(n)
   */
  public Set<String> makeClean(Document doc)
  {
    String content = doc.iterator().toString();
    Set<String> words = new HashSet<String>();
    for(String s: doc)
    {
      if (!stoplist.hasStopWord(s) && !words.contains(s))
      {
        words.add(s);	  
      }
    }
    return words;
  }

  /** Finds query word in Hashmap
   * @param query, a String containing word to be found
   * complexity = O(1)
   */
  public void findQuery(String query)
  {
    Set<Document> querydocs = invertedIndex.get(query);
    try
    {
      display(query, querydocs);
    }
    catch(NullPointerException e)
    {
      System.out.print("Word not found in any \n");
    }
  }

  /** Displays invertedIndex Hashmap
   * complexity = O(1)
   */
  public void displayInvertedIndex()
  {
    invertedIndex.entrySet().forEach(entry -> {
    System.out.println("-> " + entry.getKey() + " FOUND IN: \n " + entry.getValue());
    });
  }

  /** Displays the documents query was found in
   * @param query, String to be found
   * @param querydocs, documents associated to the query
   * complexity = O(n)
   */
  public void display(String query, Set<Document> querydocs)
  {
    String result = "query '" + query + "' returned ";
    if(querydocs.isEmpty())
      result += "null";
    else
    {
      for (Document d: querydocs)
      {
        if (this.display == true)
          result += "\n" + d;
	else
          result += d.documentName() + " ";
      }
    }

    System.out.println(result);
    System.out.println("--- found in " + (querydocs == null ? 0 : querydocs.size())
                      + " documents");

  }

  /** Finds all documents that query words share
   * @param query, a String array with all the query words
   * @param querytofind, String query 
   * complexity = O(n)
   */
  public void findMultiWord(String [] query, String querytofind)
  {    
    ArrayList <String> words = makeClean(query);
    if (words.isEmpty())
    {
      System.out.println("No documents in common\n");
      return;
    }
    
    Set<Document> intersection = invertedIndex.get(words.get(0));
    
    for(int i = 1; i < words.size(); i++) 
    {
      Set<Document> worddocs = invertedIndex.get(words.get(i));
      try
      {	      
        intersection.retainAll(worddocs);
      }
      catch(NullPointerException e)
      {
        System.out.print("No documents in common \n");
	return;
      }
    } 
    try
    {
      display(querytofind, intersection);
    }
    catch(NullPointerException e)
    {
      System.out.print("No document contains all words\n");
    }
  }

  /** Cleans of stoplist words the string array with all the query words
   * @return An ArrayList of strings with the cleaned query words
   * complexity = O(n)
   */
  public ArrayList<String> makeClean(String [] query)
  {
    ArrayList<String> words = new ArrayList<String>();
    for(String s: query)
    {
      if (!stoplist.hasStopWord(s) && !words.contains(s))
      {
        words.add(s);
      }
    }
    return words;
  }
}

