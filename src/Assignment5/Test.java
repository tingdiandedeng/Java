package Assignment5;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
//		Container<Student> C1=new Container<Student>(new Student("����","��","001"));
//		Container<String> C2=new Container<String>("����");
//		System.out.println(C1.getF().toString());
//		System.out.println(C2.getF());
		Container[] arr=new Container[2];
		arr[0]=new Container<Student>(new Student("����","��","001"));
		arr[1]=new Container<String>("����");
		System.out.println(arr[0].getF().toString());
		System.out.println(arr[1].getF());
		Converter C=(F)->Integer.valueOf(F);
		int F=0;
		while(F==0)
		{   try
			{
				System.out.print("\n�����ת��Ϊ���͵��ַ���:");
				String S=new Scanner(System.in).next();
				Integer In=C.convert(S);
				System.out.println(In);
				F=1;
			}catch(NumberFormatException E)//���ݸ�ʽ����
			{
				System.out.println("����:������0-9�����֣�");
			}
		}
		
	}
}

interface Converter{
	Integer convert(String Str);
}

class Container<T>{
	private T f;
	public Container(T a) {
		this.f=a;
	}
	public T getF() {
		return this.f;
	}
}

class Student{
	private String Name;
	private String Sex;
	private String No;
	
	public Student(String N,String S,String No){
		this.Name=N;
		this.Sex=S;
		this.No=No;
	}

	@Override
	public String toString() {
		return "Student [Name=" + Name + ", Sex=" + Sex + ", No=" + No + "]";
	}
}