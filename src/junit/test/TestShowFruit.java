package junit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.fruit.DB.Data;
import cn.fruit.domain.Fruit;

//����ˮ����Ϣ�Ļ�ȡ
public class TestShowFruit {
	
	@Test
	public void price(){
		Map<String, Fruit> map = Data.getAll();
		System.out.println(map.get("xhs").getPrice());
	}
	
	//����map,ѧϰmap�ķ�����ʹ��
	@Test
	public void maptest(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "11");
		map.put("2", "22");
		map.put("3", "33");
		map.remove("4");
		String string = map.get("4");
		System.out.println(map + string);
		
		List<String> list = new ArrayList<String>();
		System.out.println(list);
	}
	
}
