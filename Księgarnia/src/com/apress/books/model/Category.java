package com.apress.books.model;

public class Category {
private long id;
private String categoryDescription;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCategoryDescription() {
	return categoryDescription;
}
public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}

public String toString() {
	return "Kategoria - Identyfikator: "+ id+", Opis kategorii: "+ categoryDescription;
	
}



}
