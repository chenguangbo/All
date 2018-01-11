package cn.baidu.File.FileCopy_Character;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterCopy {
	/**
	 * 为什么在C盘创建就会报错???
	 *	解决:在输入CMD的地方输入以下代码         icacls c:\ /setintegritylevel M   
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		FileReader reader = new FileReader("新年快乐.txt");
		File file = new File("C:\\新年快乐.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(file);

		char[] c = new char[1024];
		int i = -1;
		while ((i = reader.read(c)) != -1) {
			writer.write(c, 0, i);
			writer.flush();
		}
		reader.close();
		writer.close();
		System.out.println("文件复制完毕!");
	}
}
