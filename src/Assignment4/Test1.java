package Assignment4;

import java.util.Scanner;
import java.util.Vector;

public class Test1 {

	public static void main(String[] args) {
		UserManager M=new UserManager();
		int f;
		lable: 
		while(true){
			System.out.print("addUser(1)  deleteUser(2)  isExist(3)  display(4)\n");
			System.out.print("输入数字1-4,其他数字退出:");
			f=new Scanner(System.in).nextInt();
			switch(f)
			{
			case 1:M.addUser();break;
			case 2:M.deleteUser();break;
			case 3:
				System.out.println("Enter the name of the user you want to find:");
				M.isExist(new Scanner(System.in).next());break;
			case 4:M.display();break;
			default:break lable;
			}
			System.out.print("\n\n");
		}
		}
}


class User{
	private String name;
	private String department;
	public User(String Name,String Department)
	{
		name=Name;
		department=Department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", department=" + department + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
}

class UserManager{
	private Vector Users;
	public UserManager() {
		Users=new Vector();
	}
	public void addUser() {
		System.out.println("Enter name:");
		String name=new Scanner(System.in).next();
		System.out.println("Enter department:");
		String department=new Scanner(System.in).next();
		Users.addElement(new User(name,department));
	}
	public void deleteUser() {
		System.out.println("Enter the name of the user you want to delete:");
		String name=new Scanner(System.in).next();
		int i=findName(new User(name,"s"));
		if (i==-1)
			System.out.println("Doesn't find this User.");
		else
		{
			Users.removeElementAt(i);
			System.out.println("Successfuly deleted.");
		}
			
	}
	public void isExist(String name) {
		int i=findName(new User(name,"s"));
		if (i==-1)
			System.out.println("Doesn't find this User.");
		else
			System.out.println("This user exists.");
	}
	public int findName(User U) {
		int i=0;
		for(;i<Users.size();i++)
			if(Users.elementAt(i).equals(U))
				return i;
		return -1;
	}
	public void display() {
		int Size=Users.size();
		if(Size==0)
			System.out.println("No users exist.");
		else
		{
			for(int i=0;i<Size;i++)
				System.out.println(Users.get(i));
		}
	}
}