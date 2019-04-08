package Assignment7;

import java.io.IOException;
import java.io.*;
import java.net.*;

public class server {

	public static void main(String[] args) throws IOException {
		ServerSocket Se=new ServerSocket(30000);
		Socket client=Se.accept();
		PrintStream P=new PrintStream(client.getOutputStream());//输出流
		BufferedReader B=new BufferedReader(new InputStreamReader(client.getInputStream()));//输入流
		P.println("来自服务器端的消息。");
		System.out.println("服务端消息发送完毕。");
		String line=null;
		while((line=B.readLine())!=null)
		{
			System.out.println("来自客户端的消息："+line);
			if(line.equalsIgnoreCase("End"))
				break;
		}
		B.close();
		P.close();
		client.close();
	}

}
