import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class duplicates {
	
  public static Set<String> removeduplicate(String s)
  {
	Set<String>set=new HashSet<String>();
	
	
    try
      {
          
    	  Scanner f=new Scanner(new File(s));
    	  
          while(f.hasNext())
          {
        	  String sd=f.next();
        	  sd.toLowerCase();
        	  set.add(sd);
          }
          
        
        }
    catch(Exception e)
      {
        System.err.println("cannot read file");
      }
    return set;   
  }	
	

}
