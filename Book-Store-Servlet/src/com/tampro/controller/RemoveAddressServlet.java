package com.tampro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.service.AddressService;
import com.tampro.service.impl.AddressServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADDRESS_REMOVE)
public class RemoveAddressServlet extends HttpServlet {
	
	/**
	 * 
	 */
	AddressService addressService = new AddressServiceImpl();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		addressService.deleteAddress(id);
		
		response.sendRedirect(request.getContextPath() + PathRequest.ADDRESS_USER);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		addressService.deleteAddress(id);	
		response.sendRedirect(request.getContextPath() + PathRequest.SHIPPING);
	}
	

}
