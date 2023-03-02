
// demo code for timing and memory use.
// try changing the constants to see what impact it has.

public class RT
{
  public static void main(String [] args)
  {
    long start = System.currentTimeMillis();
    double x = 2.0;
    for(int i=0; i<1000000; i++)
       x = x * x;

    Integer [] a = new Integer[1000]; 
    long stop = System.currentTimeMillis();
    long memoryUsed = Runtime.getRuntime().totalMemory() 
                      - Runtime.getRuntime().freeMemory();
    System.out.println("i took " + (stop -start) + "ms and used " 
                        + memoryUsed/1024 + "KB");
  }
}




