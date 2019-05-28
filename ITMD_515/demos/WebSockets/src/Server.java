import java.io.*; 
import java.io.DataInputStream; 
import java.net.*; 
class Server 
{ 
    public static void main(String[] arg)throws Exception 
    { 
        
        ServerSocket server=new ServerSocket(8000); 
        System.out.printf("\nServer Started SuccessFully"); 
        Socket client=server.accept(); 
        DataInputStream r=new DataInputStream(client.getInputStream()); 
        PrintStream w=new PrintStream(client.getOutputStream()); 
        DataInputStream in=new DataInputStream(System.in); 
        while(true) 
        { 
            
            int choice=Integer.parseInt(r.readLine()); 
            String data=r.readLine(); 
            switch(choice) 
            { 
                case 1: 
                    int num=Integer.parseInt(data); 
                    int fact=1; 
                    while(num>0) 
                    { 
                        fact=fact*num--; 
                    } 
                    w.println(fact); 
                    System.out.printf("\nFact is calculated and send back to Client...\n"); 
                    break;    
                case 2: 
                    int num1=Integer.parseInt(data); 
                    int sum=1; 
                    sum=sum+num1;
                    w.println(sum); 
                    System.out.printf("\nSum of number is calculated and send back to Client...\n"); 
                    break; 
                case 3: 
                    w.println(data.length()); 
                    StringBuffer buffer = new StringBuffer(data); 
                    w.println(buffer.reverse()); 
                    System.out.printf("\nString Operations are done and send back to Client...\n"); 
                    break; 
                case 0:server.close();System.exit(0);break;    
            } 
        } 

    } 
}  