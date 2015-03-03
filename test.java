import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class test {

	 train2 t=new train2();
	 double scorep=0;
	 double scoren=0;
	 
	public test(train2 t, double scorep, double scoren)
	{
		this.t=t;
		this.scorep=scorep;
		this.scoren=scoren;
	}
	 
	 
	 public test() {
			}


	test testmulti(String s)
	{
		train2 l=t.trainmulti();
	
		try {
			Scanner sc=new Scanner(new File(s));
			
			while(sc.hasNext())
			{
				String n=sc.next();
				
				if(l.prob_p.containsKey(n))
				{
					scorep+=Math.log10(l.prob_p.get(n));
				}
				
				if(l.prob_n.containsKey(n))
				{
					scoren+=Math.log10(l.prob_n.get(n));
				}
					
				
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 
		scorep+=Math.log10(l.p_prior);
		scoren+=Math.log10(l.n_prior);
		
		System.out.println("Likelihood of doc being positive is:-" + scorep);
		System.out.println("\n Likelihood of doc being negative is:-" + scoren);
		
		
		return new test(l,scorep,scoren);
		
	}

    public static void main(String args[])
    {
    	test t=new test();
    	t.testmulti("C:\\Users\\balaji\\Desktop\\nlpreviews\\aclImdb\\test\\pos\\good.txt");
    }

}
