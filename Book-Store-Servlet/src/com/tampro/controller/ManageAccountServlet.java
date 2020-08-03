package com.tampro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Books;
import com.tampro.model.Users;
import com.tampro.service.UserService;
import com.tampro.service.impl.UserServiceImpl;
import com.tampro.utils.PathRequest;

/**
 * Servlet implementation class ManageAccountServlet
 */
@WebServlet(PathRequest.ACCOUNT_ADMIN)
public class ManageAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		UserService userService = new UserServiceImpl();
       private static final int LIMIT = 10;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		int pageCurrent = 1;
		if(request.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;						
		List<Users> listUserPagi = userService.getAllUsers(start,end);
		List<Users> listUser = userService.getAllUsers();
		request.setAttribute("listBook", listUserPagi);
		request.setAttribute("pageCurrent", pageCurrent);
		int soPage = 0;
		if(listUser.size() % LIMIT == 0) {
			soPage = listUser.size() / LIMIT;
		}else {
			soPage = (listUser.size() / LIMIT)+1;
		}
		
		request.setAttribute("listUser", listUserPagi);
		request.setAttribute("soPage", soPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/account.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
