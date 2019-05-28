package records;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Records extends BankRecords{
	//create formatted object to write output directly to the console and to a file
    private static FileWriter fw = null;
	public Records(){
		try {
			fw = new FileWriter("bankrecords.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args)  {
		BankRecords r = new Records();
		r.readData();
		//call analysis functions  
 
	    FemalesComparator(); //  #females with mortgages
		
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
   
		/*
		 * define FemaleComparator
		 */
	private static void FemalesComparator() {
			
			Arrays.sort(robjs,new FemalesComparator());
			int fcount = 0;
			for (int i=0;i<robjs.length;i++)
		      if (robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES")) 
				fcount++;
			//print results to console and file
			System.out.println("Number of Females with mortgages : " + fcount);
			try {
				fw.write(String.format("Number of Females with mortgages : " + fcount + "%n"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	} 	     
		  
}
