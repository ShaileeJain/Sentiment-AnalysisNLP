import java.util.*;
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.PrintStream;
	
public class stopWords {
	
	Set<String> set=new HashSet<String>();
	

	
	
	public void stopClass1(){
	   
		FileOutputStream out=null;
	    try{
	          
	    	  Scanner f=new Scanner(new File("C:\\Users\\balaji\\workspace\\SentimentAnalysis\\src\\stopwords.txt"));
	    	  Scanner fip1=new Scanner(new File("C:\\Users\\balaji\\workspace\\SentimentAnalysis\\src\\rmvNos.txt"));
	          out=new FileOutputStream("NotStopWords.txt");
	        
	          while(f.hasNext())
	          {
	        	  String s=f.next();
	        	  set.add(s);
	          }
	          
	          
	          
	        while(fip1.hasNext())
	        {
	            int flag=1;
	            String s1=fip1.next();
	            s1=s1.toLowerCase();
	           
	            if(set.contains(s1))
	               flag=0;
	                    
	         
	            if(flag!=0)
	            {
	                System.out.println(s1);
	                PrintStream p=new PrintStream(out);
	                p.println(s1);    
	            }
	                
	                                
	        }
	                    
	        }
	        catch(Exception e){
	            System.err.println("cannot read file");
	        }
	        
	    }
	
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        stopWords obj=new stopWords();
	        obj.stopClass1();

	    }

	}

