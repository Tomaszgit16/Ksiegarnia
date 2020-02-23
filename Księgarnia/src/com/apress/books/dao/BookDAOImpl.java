package com.apress.books.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apress.books.model.Author;
import com.apress.books.model.Book;
import com.apress.books.model.Category;

// Uwaga w ksi¹¿ce Brak Insert Update Delete

public class BookDAOImpl implements BookDAO {

	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException ex){}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ksi¹¿ki?serverTimezone=CET", "root", "admin");
		
	}
		
	private void closeConnection(Connection connection) {
		
		if (connection == null)
			return;
		try {
			connection.close();
		}catch (SQLException ex) {		
		}		
	}
		
	
	public List<Book>findAllBooks() {
		List<Book> result = new ArrayList<>();
		List<Author> authorList = new ArrayList<>();
		
		String sql = "select * from ksi¹¿ka inner join autor on ksi¹¿ka.id = autor.id_ksi¹¿ki";
		
		Connection connection = null;	
	
	try {
		connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Book book = new Book();
			Author author = new Author();
			book.setId(resultSet.getLong("id"));
			book.setBookTitle(resultSet.getString("tytu³_ksi¹¿ki"));
			book.setCategoryId(resultSet.getLong("ID_KATEGORII"));
			author.setBookId(resultSet.getLong("ID_KSI¥¯KI"));
			author.setFirstName(resultSet.getString("imiê"));
			author.setLastName(resultSet.getString("nazwisko"));
			authorList.add(author);
			book.setAuthors(authorList);
			book.setPublisherName(resultSet.getString("wydawca"));
			result.add(book);		
		}	
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		closeConnection(connection);
	}
	return result;

	}
	
	
	
	public List<Book>searchBooksByKeyWord(String keyWord)  {
		List<Book> result = new ArrayList<>();
		List<Author> authorList = new ArrayList<>();
		
		String sql = "select * from ksi¹¿ka inner join autor on ksi¹¿ka.id = autor.id_ksi¹¿ki"
				+ " where tytu³_ksi¹¿ki like '%"
				+ keyWord.trim()
				+ "%'"
				+ " or imiê like '%"
				+ keyWord.trim()
				+ "%'"
				+ " or nazwisko like '%" + keyWord.trim() + "%'";
		
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				Author author = new Author();
				
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("tytu³_ksi¹¿ki"));
				book.setPublisherName(resultSet.getString("wydawca"));
				
				author.setFirstName(resultSet.getString("imiê"));
				author.setLastName(resultSet.getString("nazwisko"));
				author.setBookId(resultSet.getLong("ID_KSI¥¯KI"));
				authorList.add(author);
				book.setAuthors(authorList);
				result.add(book);		
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;

		}
		
	
	public List<Category> findAllCategories() {
		List<Category> result = new ArrayList<>();
		String sql = "select * from category";
		
		Connection connection = null;
	
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				
				category.setId(resultSet.getLong("id"));
				category.setCategoryDescription(resultSet.getString("opis_kategorii"));
				result.add(category);
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;

		}
		
	
	public void insert(Book book) {
	}
	
	public void update(Book book) {
	}
	
	public void delete(Book book) {
	}

	
	}
	
	
	
	
	
	
	
	
	
	
	

