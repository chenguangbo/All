package cn.baidu.File.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestFileReader {

	public static void main(String[] args) throws IOException {
		
		read();
		/*
		Reader reader = new FileReader("新年快乐.txt");
		int i = -1;
		while ((i = reader.read()) != -1) {
			System.out.print((char) i);
		}
		reader.close();*/
	}

	public static void read() throws IOException {
		Reader reader = new FileReader("新年快乐.txt");
		int i = -1;
		char[] c = new char[1024];
		while ((i = reader.read(c)) != -1) {
			System.out.println(new String(c, 0, i));
		}
		reader.close();
	}

}
