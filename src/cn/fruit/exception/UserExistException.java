package cn.fruit.exception;

/**
 * �û��Ѵ����쳣
 * �����ҵ����û������׸��쳣
 * ����ע��ʱ���������ݿ����ظ��û������ø��쳣������
 * @author zzshang
 *
 */
public class UserExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserExistException() {
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
