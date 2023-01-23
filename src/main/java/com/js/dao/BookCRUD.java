package com.js.dao;//data accessing object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Book;

public class BookCRUD {
	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String address = "jdbc:mysql://localhost:3306/servletbook_store?user=root&password=root";
	static Connection c;

	public int insertBook(Book b) {

		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("insert into book values(?,?,?,?,?)");
			ps.setInt(1, b.getBook_id());
			ps.setString(2, b.getBook_name());
			ps.setString(3,b.getAuthor_name());
			ps.setInt(4, b.getNo_of_pages());
			ps.setDouble(5,b.getPrice());
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

	public int deleteBookId(int id) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("delete from book where id=?");
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	
	}
	public int UpdateBookId(int id , Book b) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("update book set book_name=?,author_name=?,no_of_pages=?,price=? where id=?");
			ps.setString(1, b.getBook_name());
			ps.setString(2, b.getAuthor_name());
			ps.setInt(3, b.getNo_of_pages());
			ps.setDouble(4, b.getPrice());
			ps.setInt(5, id);
			
		     return ps.executeUpdate();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
				
			} catch (Exception e2) {
              e2.printStackTrace();				
			}
		}
		return 0;
	}
	public Book getBookById(int id) {
		Book b = null;
		try {
			Class.forName(path);
			Connection c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("select * from book where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				b = new Book();
				b.setBook_id(rs.getInt(1));
				b.setBook_name(rs.getString(2));
				b.setAuthor_name(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setNo_of_pages(rs.getInt(5));
				return b;
			}else
			{
				return b;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return b;
	}
	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> al = new ArrayList<Book>();
		try {
			Class.forName(path);
			 c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("select * from book");
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Book b = new Book();
				b.setBook_id(rs.getInt(1));
				b.setBook_name(rs.getString(2));
				b.setAuthor_name(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setNo_of_pages(rs.getInt(5));
				al.add(b);
			}
			return al;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	public boolean  batchExecution(ArrayList<Book> books)
	{
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("insert into book values(?,?,?,?,?)");
			for(Book  b : books)
			{
				ps.setInt(1, b.getBook_id());
				ps.setString(2, b.getBook_name());
				ps.setString(3, b.getAuthor_name());
				ps.setInt(4, b.getNo_of_pages());
				ps.setDouble(5, b.getPrice());
				ps.addBatch();
				
			}
			ps.executeBatch();
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
				} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
}


