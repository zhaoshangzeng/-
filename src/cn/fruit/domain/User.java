package cn.fruit.domain;

/**
 * �û�������Ϣ��
 * @author zzshang
 *
 */
public class User {
	private String id;	//Ψһ��ʶ����
	private String username;	//�û���
	private String phone;	//�ֻ�����
	private String address;	//��ַ
	private String password;	//����
	private String ifvip;	//�Ƿ�Ϊvip��0���ǣ�1����
	
	{
		ifvip = "0";
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIfvip() {
		return ifvip;
	}
	public void setIfvip(String ifvip) {
		this.ifvip = ifvip;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", phone=" + phone
				+ ", address=" + address + ", password=" + password
				+ ", ifvip=" + ifvip + "]";
	}
	
}
