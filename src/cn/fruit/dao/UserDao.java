package cn.fruit.dao;

import cn.fruit.domain.User;

/**
 * �û����ݴ��������
 * @author zzshang
 *
 */
public interface UserDao {

	/**
	 * ����û�
	 * @param user
	 */
	void add(User user);

	/**
	 * ����û�ʱ�������ֻ������ж����ݿ��Ƿ���һ����
	 * @param phone
	 * @return
	 */
	Boolean find(String phone);

	/**
	 * �����ֻ�����������жϵ�¼
	 * @param phone
	 * @param password
	 * @return
	 */
	User find(String phone, String password);
	
	/**
	 * �����������ҵ��û���Ϣ�������ж��Ƿ��ǻ�Ա
	 * @param username
	 * @return
	 */
	User findByName(String username);
	
	/**
	 * ����vip
	 * @param username
	 * @return
	 */
	Boolean setVip(String username);

}