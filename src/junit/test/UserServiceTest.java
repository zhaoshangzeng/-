package junit.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cn.fruit.domain.User;
import cn.fruit.exception.UserExistException;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;

/**
 * ����userservice��
 * @author zzshang
 *
 */
public class UserServiceTest {
	
	UserService us = null;
	
	@Before
	public void getServiceObject(){
		us = new UserServiceImpl();
	}

	//ע��
	@Test
	public void testRegister(){
		User user = new User();
		user.setId("3928399282");
		user.setUsername("����Ԫ");
		user.setPhone("13246874450");
		user.setAddress("��������14��213");
		user.setPassword("123456");
		user.setIfvip("1");
		
		try {
			us.register(user);
			System.out.println("ע��ɹ�");
		} catch (UserExistException e) {
			System.out.println("�û��Ѿ����ڣ�");
		}
	}
	
	//��¼
	@Test
	public void testLogin(){
		User user = us.login("13246874455", "123456");
		if(user == null){
			System.out.println("��¼ʧ�ܣ�");
		}else{
			System.out.println("��¼�ɹ���");
		}
	}
	
	//�����жϻ�Ա
	@Test
	public void testIfHy(){
		boolean ifHy = us.ifHy("�ο�");
		Assert.assertEquals(true, ifHy);
	}
	
	//����ע���Ա
	@Test
	public void testBuyHy(){
		us.setHy("�ο�");
	}
}
