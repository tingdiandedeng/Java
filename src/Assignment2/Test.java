package Assignment2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		LectureCourse A=new LectureCourse(1001,200,"教学楼","G105","计算机接口技术");
		LectureCourse B=new LectureCourse(1001,200,"教学楼","G105","Java语言");
		LabCourse C=new LabCourse(1001,200,"信息楼","205","Java语言");
		Course referenceA=A;
		Course cloneA=(Course)(A.clone());
		System.out.println("CourseA:" + A);
		System.out.println("CourseB:" + B);
		System.out.println("CourseC:" + C);
		System.out.println("A.equals(B):" + A.equals(B));
		System.out.println("A.equals(cloneA):" + A.equals(cloneA));
		System.out.println("A==referenceA:" + (A==referenceA));
		System.out.println("A==cloneA:" + (A==cloneA));
		System.out.println("A.hashCode():" + A.hashCode());
		System.out.println("B.hashCode():" + B.hashCode());
		System.out.println("C.hashCode():" + C.hashCode());
		System.out.print("\n\n------------------------CourseInfo类-------------------------\n");
		CourseInfo Cour=new CourseInfo((int)(Math.random()*1000000000));
		Cour.PrintCourse();
	}
}
abstract class Course implements Cloneable{
	protected int NO;
	protected int NumberOfPeople;
	protected String location;
//	public Course() {}
//	
//	public Course(int a) {
//		NO=a;
//		NumberOfPeople=200;
//		location="暂定";
//	}
	public Course(int a,int b,String str)
	{
		NO=a;
		NumberOfPeople=b;
		location=str;
	}
	
	@Override
	public abstract String toString();

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return new EqualsBuilder()
				.append(this.NO,other.NO)
				.append(this.NumberOfPeople,other.NumberOfPeople)
				.append(this.location, other.location)
				.isEquals();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
class LectureCourse extends Course{
	private String SpecificLocation;
	private String CourseName;
	
//	public LectureCourse() {}
//	public LectureCourse(int a)
//	{
//		super(a);
//		SpecificLocation="暂定";
//	}
	public LectureCourse(int a,int b,String str1,String str2,String str3)
	{
		super(a,b,str1);
		SpecificLocation=str2;
		CourseName=str3;
	}
	
	@Override
	public String toString() {
		return "LectureCourse [CourseName=" + CourseName+",NO=" + NO +", NumberOfPeople=" + NumberOfPeople +",location=" + location + ",SpecificLocation=" + SpecificLocation +  "]";
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(13,15)
				.append(this.NO)
				.append(this.NumberOfPeople)
				.append(this.location)
				.append(this.SpecificLocation)
				.append(this.CourseName)
				.toHashCode();
				
	}
	
	public boolean equals(Object obj) {
		if(!super.equals((LectureCourse) obj))
			return false;
		else
		{
			LectureCourse other=(LectureCourse) obj;
			return new EqualsBuilder()
				.append(this.SpecificLocation, other.SpecificLocation)
				.append(this.CourseName, other.CourseName)
				.isEquals();
		}
	}
	
}

class LabCourse extends Course{
	private String SpecificLocation;
	private String CourseName;
	
//	public LabCourse() {}
//	public LabCourse(int a)
//	{
//		super(a);
//		SpecificLocation="暂定";
//	}
	public LabCourse(int a,int b,String str1,String str2,String str3)
	{
		super(a,b,str1);
		SpecificLocation=str2;
		CourseName=str3;
	}
	@Override
	public String toString() {
		return "LabCourse [CourseName=" + CourseName + ",NO=" + NO +", NumberOfPeople=" + NumberOfPeople +",location=" + location + ",SpecificLocation=" + SpecificLocation +  "]";
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(13,15)
				.append(this.NO)
				.append(this.NumberOfPeople)
				.append(this.location)
				.append(this.SpecificLocation)
				.append(this.CourseName)
				.toHashCode();
				
	}
	
	public boolean equals(Object obj) {
		if(!super.equals((LabCourse) obj))
			return false;
		else
		{
			LabCourse other=(LabCourse) obj;
			return new EqualsBuilder()
				.append(this.SpecificLocation, other.SpecificLocation)
				.append(this.CourseName, other.CourseName)
				.isEquals();
		}
	}
}

class CourseInfo{
	private int No;
	private String CourseName;
	private String Semester;
	private int ClassHour;
	private int[] Grade;
	private String[] Profession;
	private Course[] courses;
	
	public CourseInfo(int Number)
	{
		No=Number;
		CourseName="Java语言";
		Semester="第五学期";
		ClassHour=60;
		courses=new Course[5];
		courses[0]=new LectureCourse(No,100,"教学楼","G110",CourseName);
		courses[1]=new LectureCourse(No,100,"教学楼","G105",CourseName);
		courses[2]=new LectureCourse(No,100,"教学楼","F206",CourseName);
		courses[3]=new LabCourse(No,60,"信息楼","206",CourseName);
		courses[4]=new LabCourse(No,60,"信息楼","205",CourseName);
	}
	
	public void PrintCourse()
	{
		int i=1;
		for(Course C:courses) {
			System.out.println("Course"+(i++)+":"+C);
		}
	}
}
