package cn.fruit.utils;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {

	//�������ת��bean����ֵ
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass){
		//��������Ϊclass�������õ����߲���new����ֱ�Ӵ�class���ͼ���
		//ʹ�÷��ͣ������õ����߻�ý��ʱ������ǿת����
		try {
			//1.����Ҫ��װ���ݵ�bean
			T bean = beanClass.newInstance();
			
			//2.����������bean��
			@SuppressWarnings("unchecked")
			Map<String, String> map = request.getParameterMap();
			BeanUtils.populate(bean, map);
			
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//FormBean����ֵ ת�� UserBean����ֵ
	public static void copyBean(Object dest, Object src){
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
	//�����û�id������ȫ��Ψһ��id
	public static String generateID(){
		
		UUID randomUUID = UUID.randomUUID();
		String uuid = randomUUID.toString().replace("-", "").toUpperCase();
		return uuid;
	}
}
