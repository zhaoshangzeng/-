package cn.fruit.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fruit.domain.User;
import cn.fruit.exception.UserExistException;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;
import cn.fruit.utils.WebUtils;
import cn.fruit.web.formbean.RegisterForm;

/**
 * ����ע������
 * @author zzshang
 *
 */
public class RegisterDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//1.У���ύ�����ݣ�ʹ��formbean���������ݴ浽formbean�����У�����formbean�����У�鷽��
		RegisterForm Rform = WebUtils.request2Bean(request, RegisterForm.class);
		boolean Rb = Rform.validate();
		
		//2.���У��ʧ�ܣ���ص���ҳ�棬����У��ʧ����Ϣ��ͨ��span��ǩ��
		if(!Rb){
			request.setAttribute("Rform", Rform);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
		}
		
		//3.���У��ɹ�������ע��
		User user = new User();
		WebUtils.copyBean(user, Rform); //��FormBean������ֵ ת�� UserBean��
		user.setId(WebUtils.generateID()); //����ȫ��Ψһ��id
		UserService us = new UserServiceImpl();
		try {
			us.register(user);	//����ע�ᣨע����̷���phone�Ѵ��������쳣��
			
			//6.���ע��ɹ�������ת���ɹ���ʾҳ��
			//���û����浽session����ʾ���û������߳ɹ���½
			HttpSession session = request.getSession();
			String id = session.getId();
			Cookie cookie = new Cookie("JSESSIONID", id);
			cookie.setMaxAge(30 * 60);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			session.setAttribute("username", request.getParameter("username"));
			//����ҳ������ͨ�û�
			session.setAttribute("ishy", "no");
			//��ת���ɹ�ҳ��
			String url = response.encodeURL(request.getContextPath() + "/RegisterCG");
			response.sendRedirect(url);
			return;
		} catch (UserExistException e) {
			//4.���ע�᲻�ɹ���������ɹ�ԭ�����Ѵ��ڣ���ص���ҳ�棬����ԭ��
			Rform.getErrors().put("phone", "���ֻ������Ѵ��ڣ�");
			request.setAttribute("Rform", Rform);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch (Exception e2){
			//5.���ע�᲻�ɹ���������ɹ�ԭ�����������⣬����ת��ȫ���쳣ҳ��
			//����ϵͳ�쳣�浽��־��
			//����Ϊ�˿����쳣�����ȴ�ӡ����
			e2.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
