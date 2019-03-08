package cn.fruit.web.formbean;

import java.util.HashMap;
import java.util.Map;

//ע���bean
public class RegisterForm {
	
	private String username;	//�û���
	private String phone;	//�ֻ�����
	private String address;	//��ַ
	private String password;	//����
	private String password2;	//ȷ������
	private String ifagree;	//�Ƿ�ͬ��ע��Э�飬ͬ����Ϊyes����ͬ����Ϊnull
	
	private Map<String,String> errors = new HashMap<String,String>();	//�洢У������������span

	
	public String getIfagree() {
		return ifagree;
	}
	public void setIfagree(String ifagree) {
		this.ifagree = ifagree;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username.trim();
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone.trim();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address.trim();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password.trim();
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2.trim();
	}
	
	//У������ݺϷ���
	public boolean validate(){
		boolean isOK = true;
		//�������
		//���ֲ���Ϊ�գ�����Ϊ�����ַ�
		if(this.username == null || this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "��������Ϊ�գ�");
		}else if(!this.username.trim().matches("[\u4e00-\u9fe5]+")){
			isOK = false;
			errors.put("username", "����Ӧ��Ϊ���ģ��������ҲӦ����������(*�����)");
		}else{
			//�����һ������Ϊ�գ����˴�����Ϣ�����ڶ����ύ��������Ϊ��ʱ��Ӧ��ȥ��������Ϣ������ͬ��
			errors.remove("username");
		}
		//�ֻ�����Ϊ�գ��ֻ�����������
		if(this.phone == null || this.phone.trim().equals("")){
			isOK = false;
			errors.put("phone", "�ֻ����벻��Ϊ�գ�");
		}else if(!this.phone.matches("^1(3|4|5|7|8)\\d{9}$")){
			isOK = false;
			errors.put("phone", "�ֻ��������������");
		}else{
			errors.remove("phone");
		}
		//��ַ����Ϊ��
		if(this.address == null || this.address.trim().equals("")){
			isOK = false;
			errors.put("address", "������ַ����Ϊ�գ�");
		}else{
			errors.remove("address");
		}
		//���벻��Ϊ�գ���Ϊ6-10λ
		if(this.password == null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "��¼���벻��Ϊ�գ�");
		}else if(!this.password.matches("\\S{6,10}")){
			isOK = false;
			errors.put("password", "��¼����Ϊ6��10λ���֡���ĸ��Ӣ�ķ�����ϣ�");
		}else{
			errors.remove("password");
		}
		//ȷ�����벻��Ϊ�գ���Ҫ������һ��
		if(this.password2 == null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "ȷ�����벻��Ϊ�գ�");
		}else if(!this.password.trim().equals(this.password2.trim())){
			isOK = false;
			errors.put("password2", "ȷ������͵�¼����Ҫһ�£�");
		}else{
			errors.remove("password2");
		}
		//�ж��Ƿ�ѡ��ע��Э��
		if(this.ifagree == null){
			isOK = false;
			errors.put("ifagree", "��δ��ѡ���������Ķ���ȷ�Ϲ�ѡ��");
		}else{
			errors.remove("ifagree");
		}
		
		return isOK;
	}
}
