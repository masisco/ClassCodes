/**
* This is my code!  Its goal is to create a set of stoplist words from a file
* CS 312 - Assignment 9
* @author Mari Sisco
*/

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Stoplist
{
  protected Set<String> stoplist;

  /** Creates a Stoplist, a set of stoplist words from a file
   * @param path, a String containing the path to the file
   */
  public Stoplist(String path)
  {
    try
    {
      List<String> asRead = Files.readAllLines(Paths.get(path));
      stoplist = new HashSet<>(asRead);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  /** Returns wether a word is a stoplist word
   * @param w, a String containing the word to find in set
   * @return A Boolean, true if the word is a stopword
   * complexity = O(1)
   */
  public boolean hasStopWord(String w)
  {
    return stoplist.contains(w);
  }
}
