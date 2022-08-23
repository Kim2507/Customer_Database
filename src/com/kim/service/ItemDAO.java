package com.kim.service;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.kim.Item;
import com.kim.ItemDAOI;
import com.kim.*;




public class ItemDAO extends ConnectionDAO implements ItemDAOI{
	private Item item;
	
	public ItemDAO() {
		item = new Item();
	}
	@SuppressWarnings("finally")
	@Override
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<Item>();
		
		try {
			this.connectToDB();
			ps = conn.prepareStatement(SQLQuery.GET_ALL_ITEMS.getQuery());
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				items.add(new Item(rs.getInt("id"),rs.getString("name"),rs.getDouble("price")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			this.closeConnections();
			return items;
		}
		//return null;
	}

	@Override
	public void addItem(int id, String name, double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(int id) {
		// TODO Auto-generated method stub
		
	}

}
