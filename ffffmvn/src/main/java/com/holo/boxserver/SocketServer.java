package com.holo.boxserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10000); // 绑定的端口号
		Socket socket = server.accept(); // 连接不成功以至于下一行的"连接成功"
		// 在调试区显示不出来
		System.out.println("连接成功");
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		while (true) {
			String msg = in.readLine();
			System.out.println(msg);
			out.println("Server received " + msg); // 向接收方发送已接受到了的语句
			out.flush();
			if (msg.equals("bye")) { // 若接收到"bye"则break
				break;
			}
		}
		socket.close();
	}

}
