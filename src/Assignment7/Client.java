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
		System.out.println("客户端获得的服务器端数据为："+line);
		ps.println("这是一条来自客户端的数据。");
		ps.println("end");
		ps.close();
		B.close();
		S.close();
		
	}

}
