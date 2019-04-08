package Assignment3;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
	public static void main(String args[])
	{
		CourseInfo[] C=new CourseInfo[5];
		C[0]=new CourseInfo(3, "Java语言");
		C[1]=new CourseInfo(2, "数据库");
		C[2]=new CourseInfo(1, "操作系统");
		C[3]=new CourseInfo(5, "数据结构");
		C[4]=new CourseInfo(4, "算法");
		C[0].PrintCourse();
		if(new CourseInfoComparator().compare(C[0], C[1])==1)
			System.out.println("\nC[0]与C[1]课程信息相同。\n");
		else
			System.out.println("\nC[0]与C[1]课程信息不同。\n");
		Arrays.sort(C);
		int i=0;
		for(CourseInfo c:C)
		{
			System.out.print("Course"+ i++ +":");
			c.PrintBreifInfo();
		}
	}
}
abstract class Course implements Cloneable{
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
	
	@Override
	public abstract String toString();
	
	public abstract String ListInfo();
}

class LectureCourse extends Course{
	private String Homework;
	
	public LectureCourse(int a,int b,String str1,String str2,String str3)
	{
		super(a,b,str1,str3);
		Homework=str2;
	}
	
	@Override
	public String toString() {
		return "LectureCourse [CourseName=" + CourseName+",NO=" + NO +", NumberOfPeople="
				+ NumberOfPeople +",location=" + location + ",Homework=" + Homework +  "]";
	}
	

	@Override
	public String ListInfo() {
		return this.toString();
	}
	
}

class LabCourse extends Course{
	private String ExperimentalTheme;
	
	public LabCourse(int a,int b,String str1,String str2,String str3)
	{
		super(a,b,str1,str3);
		ExperimentalTheme=str2;
	}
	@Override
	public String toString() {
		return "LabCourse [CourseName=" + CourseName + ",NO=" + NO +", NumberOfPeople=" + NumberOfPeople +",location=" + location + ",ExperimentalTheme=" + ExperimentalTheme +  "]";
	}
	
	@Override
	public String ListInfo() {
		return this.toString();
	}
}

class CourseInfo implements Comparable{
	private int No;
	private String CourseName;
	private String Semester;
	private int ClassHour;
	
	public int getNo() {
		return No;
	}

	public String getCourseName() {
		return CourseName;
	}

	public String getSemester() {
		return Semester;
	}

	public int getClassHour() {
		return ClassHour;
	}

	private int[] Grade;
	private String[] Profession;
	private Course[] courses;
	
	public CourseInfo(int Number,String str)
	{
		No=Number;
		CourseName=str;
		Semester="第五学期";
		ClassHour=60;
		courses=new Course[5];
		courses[0]=new LectureCourse(No,100,"教学楼G110","习题2",CourseName);
		courses[1]=new LectureCourse(No,100,"教学楼G105","习题3",CourseName);
		courses[2]=new LectureCourse(No,100,"教学楼F206","习题4",CourseName);
		courses[3]=new LabCourse(No,60,"信息楼206","基本输入输出",CourseName);
		courses[4]=new LabCourse(No,60,"信息楼205","继承练习",CourseName);
	}
	
	public void PrintCourse()
	{
		if(this.No==-100)
			System.out.println("暂未录入");
		else
		{
			int i=1;
			for(Course C:courses) {
				System.out.println((i++)+":"+C.ListInfo());
			}
		}
	}
	
	public void PrintBreifInfo()
	{
		System.out.println("CourseName="+CourseName+",CourseNo="+No);
	}

	@Override
	public int compareTo(Object o) {
		if(this.No>((CourseInfo)o).No)
			return 1;
		else if(this.No<((CourseInfo)o).No)
			return -1;
		else
			return 0;
	}
}

class CourseInfoComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		CourseInfo C1=(CourseInfo) o1;
		CourseInfo C2=(CourseInfo) o2;
		if(C1.getNo()==C2.getNo()&&C1.getCourseName()==C2.getCourseName()
				&&C1.getClassHour()==C2.getClassHour()
				&&C1.getSemester()==C2.getSemester())
			return 1;
		else
			return 0;
	}
	
}