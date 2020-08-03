package com.tampro.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tampro.model.Address;
import com.tampro.model.Users;
import com.tampro.service.AddressService;
import com.tampro.service.impl.AddressServiceImpl;

@WebServlet("/admin/api/address")
public class AddressAPI extends HttpServlet {
	AddressService addressService = new AddressServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		
		int addressId = Integer.parseInt(req.getParameter("address"));
		int userId = Integer.parseInt(req.getParameter("user"));
		Address address = addressService.getAddressByIdAddressAndidUser(addressId, userId);
		PrintWriter writer = response.getWriter();
		
		Gson gson = new Gson();
		
		writer.print(gson.toJson(address));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
