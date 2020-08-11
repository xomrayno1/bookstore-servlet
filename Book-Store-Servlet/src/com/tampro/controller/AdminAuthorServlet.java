package com.tampro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Authors;
import com.tampro.service.AuthorService;
import com.tampro.service.impl.AuthorServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADMIN_AUTHOR)
public class AdminAuthorServlet  extends HttpServlet{

	AuthorService authorService = new AuthorServiceImpl();
	private static final int LIMIT = 6;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pageCurrent = 1;
		if(request.getParameter("page")!=null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start =  (pageCurrent - 1) * LIMIT ;
		int end  =	 pageCurrent * LIMIT ;
		
		List<Authors> listAuthor = authorService.getAllAuthors();
		List<Authors> listAuthorPagi = authorService.getAllAuthorsPagi(start, end);
		int totalPage = 0 ;
		if(listAuthor != null) {
			if(listAuthor.size() % LIMIT  != 0 ) {
			 totalPage  =	listAuthor.size() / LIMIT  + 1;
			}else {
				totalPage = listAuthor.size() / LIMIT;
			}
		}
		request.setAttribute("listAuthorPagi", listAuthorPagi);
		request.setAttribute("soPage", totalPage);
		request.setAttribute("pageCurrent", pageCurrent);
		request.getRequestDispatcher("/giaodien/admin/author.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}
