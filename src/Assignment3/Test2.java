package Assignment3;

import java.util.Scanner;

public class Test2 {
	public static void main(String args[])
	{
		Chargeable C1=new Cinema();
		Chargeable C2=new Taxi();
		Chargeable C3=new ParkingLot();
		while(true)
		{
			System.out.print("\n输入计费系统代号(电影院计费-1,出租车计费-2,停车收费-3,退出-100):");
			int f=new Scanner(System.in).nextInt();
			switch(f)
			{
			case 1:FnCharge(C1);break;
			case 2:FnCharge(C2);break;
			case 3:FnCharge(C3);break;
			case 100:return;
			default:System.out.println("错误的输入。");
			}
		}
	}
	
	public static void FnCharge(Chargeable C)
	{
		C.Charge();
	}
}

interface Chargeable
{
	void Charge();
}

class Cinema implements Chargeable
{
	public void Charge()
	{
		int Cost=0;
		while(true)
		{
		System.out.print("输入电影类型代号(2D-1,3D-2,vip-3,退出-100):");
		switch(new Scanner(System.in).nextInt())
		{
		case 1:Cost=50;break;
		case 2:Cost=60;break;
		case 3:Cost=100;break;
		case 100:return;
		default:System.out.println("错误的输入!");
		}
		if(Cost!=0)
		{
			System.out.print("是否为会员(是-1，否-0):");
			switch(new Scanner(System.in).nextInt())
			{
			case 1:Cost=Cost/2;break;
			case 0:break;
			default:System.out.println("错误的输入!");
			}
		}
		if(Cost!=0)
			System.out.println("电影票价应为:"+Cost+"元。\n");
		}
	}
}
class Taxi implements Chargeable
{
	public void Charge()
	{
		float cost=0;
		System.out.print("输入公里数:");
		float L=new Scanner(System.in).nextFloat();
		if(L<=3&&0<L)
			cost=8;
		else if(L>3)
			cost=8+(float)Math.rint((L-3)/0.8);
		else if(L==0)
			cost=0;
		else
			System.out.println("错误的输入");
		if(cost!=0)
			System.out.println("打车费应为:"+cost+"元。");
	}
}
class ParkingLot implements Chargeable
{
	public void Charge()
	{
		System.out.println("早8:00至晚8：00每小时4元；晚8:00到早8:00收费10元。");
		System.out.println("停车费应为16元。");
	}
}