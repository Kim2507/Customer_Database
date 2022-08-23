package com.kim;



public interface CustomerDAOI {
	enum SQLQuery{
		GET_CUSTOMER_BY_ID("Select * from customer where id = ?"),
		ADD_CUSTOMER("INSERT into customer VALUES ?,?,?,?"),
		REMOVE_CUSTOMER_BY_ID("DELETE FROM customer WHERE id =?");
		private final String query;
		
		//Enum constructor
		private SQLQuery(String query) {
			this.query = query;
		}
		
		public String getQuery() {
			return query;
		}
	}
	
	
	public Customer getCustomerById(int empNum);
	public void addCustomer(int id, String email, String fname, String lname);
	public void removeCustomer(int id);
	

}
