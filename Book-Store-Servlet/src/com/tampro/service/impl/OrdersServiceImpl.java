package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.OrderDao;
import com.tampro.dao.impl.OrderDaoImpl;
import com.tampro.model.Orders;
import com.tampro.service.OrdersService;

public class OrdersServiceImpl  implements OrdersService{
	OrderDao orderDao = new OrderDaoImpl();

	@Override
	public boolean add(Orders orders) {
		// TODO Auto-generated method stub
		return orderDao.add(orders);
	}

	@Override
	public boolean update(Orders orders) {
		// TODO Auto-generated method stub
		return orderDao.update(orders);
	}

	@Override
	public boolean delete(Orders orders) {
		// TODO Auto-generated method stub
		return orderDao.delete(orders);
	}

	@Override
	public List<Orders> getAllOrder() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrder();
	}

	@Override
	public Orders getOrdersById(int id) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersById(id);
	}

	@Override
	public int addOrder(Orders orders) {
		// TODO Auto-generated method stub
		return orderDao.addOrder(orders);
	}

	@Override
	public List<Orders> getAllOrder(int start, int end) {
		// TODO Auto-generated method stub
		return orderDao.getAllOrder(start, end);
	}
	

}
