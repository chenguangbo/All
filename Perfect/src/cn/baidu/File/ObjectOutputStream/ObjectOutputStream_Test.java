package cn.baidu.File.ObjectOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStream_Test {

	public static void main(String[] args) throws IOException {

		FileOutputStream fout = new FileOutputStream("Object.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);

		out.writeObject(new Cat("WF", 18, 0));
		out.flush();
		out.close();
		System.out.println("对象写入完成");

	}

}
