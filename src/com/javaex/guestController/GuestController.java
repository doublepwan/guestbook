package com.javaex.guestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.guestDAO.GuestBookDAO;
import com.javaex.guestVO.GuestBookVO;

@WebServlet("/gc")
public class GuestController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("어서와");
		String actionName = request.getParameter("a");
		request.setCharacterEncoding("UTF-8");

		if ("form".equals(actionName)) {
			System.out.println("form 들어옴");
			RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
			rd.forward(request, response);
		}

		else if ("insert".equals(actionName)) {
			System.out.println("insert 들어옴");
			GuestBookVO vo = new GuestBookVO();
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			vo.setName(name);
			
			vo.setPassword(password);
			
			vo.setContent(content);
			

			System.out.println(vo.toString());

			GuestBookDAO dao = new GuestBookDAO();
			dao.insert(vo);

			response.sendRedirect("gc?a=list");

		}

		else if ("list".equals(actionName)) {
			System.out.println("list 들어옴");
			GuestBookDAO dao = new GuestBookDAO();
			List<GuestBookVO> list = dao.getList();

			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);

		}

		else if ("deleteform".equals(actionName)) {
			System.out.println("deleteform 들어옴");
			RequestDispatcher rd = request.getRequestDispatcher("deleteform.jsp");
			rd.forward(request, response);
		} else if ("delete".equals(actionName)) {
			System.out.println("delete 들어옴");
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			GuestBookDAO dao = new GuestBookDAO();
			dao.delete(no, password);
			response.sendRedirect("gc?a=list");
		}

		else
			System.out.println("바보");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
