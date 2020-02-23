package com.apress.books.model;

import java.util.List;
import com.apress.books.model.Author;

public class Book {
	private long id;
	private long categoryId;
	private String bookTitle;
	private List<Author> authors;
	private String publisherName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String toString() {
		return "Ksi¹¿ka - Identyfikator: " +id+ ", Tytu³ Ksi¹¿ki: " + bookTitle;
		
	}
}
