package com.kim;

import java.util.List;

public interface ItemDAOI {
	enum SQLQuery{
	GET_ALL_ITEMS("SELECT * FROM item"),
	ADD_ITEM_BY_ID("INSERT into item VALUES ?,?,?"),
	REMOVE_ITEM("DELETE FROM ITEM WHERE id =?");
		
		
		private final String query;
		
		//Enum constructor
		private SQLQuery(String query) {
			this.query = query;
		}
		
		public String getQuery() {
			return query;
		}
	}
	
	public List<Item> getAllItems();
	public void addItem(int id, String name,double price);
	public void removeItem(int id);

	
}
