package Assignment7;

import java.io.IOException;
import java.io.*;
import java.net.*;

public class server {

	public static void main(String[] args) throws IOException {
		ServerSocket Se=new ServerSocket(30000);
		Socket client=Se.accept();
		PrintStream P=new PrintStream(client.getOutputStream());//�����
		BufferedReader B=new BufferedReader(new InputStreamReader(client.getInputStream()));//������
		P.println("���Է������˵���Ϣ��");
		System.out.println("�������Ϣ������ϡ�");
		String line=null;
		while((line=B.readLine())!=null)
		{
			System.out.println("���Կͻ��˵���Ϣ��"+line);
			if(line.equalsIgnoreCase("End"))
				break;
		}
		B.close();
		P.close();
		client.close();
	}

}
