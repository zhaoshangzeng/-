package cn.fruit.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fruit.DB.Data;
import cn.fruit.domain.Fruit;

public class DeleteListCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//ɾ��listcart�����е�fruit
		String delbuyid = request.getParameter("delbuyid");
		@SuppressWarnings("unchecked")
		List<Fruit> listcart = (List<Fruit>) request.getSession().getAttribute("listcart");
		if(listcart != null){
			listcart.remove(Data.getAll().get(delbuyid));
		}
		//�ص����ﳵ
		String url = response.encodeURL(request.getContextPath() + "/ListCart");
		response.sendRedirect(url);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
