package cn.baidu.File.ObjectInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		FileInputStream fin = new FileInputStream("Object.txt");
		ObjectInputStream in = new ObjectInputStream(fin);

		Object read = in.readObject();
		in.close();
		System.out.println(read);

	}

}
