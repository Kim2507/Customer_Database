package com.kim.app;

import java.util.ArrayList;
import java.util.List;

import com.kim.Item;
import com.kim.service.CustomerDAO;
import com.kim.service.ItemDAO;

public class Customer_Item {

	public static void main(String[] args) {
		CustomerDAO cdao = new CustomerDAO();
		cdao.getCustomerById(1);
		
		ItemDAO idao = new ItemDAO();
		List<Item> items = new ArrayList<Item>();
		items = idao.getAllItems();
		System.out.println(items.toString());

	}

}
