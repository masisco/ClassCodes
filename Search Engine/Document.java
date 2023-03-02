/**
* This is my code! Its goal is to read a file and convert it into a 
* document object
* CS 312 - Assignment 9
* @author Mari Sisco
*/

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Document implements Iterable<String>
{
  protected String name;
  protected String content;
  protected static final String DELIMITERPATTERN = "[^a-zA-Z]+";

  /** Creates a Document based on the contents of a file
   * @param pathString, a String containing the path to reach the file
   */
  public Document(String pathString)
  {
    readContent(pathString);

    Path p = Paths.get(pathString);
    String filename = p.getFileName().toString(); 
    this.name = filename; 
  }

  /** Reads content of a file and converts it into a String
   * @param filename, String of the path to file
   * complexity = O(n)
   */
  public void readContent(String filename)
  {
    String asRead = "";
    try
    {
      BufferedReader br;
      br = new BufferedReader(new FileReader(filename));
      asRead = new Scanner(br).useDelimiter("\\A").next();
      this.content = asRead;
      br.close();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    this.content = asRead;
  }

  /** Iterates through the content of the Document using a specific delimiter pattern
   * @return An Iterator<String> object
   * complexity = O(n)
   */
  public Iterator<String> iterator()
  {
    return new Scanner(content).useDelimiter(DELIMITERPATTERN);
  }

  /** Return the name of the document
   * @return A String, the name of the Document
   * complexity = O(1)
   */
  public String documentName()
  {
    return this.name;
  }

  /** Creates a human readable representation of the Document
   * @return A String
   */
  public String toString()
  {
    return name + ", content: \n " + content;
  }
  
}
