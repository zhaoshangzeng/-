package cn.fruit.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * ��XML�Ľӿ��࣬ʹ��Dom4j����
 * @author zzshang
 *
 */
public class XmlUtils {
	private static String filepath;
	static{
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
	}
	
	/**
	 * ��ȡxml���ݣ����ض���
	 * @return
	 * @throws DocumentException
	 */
	public static Document getDocument() throws DocumentException{  //��Ϊ�������Ǽ���һ��Ĵ��룬�����쳣�����׼���
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filepath));
		return document;
	}
	
	/**
	 * ������д��xml
	 * @param document
	 * @throws Exception
	 */
	public static void write2Xml(Document document) throws Exception {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath), format);
		writer.write(document);
		writer.close();
	}
}
