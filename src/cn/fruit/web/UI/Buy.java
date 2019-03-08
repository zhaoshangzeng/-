package cn.fruit.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���빺��ҳ��
 * @author zzshang
 *
 */
public class Buy extends HttpServlet {

	/**
	 * �������ϴ��Ͷ�����ֽ����У�64λ����
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
		response.setContentType("text/html;charset=utf-8");
		//������������û���һ�η��ʣ�ͨ��urlֱ�ӵ�¼��ҳ�棬��û�е�¼��ҳ�������û��ص���ҳ
		//�����û������ȷ�����ҳ��һ������Ϣ����ҳ�����ǳ�ʼ������Ҳ����ҳ
		String referer = request.getHeader("referer");
		if(referer==null){
			response.sendRedirect("/wyufruit");  //���û�������ַ�ı䣬�����û�����ֱ�ӽ���
			return;
		}
		//��ת��buy.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/buy.jsp").forward(request, response);
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
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
