package cn.fruit.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fruit.domain.Fruit;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;

/**
 * ����ɶ���
 * @author zzshang
 *
 */
public class OrderDeal extends HttpServlet {

	/**
	 * ���л�У����
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
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //����post��ʽ���ύ��a��ǩ�ύ�����Ĳ�������
		response.setContentType("text/html;charset=utf-8"); //���ڿ�����������룬�������getWriter()����
		//�����ﳵ�б�תΪ�����б�
		HttpSession session = request.getSession();
		List<Fruit> listcart = (List<Fruit>) session.getAttribute("listcart");
		List<Fruit> listorder = null;
		if(listcart != null){
			listorder = new ArrayList<Fruit>(listcart);
			listcart.clear();	//��չ��ﳵ
			session.setAttribute("listorder", listorder);
		}
		if(listorder != null){
			double orderSum = 0.0;
			for(Fruit f : listorder){
				orderSum += f.getTotalPrice();
			}
			orderSum = (double) Math.round(orderSum * 100) / 100;
			session.setAttribute("orderSum", orderSum);
		}
		//����ǻ�Ա�������Ӵ���
		String username = (String) session.getAttribute("username");
		UserService us = new UserServiceImpl();
		if(us.ifHy(username)){
			Object o = session.getAttribute("orderSum");
			if(o != null){
				double orderSum2 =  (Double) o;
				double hyPrice = orderSum2 * 0.9;
				hyPrice = (double) Math.round(hyPrice * 100) / 100;	//ֻȡ����λ 
				session.setAttribute("hyPrice", hyPrice);
			}
		}else{  //������ǻ�Ա�����ϴεļ�¼���
			Object o2 = session.getAttribute("hyPrice");
			if(o2 != null){
				session.removeAttribute("hyPrice");
			}
		}
		//������ҳ��
		String url = response.encodeURL(request.getContextPath() + "/Order");
		response.sendRedirect(url);
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
