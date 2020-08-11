package com.tampro.dao;

import java.util.List;

import com.tampro.model.Authors;

public interface AuthorDao {
	
	Authors getAuthorsById(int id);
	List<Authors> getAllAuthors();
	List<Authors> getAllAuthorsPagi(int start , int end);
	boolean deleteAuthorsById(int id);
	boolean updateAuthors(Authors authors);
	boolean addAuthors(Authors authors);

}
