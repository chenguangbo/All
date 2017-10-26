package cn.baidu.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import junit.framework.Assert;

public class Test_Serialable {

	@Test
	public void test() throws Exception {
		Serializable_Singleton s1 = null;
		Serializable_Singleton s = Serializable_Singleton.getInstance();
		// 将对象序列化到磁盘
		FileOutputStream out = new FileOutputStream("Serializable_Singleton.txt");
		ObjectOutputStream oout = new ObjectOutputStream(out);
		oout.writeObject(s);
		oout.flush();
		oout.close();
		// 从磁盘读取对象
		FileInputStream in = new FileInputStream("Serializable_Singleton.txt");
		ObjectInputStream oin = new ObjectInputStream(in);
		s1 = (Serializable_Singleton) oin.readObject();
		Assert.assertEquals(s1, s);

	}

}
