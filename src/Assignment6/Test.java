package Assignment6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Course> L=new ArrayList<Course>();
		ArrayList<Course> J=new ArrayList<Course>();
		ArrayList<Course> T=new ArrayList<Course>();
		ArrayList<Course> D=new ArrayList<Course>();
		CountDownLatch Signal=new CountDownLatch(2);
		Inserter I=new Inserter(L,Signal);
		Disptcher Dis=new Disptcher(L,Signal,J,T,D);
		Thread TIn=new Thread(I);
		Thread TDi=new Thread(Dis);
		TIn.start();
		TDi.start();
		Signal.await();//�ȴ������߳̽���
//		TIn.join();
//		TDi.join();
		
		System.out.println("\n�����רҵ�γ�:");
		for(Course C:J) {
			System.out.println(C);
		}
		
		System.out.println("\nͨ��רҵ�γ�:");
		for(Course C:T) {
			System.out.println(C);
		}
		
		System.out.println("\n����רҵ�γ�:");
		for(Course C:D) {
			System.out.println(C);
		}
	}

}

class Inserter implements Runnable{
	private CountDownLatch Signal;//����������¼�߳̽������������߳�
	private ArrayList<Course> L=null;
	private String[] C= {"����","����","Ӣ��","������","�����߼�","��ɢ��ѧ"};
	private String[] P= {"�����","ͨ��","����"};
	
	Inserter(ArrayList<Course> L,CountDownLatch S)
	{
		this.Signal=S;
		this.L=L;
	}
	@Override
	public void run() {
		int i=10;
		while(i-->0)
		{
			Random r=new Random();
			int j=r.nextInt(6);
			int k=r.nextInt(3);
			synchronized(L) 
			{
			L.add(new Course(C[j],P[k]));
			System.out.println("�����һ�ſΡ�");
			L.notifyAll();//��������wait���߳�
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Signal.countDown();
	}
	
}

class Disptcher implements Runnable{
	private ArrayList<Course> L=null;
	private ArrayList<Course> J=null;
	private ArrayList<Course> T=null;
	private ArrayList<Course> D=null;
	private CountDownLatch Signal;
	public Disptcher(ArrayList<Course> L,CountDownLatch S,ArrayList<Course> J,ArrayList<Course> T,ArrayList<Course> D)
	{
		this.L=L;
		this.Signal=S;
		this.J=J;
		this.T=T;
		this.D=D;
	}
	@Override
	public void run() {
		int f=9;
		while(f>=0)
		{
			
			while(L.size()==0)//�������Ϊ�գ������wait״̬
			{
				try {
					synchronized(L)
					{
						System.out.println("����Ϊ�գ�����ȴ�״̬");
					L.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		for(int i=0;i<L.size();i++,f--)
		{
			Course C=L.get(i);
			L.remove(i);
			switch(C.getP()) 
			{
			case "�����":J.add(C);break;
			case "ͨ��":T.add(C);break;
			case "����":D.add(C);break;
			}
			System.out.println("������һ�ڿΡ�");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		}
		Signal.countDown();
	}
}

class Course{
	private String CourseName;
	private String Profession;
	Course(String s1,String s2)
	{
		this.CourseName=s1;
		this.Profession=s2;
	}
	public String getP()
	{
		return this.Profession;
	}
	@Override
	public String toString() {
		return "Course [CourseName=" + CourseName + ", Profession=" + Profession + "]";
	}
}
