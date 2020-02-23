package com.apress.books.client;
import java.util.List;


import com.apress.books.dao.BookDAO;
import com.apress.books.dao.BookDAOImpl;
import com.apress.books.model.Book;



public class BookApp {
	private static BookDAO bookDao = new BookDAOImpl();
	
	
	public static void main(String[] args) {
		
		// Show list of all books 
		System.err.println("List of all books: ");
		findAllBooks();
		System.out.println();
		
		//Seach books by keyword
		System.out.println("Search books with keyword 'Groovy' in title: ");
		
		searchBooks("Groovy");
		System.out.println();
		
		System.err.println("Searching books with keyword 'Josh' for author name: ");
		searchBooks("Josh");
		
	}

	private static void findAllBooks() {
		List<Book> books = bookDao.findAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	private static void searchBooks(String keyWord) {
		List<Book> books = bookDao.searchBooksByKeyWord(keyWord);
		for (Book book : books) {
			System.out.println(book);
		}
	}	
}
