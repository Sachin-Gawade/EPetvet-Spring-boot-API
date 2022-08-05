package com.to.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.to.entities.Orders;
import com.to.services.OrdersService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users/orders")
public class UserOrdersResource {
	
	@Autowired
	OrdersService ordersService;
	
	//end point for saving all products in order details 
	@PostMapping("/saveAllOrders")
	public List<Orders> saveAllOrders(HttpServletRequest request,@RequestBody List<Orders> orders){
		
		return ordersService.saveOrders(orders);
	}
	
	//end point for saving the single product in order details
	@PostMapping("/saveOrder")
	public Orders saveOrder(@RequestBody Orders order) {
		return ordersService.saveOrder(order);
	}

	//getting the current user's order details
	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders(HttpServletRequest request){
		int currentUserId=(Integer)request.getAttribute("userId");
		return ordersService.getCurrentUsersOrders(currentUserId);
	}
	
	
}
