package top.inick.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestDom4j {

	@Test
	public void test01() throws DocumentException {
		SAXReader reader = new  SAXReader();	//创建一个xml解析对象
		Document document = reader.read("src/Book.xml");	//把xml加载到document对象
		Element root = document.getRootElement();
		/*Element bookNode = root.element("书");
		System.out.println(bookNode.getName());*/
		
		List list = root.elements();
		Element secondBook = (Element) list.get(1);
		String name = secondBook.element("书名").getText();
		System.out.println(name);
		
	}
	
	@Test
	public void test2() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/Book.xml");
		Element root = document.getRootElement();
		treeWalk(root);
	}

	private void treeWalk(Element ele) {
		System.out.println(ele.getName());
		for(int i = 0; i < ele.nodeCount(); i++) {
			Node node = ele.node(i);
			if(node instanceof Element) {
				treeWalk((Element)node);
			}
		}
	}

}
