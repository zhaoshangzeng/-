package cn.fruit.service.impl;

import cn.fruit.dao.UserDao;
import cn.fruit.dao.impl.UserDaoImpl;
import cn.fruit.domain.User;
import cn.fruit.exception.UserExistException;
import cn.fruit.service.UserService;
import cn.fruit.utils.ServiceUtils;

/**
 * ר�Ŵ����û���Ϣ����Ȼ�����ݽ���Dao�㣬��Controller��Dao������
 * @author zzshang
 *
 */
public class UserServiceImpl implements UserService {
	
	/**
	 * ����dao��
	 */
	private UserDao dao = new UserDaoImpl(); //�ù���ģʽ��spring�������ϲ���벻�ø�	
	
	/**
	 * ע��
	 */
	public void register(User user) throws UserExistException{
		//�жϵ�ǰע����û��Ƿ���ڣ��ж��Ƿ����ظ��û���
		boolean b = dao.find(user.getPhone());
		if(b){
			throw new UserExistException();//�׳�����ʱ�쳣������web��������쳣
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));	//���ܱ���
			dao.add(user);
		}
	}
	
	/**
	 * ��¼
	 */
	public User login(String phone, String password){
		
		password = ServiceUtils.md5(password);	//���ܴ���
		return dao.find(phone, password);
	}

	/**
	 * ���û�Ա
	 */
	public void setHy(String username) {
		
		dao.setVip(username);
	}

	/**
	 * �����û����ж��Ƿ��ǻ�Ա
	 */
	public boolean ifHy(String username) {
		
		User user = dao.findByName(username);
		if("0".equals(user.getIfvip())){
			return false;
		}else{
			return true;
		}
	}
}
