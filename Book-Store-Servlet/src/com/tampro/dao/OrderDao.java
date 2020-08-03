package com.tampro.dao;

import java.util.List;

import com.tampro.model.Orders;

public interface OrderDao {
	
	boolean add(Orders orders);
	boolean update(Orders orders);
	boolean delete(Orders orders);
	List<Orders> getAllOrder(); 
	List<Orders> getAllOrder(int start,int end); 
	Orders getOrdersById(int id);
	int addOrder(Orders orders);
}
