package Assignment1;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.BigDecimal;;
public class Assignment1 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int f;
		Label:
			while(true){
				Menu();
				System.out.print("输入数字1-6,其他数字退出:");
				f=new Scanner(System.in).nextInt();
				switch(f)
				{
				case 1:Print();break;
				case 2:SumAB();break;
				case 3:Calculate();break;
				case 4:BMI();break;
				case 5:TestStringBuilderAndStringBuffer();break;
				case 6:Difference();break;
				default:break Label;
				}
				System.out.print("\n\n");
			}
	}
	
	public static void Menu()//菜单方法
	{
		System.out.print("1:输出\t2:A+B\t3:阶乘计算\t4:BMI计算\t5:StringBuilder&StringBuilder\t6:equals&==\n");
	}
	
	public static void Print()//输出方法
	{
		System.out.println("Hello,Java!");
	}
	
	public static void SumAB()//求两个数的和，并保留两位小数
	{
		System.out.println("Enter a float number:");
		BigDecimal floatA=new BigDecimal(new Scanner(System.in).nextLine());
		
		System.out.println("Enter a double number:");
		BigDecimal doubleB=new BigDecimal(new Scanner(System.in).nextLine());
		
		BigDecimal SumAB=floatA.add(doubleB).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		System.out.println("A+B="+SumAB);
	}
	
	public static void Calculate()//计算数a的阶乘于a的n次方，并对a进行范围验证（1-10）
	{
		int R1=1;BigDecimal R2;
		int A;
		
		while(true)
		{
			System.out.print("Enter an integer from 1 to 10:");
			Scanner input=new Scanner(System.in);
			A=input.nextInt();
			if(A>10||A<1)
				System.out.println("Wrong input!");
			else
				break;
		}
		
		System.out.print("Enter an integer:");
		int n=new Scanner(System.in).nextInt();
		
		int i=A+1;
		while(i-->1)
			R1*=i;
		System.out.println(A+"!="+R1);
		
		R2=new BigDecimal(A).pow(n);
		System.out.println(A+"^"+n+"="+R2);
	}
	
	public static void BMI()//计算BMI值
	{
		double H,W,BMI;
		
		System.out.print("Enter your height(m):");
		H=new Scanner(System.in).nextDouble();
		
		System.out.print("Enter your weight(kg):");
		W=new Scanner(System.in).nextDouble();
		
		BMI=W/(H*H);
		System.out.println("Your BMI="+new DecimalFormat("#.00").format(BMI));
		System.out.println("过轻：低于18.5 " + 
				" 正常：18.5-23.9 " + 
				" 过重：24-27 " + 
				" 肥胖：28-32 " + 
				" 非常肥胖, 高于32 ");
	}
	
	public static void TestStringBuilderAndStringBuffer()//分别对StringBuffer、StringBuilder进行相同操作3000次，对比运行时间
	{
		StringBuilder strA=new StringBuilder();
		StringBuffer strB=new StringBuffer();
		int i;
		i=3000;
		long startTimeA=System.nanoTime();
		while(i-->=1)
			strA.append("Java ");
		long endTimeA=System.nanoTime();
		System.out.println("The runtime of the StringBuilder:"+(endTimeA-startTimeA)+"ns.");
		i=3000;
		long startTimeB=System.nanoTime();
		while(i-->=1)
			strB.append("Java ");
		long endTimeB=System.nanoTime();
		System.out.println("The runtime of the StringBuffer:"+(endTimeB-startTimeB)+"ns.");
		System.out.println("StringBuuffer比StringBuilder在线程上更安全，但StringBuilder速度更快。");
	}
	
	public static void Difference()//对比相同内容的字符串引用对象A＆B，分别调用==和equals()的区别
	{
		String A=new String("abc");
		String B=new String("abc");
		System.out.println(A==B);
		System.out.println(A.equals(B));
	}

}

