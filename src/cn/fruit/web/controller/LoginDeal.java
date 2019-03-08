package cn.fruit.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fruit.domain.User;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;

/**
 * �����¼����
 * @author zzshang
 *
 */
public class LoginDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.���е�½
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		UserService us = new UserServiceImpl();
		User user = us.login(phone, password);
		
		//2.��½ʧ�������ʧ����Ϣ
		if(user == null){
			request.setAttribute("loginErrors", "�ֻ�����������������������룡");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
		
		//3.��½�ɹ�����ת���ɹ���ʾҳ��
		//���û����浽session����ʾ���û������߳ɹ���½
		HttpSession session = request.getSession();
		String id = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setMaxAge(30 * 60);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		session.setAttribute("username", user.getUsername());
		
		//4.ͬʱ����Ա��Ϣ�浽session
		if(us.ifHy(user.getUsername())){
			session.setAttribute("ishy", "yes");
		}else{
			session.setAttribute("ishy", "no");
		}
		//��ת���ɹ�ҳ��
		String url = response.encodeURL(request.getContextPath() + "/LoginCG");
		response.sendRedirect(url);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
