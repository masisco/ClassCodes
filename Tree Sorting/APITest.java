

import java.util.List;
import java.util.LinkedList;


public class APITest
{
  public static void main(String [] args)
  {
    List<Integer> unsorted = new LinkedList<Integer>();
    Tree<Integer> t = new Tree<Integer>(unsorted, false);
    t.sort();
  }
}
