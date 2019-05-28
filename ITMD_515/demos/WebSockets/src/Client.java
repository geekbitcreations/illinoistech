import java.io.*; 
import java.io.DataInputStream; 
import java.net.*; 
class Client 
{ 
    public static void main(String arg[])throws Exception 
    { 
        
        Socket client=new Socket("localhost",8000); 
        DataInputStream r=new DataInputStream(client.getInputStream()); 
        PrintStream w=new PrintStream(client.getOutputStream()); 
        DataInputStream in=new DataInputStream(System.in); 
            while(true) 
            { 
                System.out.println("\t\t\n[ MENU ]\n[1].Fact\n[2].Sum of Number\n[3].String operation\n[4].Exit\n\nEnter your Choice : "); 
                int choice=Integer.parseInt(in.readLine()); 
                switch(choice) 
                { 
                    case 1: System.out.println("\nEnter a Number: "); 
                        int num=Integer.parseInt(in.readLine()); 
                        w.println(choice);w.println(num);    
                        String fact=r.readLine(); 
                        System.out.print("\nFact of Number is : "+fact); 
                        break; 
                    case 2: System.out.println("\nEnter a Number:"); 
                        int num1=Integer.parseInt(in.readLine()); 
                        w.println(choice);w.println(num1);    
                        String sum=r.readLine(); 
                        System.out.print("\nSum of Number is : "+sum); 
                        break; 
                    case 3:    System.out.println("\nEnter a string:"); 
                        String str=in.readLine(); 
                        w.println(choice);w.println(str);    
                        String len=r.readLine(); 
                        System.out.print("\nLength of String is  : "+len); 
                        String rev=r.readLine(); 
                        System.out.print("\nReverse of  String : "+rev); 
                        if(str.equals(rev)) 
                        { 
                            System.out.println("\nA given String is Palindrome"); 
                        } 
                        else 
                        { 
                        System.out.println("\nA given String is not Palindrome"); 
                        } 
                        break; 
                    case 4: choice=0; 
                        w.println(choice);client.close();System.exit(0); 
                        break; 
                    default :  System.out.println("\nWrong Choice...."); 
                            break; 
                    
                } 
                
            } 
    } 
} 