package cn.fruit.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCG extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//������������û���һ�η��ʣ�ͨ��urlֱ�ӵ�¼��ҳ�棬��û�е�¼��ҳ�������û��ص���ҳ
		//�����û������ȷ�����ҳ��һ������Ϣ����ҳ�����ǳ�ʼ������Ҳ����ҳ
		String referer = request.getHeader("referer");
		if(referer==null){
			response.sendRedirect(request.getContextPath());  //���û�������ַ�ı䣬�����û�����ֱ�ӽ���
			return;
		}
		//��ת��Register.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/loginCG.jsp").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
