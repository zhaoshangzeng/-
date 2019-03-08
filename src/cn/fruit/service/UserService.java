package cn.fruit.service;

import cn.fruit.domain.User;
import cn.fruit.exception.UserExistException;

public interface UserService {

	//ע��
	void register(User user) throws UserExistException;

	//��¼
	User login(String phone, String password);

	//����vip
	void setHy(String username);
	
	//�����û����ж��Ƿ�ע���Ա
	boolean ifHy(String username);
}