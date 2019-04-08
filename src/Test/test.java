package Test;

import java.awt.FlowLayout;
import java.util.regex.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test {

	public static void main(String[] args) {
//		A o = new A();
//		System.out.println(o.s);//null
//		System.out.println(o.i);//0		 
//		System.out.println(o.strArr);//[Ljava.lang.String;@15db9742
//		System.out.println(o.strArr[0]);
//		System.out.println(o.strArr[0].toUpperCase());//NullPointerException
//		System.out.println(o.intArr);
//		System.out.println(o.intArr[0]);//NullPointerException
		
		
//		Integer obj1=new Integer(15);
//		Double obj2=new Double(15.66);
//		
//		int a=obj1.intValue();
//		double b=obj2.doubleValue();
//		
//		String str1="152";
//		int c=Integer.parseInt(str1);
//		double d=Double.parseDouble(str1);
//		
//		String str2=obj1.toString();
//		String str3=String.valueOf(str1);
//		ArrayList<demo> L1=new ArrayList<demo>();
//		L1.add(new demo(45,"a"));
//		L1.add(new demo(23,"b"));
//		L1.add(new demo(99,"c"));
//		L1.add(new demo(41,"d"));
//		L1.add(new demo(41,"d"));
//		Collections.sort(L1, new compare());
//		Iterator i=L1.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
//		
//		demo de=L1.get(1);
//		L1.remove(3);
//		L1.remove(new demo(41,"d"));
//		
//		i=L1.iterator();
//		System.out.print("\n\n");
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
//
//		System.out.print("\n\n");
//		HashSet<demo> H=new HashSet<demo>();
//		H.add(new demo(3,"A"));
//		H.add(new demo(1,"B"));
//		H.add(new demo(2,"C"));
//		H.add(new demo(4,"D"));
//		H.add(new demo(5,"E"));
//		H.add(new demo(5,"E"));
//		ArrayList L2=new ArrayList(H);
//		System.out.println(L2.get(1));
////		Collections.sort(L2, new compare());
//		System.out.print(L2);
//		
//		System.out.print("\n\n");
//		HashMap<String,demo> M=new HashMap<String,demo>();
//		for(int k=0;k<5;k++)
//		{
//			M.put(String.valueOf(k), (demo) L2.get(k));
//		}
//		
//		new SwingDemo();
//		String pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{2,5}$";
//		System.out.println(Pattern.matches(pattern, ""));
		
		UUID bid=UUID.randomUUID();
		System.out.println(bid.toString().length());
	}
	
}

//主窗体
class SwingDemo extends JFrame{
	public SwingDemo() {
		JButton jbtOK=new JButton("OK");
		setLayout(new FlowLayout());
		add(jbtOK);
		jbtOK.addActionListener(new ActionListener() {//ActionListener接口的匿名内部类
			public void actionPerformed(ActionEvent e) {
				new JFrame() {
					public void doAction() {
					this.setTitle("我的第二个GUI程序");
					this.setSize(300,200);
					this.setVisible(true);
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
				}.doAction();;
			}
		}
		);
		this.setTitle("我的第一个GUI程序");
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class demo{
	private int No;
	private String name;
	
	public demo(int no,String name) {
		this.No=no;
		this.name=name;
	}
	
	public int getNo(){return No;}
//	public String getName() {return name;}
	
	public String toString() {
		return "[No="+No+" ,Name="+name+"]";
	}
	
	@Override
	public boolean equals(Object O) {
		if(O instanceof demo) {
			demo D=(demo) O;
			if(D.No==this.No&&D.name==this.name)
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return No;
	}
}

class compare implements Comparator<demo>{
	@Override
	public int compare(demo o1,demo o2) {
		if(o1.getNo()==o2.getNo())
			return 0;
		else if(o1.getNo() > o2.getNo())
			return 1;
		return -1;
	}
}

class A {
	String s;
	int i;
	int[] intArr;
	String[] strArr = new String[2];
}
