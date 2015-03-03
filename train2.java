import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.*;



public class train2 {
	
    int v;
	
	 HashMap<String, Integer> hashp;
	 HashMap<String, Integer> hashn;
	 HashMap<String, Double> prob_p;
	 HashMap<String, Double> prob_n;
	
	 double p_prior;
	 double n_prior;
	
	 double dd;

	 
	 
	 train2(int v,HashMap<String, Integer> hashp, HashMap<String, Integer> hashn,HashMap<String, Double> prob_p, HashMap<String, Double> prob_n,double p_prior,double n_prior)
	{
		this.v=v;
		this.hashp=hashp;
		this.hashn=hashn;
		this.prob_p=prob_p;
		this.prob_n=prob_n;
	    this.p_prior=p_prior;
	    this.n_prior=n_prior;
	}
	
     public train2() {
		// TODO Auto-generated constructor stub
	}

	train2 trainmulti()
	{
	  	int np=token.counttotaldocs("C:\\Users\\balaji\\Desktop\\nlpreviews\\aclImdb\\train\\pos");
	  	int nn=token.counttotaldocs("C:\\Users\\balaji\\Desktop\\nlpreviews\\aclImdb\\train\\neg");
	  	int n=np+nn;
	  	
	    p_prior=(float)np/n;
	    dd=p_prior;
	  	dd=(float)np/n;
	  	
	  	//p_prior=Math.log(p_prior);
	    n_prior=(float)nn/n;
	    double dd=(float)nn/n;
	    //n_prior=Math.log(n_prior);
	    
	 
	  	Pattern filePattern = Pattern.compile("(?i).*\\.txt$");
	    int psize=token.searchFolder("C:\\Users\\balaji\\Desktop\\nlpreviews\\aclImdb\\train\\pos",filePattern,"finalpos.txt");
	    int nsize=token.searchFolder("C:\\Users\\balaji\\Desktop\\nlpreviews\\aclImdb\\train\\neg",filePattern,"finalneg.txt");

	    hashp= new HashMap<String, Integer>();
	    hashn= new HashMap<String, Integer>();
	    
	  
	    
	    
	    
	    try
	      {
	          
	    	  Scanner f=new Scanner(new File("C:\\Users\\balaji\\workspace\\naiive bayes text classification\\finalpos.txt"));
	    	  
	          while(f.hasNext())
	          {          
	        	  String sd=f.next();
	              if(hashp.containsKey(sd))  
	              {
	            	  int count=hashp.get(sd);
	            	  count++;
	            	  hashp.put(sd, count);
	              }
	              else 
	              {
	            	  hashp.put(sd, 1);
	              }
	        	 
	          }
	          
	        
	        }
	    catch(Exception e)
	      {
	        System.err.println("cannot read file");
	      }
	    
	    
	    try
	      {
	          
	    	  Scanner f=new Scanner(new File("C:\\Users\\balaji\\workspace\\naiive bayes text classification\\finalneg.txt"));
	    	  
	          while(f.hasNext())
	          {          
	        	  String sd=f.next();
	              if(hashn.containsKey(sd))  
	              {
	            	  int count=hashn.get(sd);
	            	  count++;
	            	  hashn.put(sd, count);
	              }
	              else 
	              {
	            	  hashn.put(sd, 1);
	              }
	        	 
	          }
	          
	        
	        }
	    catch(Exception e)
	      {
	        System.err.println("cannot read file");
	      }
	    
	       Set keysp=hashp.keySet();
		   Set keysn=hashn.keySet();
		   
		   keysp.retainAll(keysn);
		   
		   v=hashp.size()+hashn.size()-keysp.size();
	    
	    
	    
	    prob_p= new HashMap<String, Double>();
	    prob_n= new HashMap<String, Double>();
	    
	    Iterator itp = hashp.entrySet().iterator();
	   
	    
	    while (itp.hasNext()) 
	    {
	        Map.Entry pairs = (Map.Entry)itp.next();
	        String name=(String) pairs.getKey();
	        
	        Integer i=(Integer)pairs.getValue();
	        
	        double probp= (double)(i+1)/(double)(psize+v);
	        //probp=Math.log(probp);
	        prob_p.put(name, probp);
	        
	    }
	    
	    Iterator itn = hashn.entrySet().iterator();
		   
	    while (itn.hasNext()) 
	    {
	        Map.Entry pairs = (Map.Entry)itn.next();
	        String name=(String) pairs.getKey();
	        
	        Integer i=(Integer)pairs.getValue();
	        
	        double probn= (double)(i+1)/(double)(nsize+v);
	        //probn=Math.log(probn);
	        prob_n.put(name, probn);
	        
	    }
	    
	    
	    System.out.println("Vocab= " +v);
	    System.out.println("pos prior " +p_prior);
	    System.out.println("neg prior= " +n_prior);
	    
	    System.out.println("\n \n \n \n double dd is :" + dd);
	    
	    
	    System.out.println("The values in pos hashprob:-\n");
	    
	    Iterator itpp = prob_p.entrySet().iterator();
		   
	    
	    while (itpp.hasNext()) 
	    {
	        Map.Entry pairs = (Map.Entry)itpp.next();
	        String name=(String) pairs.getKey();
	        
	        Double d=(Double)pairs.getValue();
	        
	        System.out.println("word:- " +name);
	        System.out.println("prob:- " +d + "\n");
	        
	    }
	    
	    
	    System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n");
	  	System.out.println("1ST P PRIOR= "+ p_prior +"because np is "+ np +" and n is " +n);
		System.out.println("1st n PRIOR= "+ n_prior +"because nn is "+ nn +" and n is " +n);
		
	  	System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n");
	  
	    
	    
	    return new train2(v,hashp,hashn,prob_p,prob_n,p_prior,n_prior);
	    
	}

}
