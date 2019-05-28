import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRecords 
               extends Students
{
//create objects for processing
	StudentRecords rObjs[];
	List<List<String>> array = new ArrayList<List<String>>();
	
//members
	String name;
	int age;
	String lesson;
	int grade;
	

public StudentRecords[] getrObjs() {
		return rObjs;
	}

	public void setrObjs(StudentRecords[] rObjs) {
		this.rObjs = rObjs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

@Override
void read() {
	// TODO Auto-generated method stub
	String line= " ";
	
	//use try with resources statement for file IO
	try(BufferedReader br = new BufferedReader
			(new FileReader("student-Detail.csv"))) 
	{
		int index=0;
		while((line = br.readLine()) != null) //read from file
		{
			array.add(Arrays.asList(line.split(",")));
			System.out.println(array.get(index++));
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Override
void process() {
	// TODO Auto-generated method stub
	//process data from arraylist into array
	int idx = 0;
	
	rObjs = new StudentRecords[array.size()];
	for(List<String> rowData: array)
	{
		//initialize array of objects
		rObjs[idx] = new StudentRecords();
		
		//use setters
		rObjs[idx].setName(rowData.get(0));
		rObjs[idx].setAge(Integer.parseInt(rowData.get(0)));
	}
}

@Override
void print() {
	// TODO Auto-generated method stub
	
}
public static void main(String[] args) {

	StudentRecords sr = new StudentRecords();
	sr.read();

}

	
}
