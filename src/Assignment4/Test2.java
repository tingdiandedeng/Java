package Assignment4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test2 
{
	public static void main(String args[])
	{
		try {
			CourseInfo C = De();
			Arraylist( C);
			Se(C);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		System.out.print("\n\n");
		HashMap<String,CourseInfo> M=new HashMap<String,CourseInfo>();
		M.put("001", new CourseInfo(1,"数据库"));
		M.put("002", new CourseInfo(2,"操作系统"));
		M.put("003", new CourseInfo(3,"数据结构"));
		M.get("001").PrintCourse();
		
		
	}
	
	public static void Arraylist(CourseInfo C) {
		int f;
		while(true)
		{
			System.out.print("PrintCourse(1)  Delete(2)  Insert(3)  Set(4)\n");
			System.out.print("输入数字1-4,其他数字退出:");
			f=new Scanner(System.in).nextInt();
			switch(f)
			{
			case 1:C.PrintCourse();break;
			case 2:C.Delete();break;
			case 3:C.Insert();break;
			case 4:C.Set();break;
			default:return;
			}
			System.out.print("\n\n");
		}
	}
	
	public static void Se(CourseInfo c) throws IOException
	{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("data.txt")));
	        oos.writeObject(c);
	        System.out.println("对象序列化成功！");
	        oos.close();

	}
	
	public static CourseInfo De() throws Exception
	{
		ObjectInputStream O=new ObjectInputStream(new FileInputStream(new File("data.txt")));
		CourseInfo C=(CourseInfo) O.readObject();
		System.out.println("反序列化成功");
		return C;
	}
	
}
abstract class Course implements Cloneable,Serializable
{
	protected int NO;
	protected int NumberOfPeople;
	protected String CourseName;
	protected String location;

	public Course(int a,int b,String str1,String str2)
	{
		NO=a;
		NumberOfPeople=b;
		location=str1;
		CourseName=str2;
	}
	
	public abstract void Set();
	
	@Override
	public abstract String toString();
}

class LectureCourse extends Course
{
	private String Homework;
	
	public LectureCourse(int a,int b,String str1,String str2,String str3)//no,number,location,homework,coursename
	{
		super(a,b,str1,str3);
		Homework=str2;
	}
	
	public void Set()//no,number,location,homework,coursename
	{
		System.out.println("Input the NumberOfPeople:");
		super.NumberOfPeople=new Scanner(System.in).nextInt();
		System.out.println("Input the Location:");
		super.location=new Scanner(System.in).next();
		System.out.println("Input the homework:");
		this.Homework=new Scanner(System.in).next();
	}
	
	@Override
	public String toString() {
		return "LectureCourse [CourseName=" + CourseName+",NO=" + NO +", NumberOfPeople="
				+ NumberOfPeople +",location=" + location + ",Homework=" + Homework +  "]";
	}

	
}

class LabCourse extends Course
{
	private String ExperimentalTheme;
	
	public LabCourse(int a,int b,String str1,String str2,String str3)//no,number,location,theme,coursename
	{
		super(a,b,str1,str3);
		ExperimentalTheme=str2;
	}
	
	public void Set()//no,number,location,theme,coursename
	{
		System.out.println("Input the NumberOfPeople:");
		super.NumberOfPeople=new Scanner(System.in).nextInt();
		System.out.println("Input the Location:");
		super.location=new Scanner(System.in).next();
		System.out.println("Input the theme:");
		this.ExperimentalTheme=new Scanner(System.in).next();
	}
	
	@Override
	public String toString() {
		return "LabCourse [CourseName=" + CourseName + ",NO=" + NO +", NumberOfPeople=" + NumberOfPeople +",location=" + location + ",ExperimentalTheme=" + ExperimentalTheme +  "]";
	}
	
}

class CourseInfo implements Serializable
{
	private int No;
	private String CourseName;
	private ArrayList<Course> courses;
	
	public CourseInfo(int Number,String str)
	{
		No=Number;
		CourseName=str;
		courses =new ArrayList<Course>();
	}
	
	public void Insert()
	{
		int number;
		String location;String theme;String homework;
		System.out.println("Whitch Course you want to insert(1:LectureCourse  2:LabCourse):");
		int f=new Scanner(System.in).nextInt();
		if(f!=1&&f!=2)
			System.out.println("Wrong input!");
		else
		{
			System.out.println("Input the NumberOfPeople:");
			number=new Scanner(System.in).nextInt();
			System.out.println("Input the Location:");
			location=new Scanner(System.in).next();
			if(f==2)
			{
				System.out.println("Input the Theme:");
				theme=new Scanner(System.in).next();
				this.courses.add(new LectureCourse(this.No,number,location,theme,this.CourseName));
			}
			else
			{
				System.out.println("Input the Homework:");
				homework=new Scanner(System.in).next();
				this.courses.add(new LabCourse(this.No,number,location,homework,this.CourseName));
			}
		}
		
		
	}
	
	public void Delete()
	{
		if(this.courses.isEmpty())
		{
			System.out.println("The List is empty!");
			return;
		}
		int no;
		System.out.println("Input the number of course:");
		no=new Scanner(System.in).nextInt();
		if(no>this.courses.size())
		{
			System.out.println("Please input 1 to "+this.courses.size());
		}
		else
		{
			this.courses.remove(no-1);
		}
	}
	
	public void Set()
	{
		if(this.courses.isEmpty())
		{
			System.out.println("The List is empty!");
			return;
		}
		int no;
		System.out.println("Enter the course number of the course you want to modify:");
		no=new Scanner(System.in).nextInt();
		if(no>this.courses.size())
			System.out.println("Please input 1 to "+this.courses.size());
		else
			this.courses.get(no-1).Set();
	}
	
	public void PrintCourse()
	{
		System.out.println("CourseName:"+this.CourseName+"  CourseNo:"+this.No);
		if(this.courses.isEmpty())
			System.out.println("暂未录入课程信息");
		else
		{
			int i=1;
			for(Course C:courses) {
				System.out.println((i++)+":"+C.toString());
			}
		}
	}	
}
