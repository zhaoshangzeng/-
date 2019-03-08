package cn.fruit.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;

/**
 * �����Ա
 * @author zzshang
 *
 */
public class Buyhy extends HttpServlet {

	/**
	 * ���л�У��
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����˵����get����
	 * ����Ŀ�꣺��������ʽΪget����
	 * ����ʹ�ã���ַ������a��ǩ�����form����get����
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //����post��ʽ���ύ��a��ǩ�ύ�����Ĳ�������
		response.setContentType("text/html;charset=utf-8"); //���ڿ�����������룬�������getWriter()����
		//������������û���һ�η��ʣ�ͨ��urlֱ�ӵ�¼��ҳ�棬��û�е�¼��ҳ�������û��ص���ҳ
		//�����û������ȷ�����ҳ��һ������Ϣ����ҳ�����ǳ�ʼ������Ҳ����ҳ
		String referer = request.getHeader("referer");
		if(referer==null){
			response.sendRedirect("/wyufruit");  //���û�������ַ�ı䣬�����û�����ֱ�ӽ���
			return;
		}
		
		HttpSession session = request.getSession();
		UserService us = new UserServiceImpl();
		us.setHy((String)session.getAttribute("username"));	//����Ϊ��Ա
		session.setAttribute("ishy", "yes"); //��������ҳ���ǻ�Ա
		//��ת��buy.jsp
		request.setAttribute("message", "���Ѿ��ɹ������Ա��ģ�⣩��");
		request.getRequestDispatcher("/WEB-INF/jsp/buyhy.jsp").forward(request, response);
		return;
	}

	/**
	 * ����˵����post����
	 * ����Ŀ�꣺��������ʽΪpost����
	 * ����ʹ�ã�form����post����
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
