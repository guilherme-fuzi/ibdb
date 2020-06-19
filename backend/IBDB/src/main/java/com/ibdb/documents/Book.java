package com.ibdb.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
public class Book {
	
	@Id
	private String id;
	private String title;
	private List<String> author;
	private List<String> gender;
	private List<String> comments;
	private List<Integer> ratings;
	
	public Book(String title, String author, String gender, String comments, Integer rating) {
		this.title = title;
		this.author.add(author);
		this.gender.add(gender);
		this.comments.add(comments);
		this.ratings.add(rating);
	}
	
	public Book() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}
	public List<String> getGender() {
		return gender;
	}
	public void setGender(List<String> gender) {
		this.gender = gender;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public List<Integer> getRating() {
		return ratings;
	}
	public void setRating(List<Integer> rating) {
		this.ratings = rating;
	}

}
