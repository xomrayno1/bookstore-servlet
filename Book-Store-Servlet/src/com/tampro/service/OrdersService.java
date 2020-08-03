package com.tampro.service;

import java.util.List;

import com.tampro.model.Orders;

public interface OrdersService {
	
	boolean add(Orders orders);
	boolean update(Orders orders);
	
	boolean delete(Orders orders);
	List<Orders> getAllOrder(); 
	Orders getOrdersById(int id);
	int addOrder(Orders orders);
	public List<Orders> getAllOrder(int start, int end);

}
