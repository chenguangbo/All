package cn.baidu.com;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;



public class Test_DOM4J {

	@Test
	public void test() throws Exception {

		SAXReader reader = new SAXReader();
		
		Document document = reader.read("src/cn/baidu/com/test.xml");
		
		Element root = document.getRootElement();//获取根源素
		
		List<Element> list = root.elements();//获取根元素上的所有子元素
	
		for (Element el : list) {
			//System.out.println(el.getName());//获取当前元素的元素名
			//System.out.println(el.attributeValue("version")); //获取version的属性值
			//System.out.println(el.getText());
			System.out.println(el.elementText("document"));//获得指定名称子元素的文本值
			
			List<Element> list2 = el.elements();
			for (Element element : list2) {
				System.out.println(element.getText());
			}
		
		}

	
	
	}

}
