package Assignment7;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket S=new Socket("localHost",30000);
		BufferedReader B=new BufferedReader(new InputStreamReader(S.getInputStream()));
		PrintStream ps=new PrintStream(S.getOutputStream());
		String line=B.readLine();
		System.out.println("�ͻ��˻�õķ�����������Ϊ��"+line);
		ps.println("����һ�����Կͻ��˵����ݡ�");
		ps.println("end");
		ps.close();
		B.close();
		S.close();
		
	}

}
