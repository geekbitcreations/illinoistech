package jtest;
import java.util.Scanner;
 
public class BinPacking {

    public static void main(String[] args) {
            
    	    //set vars
    	    int g,l,m,s,num;
    	    
    	    //init vars
    		g = l = m = s = 0;

		    //Declare Scanner object
    		Scanner sc=new Scanner(System.in);  
    		
    		//get user input 
    		System.out.println("enter cells to box");  
    		num=sc.nextInt(); 

			//perform calculations for best fit
			g = num / 50;    
			l = (num % 50) / 25;
			m = (num % 25) / 10;
			s = (num % 50) % 25 % 10; 
					
			//display optimal result
		
			System.out.println("g = " + g + " l = " + l + " m = " + m + " s = " + s);
	}
}
