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
			System.out.print("\n����Ʒ�ϵͳ����(��ӰԺ�Ʒ�-1,���⳵�Ʒ�-2,ͣ���շ�-3,�˳�-100):");
			int f=new Scanner(System.in).nextInt();
			switch(f)
			{
			case 1:FnCharge(C1);break;
			case 2:FnCharge(C2);break;
			case 3:FnCharge(C3);break;
			case 100:return;
			default:System.out.println("��������롣");
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
		System.out.print("�����Ӱ���ʹ���(2D-1,3D-2,vip-3,�˳�-100):");
		switch(new Scanner(System.in).nextInt())
		{
		case 1:Cost=50;break;
		case 2:Cost=60;break;
		case 3:Cost=100;break;
		case 100:return;
		default:System.out.println("���������!");
		}
		if(Cost!=0)
		{
			System.out.print("�Ƿ�Ϊ��Ա(��-1����-0):");
			switch(new Scanner(System.in).nextInt())
			{
			case 1:Cost=Cost/2;break;
			case 0:break;
			default:System.out.println("���������!");
			}
		}
		if(Cost!=0)
			System.out.println("��ӰƱ��ӦΪ:"+Cost+"Ԫ��\n");
		}
	}
}
class Taxi implements Chargeable
{
	public void Charge()
	{
		float cost=0;
		System.out.print("���빫����:");
		float L=new Scanner(System.in).nextFloat();
		if(L<=3&&0<L)
			cost=8;
		else if(L>3)
			cost=8+(float)Math.rint((L-3)/0.8);
		else if(L==0)
			cost=0;
		else
			System.out.println("���������");
		if(cost!=0)
			System.out.println("�򳵷�ӦΪ:"+cost+"Ԫ��");
	}
}
class ParkingLot implements Chargeable
{
	public void Charge()
	{
		System.out.println("��8:00����8��00ÿСʱ4Ԫ����8:00����8:00�շ�10Ԫ��");
		System.out.println("ͣ����ӦΪ16Ԫ��");
	}
}