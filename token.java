import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class token {
	
	String word;
	String wclass;
	
	public static int searchFolder(String searchPath, Pattern filePattern, String f)
	{
	   int size=0;
	   File dir = new File(searchPath);
	   int count=0;
	   for(File item : dir.listFiles())
	   {
	      if(item.isDirectory())
	      {
	            //recursively search subdirectories
	            searchFolder(item.getAbsolutePath(), filePattern,f);
	      } 
	      else if(item.isFile() && filePattern.matcher(item.getName()).matches())
	      {
	    	 
	         size+=extract(item.getAbsolutePath(),f);
	               
	         count++;
	         //System.out.println(count);
	         System.out.println(item.getAbsolutePath());
	      }
	   }
	   
	   return size;
	}
	
	
	static int extract(String s, String f)
	{
		Set<String>set=new HashSet<String>();
		
		set=duplicates.removeduplicate(s);
	
		int size=set.size();
		
		FileOutputStream out=null;
		
		try 
		{
			out=new FileOutputStream(f,true);
			
			for(String str: set)
			{
				PrintStream p=new PrintStream(out);
                p.println(str);    
			}
		
			
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		
	    	return size;
    }
	
	
	
	static int counttotaldocs(String s)
	{
		return new File(s).listFiles().length;
	}
	
	public static void main(String args[])
	{
		//System.out.println("\n Total Number:- " + counttotaldocs("C:\\Users\\balaji\\Desktop\\txt_sentoken"));
		 Pattern filePattern = Pattern.compile("(?i).*\\.txt$");
	    //searchFolder("C:\\Users\\balaji\\Desktop\\txt_sentoken\\pos",filePattern);
	}

}
