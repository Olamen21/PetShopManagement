package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Category;
import entity.Customer;
import entity.Pet;
import entity.User;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
//	Customer
	public List<Customer> getAllCustomer(){
		List<Customer> list = new ArrayList<>();
		String query = "select * from CustomerTbl";
		try {
			conn = new DBContext().getConnection(); //mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			
		}
		
		return list;
	}

	public void deleteCustomer(String id) {
		String query = "delete from CustomerTbl where CustId=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertCustomer(String name, String address, String phone) {
		String query = "insert into CustomerTbl values(?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Customer getCustomerById(String id) {
		String query = " select * from CustomerTbl where CustId = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void updateCustomer(String id, String name, String address, String phone) {
		String query = "update CustomerTbl set CustName = ?, CustAdd = ?, CustPhone = ? where CustId=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setString(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Customer> findCustomer(String find) {
		List<Customer> list = new ArrayList<>();
		String query = "select * from CustomerTbl where CustName like '%"+find+"%' or CustAdd like '%"+
		find+"%' or CustPhone like '%"+find+"%'";
		try {
			conn = new DBContext().getConnection(); //mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	//User
	public List<User> getAllUser(){
		List<User> list = new ArrayList<>();
		String query = "select * from UserTbl";
		try {
			conn = new DBContext().getConnection(); //mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			
		}
		
		return list;
	}
	
	public void deleteUser(String id) {
		String query = "delete from UserTbl where UId=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertUser(String name, String password) {
		String query = "insert into UserTbl values(?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public User getUserById(String id) {
		String query = " select * from UserTbl where UId = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return (new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void updateUser(String id, String name, String password) {
		String query = "update UserTbl set UName = ?, UPass = ? where UId=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<User> findUser(String find) {
		List<User> list = new ArrayList<>();
		String query = "select * from UserTbl where UName like '%"+find+"%'";
		try {
			conn = new DBContext().getConnection(); //mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	//Category
	public List<Category> getAllCategory(){
		List<Category> list = new ArrayList<>();
		String query = "select * from CategoryTbl";
		try {
			conn = new DBContext().getConnection(); //mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			
		}
		
		return list;
	}
	
	public void deleteCategory(String id) {
		String query = "delete from CategoryTbl where CatId=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertCat(String name) {
		String query = "insert into CategoryTbl values(?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Category getCatById(String id) {
		String query = " select * from CategoryTbl where CatId = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return (new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void updateCat(String id, String name) {
		String query = "update CategoryTbl set CatDes = ? where CatId=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<Category> findCategory(String find) {
		List<Category> list = new ArrayList<>();
		String query = "select * from CategoryTbl where CatDes like '%"+find+"%'";
		try {
			conn = new DBContext().getConnection(); //mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
//	Pet
	public List<Pet> getAllPet(){
		List<Pet> list = new ArrayList<>();
		String query = "select * from PetTbl";
		try {
			conn = new DBContext().getConnection(); //mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Pet(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			
		}
		
		return list;
	}
	
	public void deletePet(String id) {
		String query = "delete from PetTbl where PId=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertPet(String name, String cat, String price) {
		String query = "insert into PetTbl values(?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, cat);
		
			ps.setString(3, price);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Pet getPetById(String id) {
		String query = " select * from PetTbl where PId = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return (new Pet(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void updatePet(String id, String name, String cat, String price) {
		String query = "update PetTbl set PName = ?, PCat = ?, Pprice = ? where PId=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, cat);
			
			ps.setString(3, price);
			ps.setString(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Pet> findPet(String find) {
		List<Pet> list = new ArrayList<>();
		String query = "select * from PetTbl where PName like '%"+find+"%'";
		try {
			conn = new DBContext().getConnection(); //mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Pet(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public User checkLogin(String user, String pass) {
		
		try {
			String query = "select * from UserTbl where UName = ? and UPass = ?";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
				return u;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	

	
	
	
	
}
