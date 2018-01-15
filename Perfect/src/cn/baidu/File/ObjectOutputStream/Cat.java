package cn.baidu.File.ObjectOutputStream;

import java.io.Serializable;

public class Cat implements Serializable{

	private String name;
	private Integer age;
	private Integer sax;
	public Cat() {
		super();
	}
	public Cat(String name, Integer age, Integer sax) {
		super();
		this.name = name;
		this.age = age;
		this.sax = sax;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSax() {
		return sax;
	}
	public void setSax(Integer sax) {
		this.sax = sax;
	}
	
	
	
}
