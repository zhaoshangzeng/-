package cn.fruit.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fruit.DB.Data;
import cn.fruit.domain.Fruit;

/**
 * ����ˮ��id���������޸ĸ�ˮ�����������Ӷ�ʹ�۸�ı�
 * @author zzshang
 *
 */
public class ChangeFruitNum extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//��ˮ�����ܼ�
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		if(id != null && num != null){
			Fruit fruit = Data.getAll().get(id);
			fruit.jssumprice();
			System.out.println(fruit);
			System.out.println(fruit.getName()+num);
			fruit.setAmount(Integer.parseInt(num));
		}
		
		//�ص�����ҳ
		String url = response.encodeURL(request.getContextPath() + "/Xq?id=" + id);
		response.sendRedirect(url);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
