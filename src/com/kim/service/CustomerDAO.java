package com.kim.service;

import java.sql.SQLException;

import com.kim.ConnectionDAO;
import com.kim.Customer;
import com.kim.CustomerDAOI;




public class CustomerDAO extends ConnectionDAO implements CustomerDAOI {
	private Customer cust;
	
	public CustomerDAO() {
		this.cust = new Customer();
	}
	
	
	@SuppressWarnings("finally")
	@Override
	public Customer getCustomerById(int cusID) {
		try {
			this.connectToDB();
			ps = conn.prepareStatement(SQLQuery.GET_CUSTOMER_BY_ID.getQuery());
			ps.setInt(1, cusID);
			rs = ps.executeQuery();
			while(rs.next()) {
				cust.setId(rs.getInt(1));
				cust.setEmail(rs.getString(2));
				cust.setFname(rs.getString(3));
				cust.setLname(rs.getString(4));
				System.out.println("Customer id: " + cust.getId()+"\nEmail: " +
				cust.getEmail()+ "\nFirst name: "+ cust.getFname()+ "\nLast name: "+ cust.getLname()); 
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			this.closeConnections();
			return cust;
		}
		
	}

	@Override
	public void addCustomer(int id, String email, String fname, String lname) {
		this.addCustomer(id, email, fname, lname);
		try {
			this.connectToDB();
			ps = conn.prepareStatement(SQLQuery.ADD_CUSTOMER.getQuery());
			int affectedRow = ps.executeUpdate();
			System.out.println(affectedRow);
			//rs = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			this.closeConnections();
		}	
	}

	@Override
	public void removeCustomer(int id) {
		try {
			this.connectToDB();
			ps = conn.prepareStatement(SQLQuery.REMOVE_CUSTOMER_BY_ID.getQuery());
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {
				cust.setId(rs.getInt(1));
				cust.setEmail(rs.getString(2));
				cust.setFname(rs.getString(3));
				cust.setLname(rs.getString(4));
				System.out.println("Customer id: " + cust.getId()+"\nEmail: " +
				cust.getEmail()+ "\nFirst name: "+ cust.getFname()+ "\nLast name: "+ cust.getLname()); 
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			this.closeConnections();
			//return cust;
		}
		
	}

}
