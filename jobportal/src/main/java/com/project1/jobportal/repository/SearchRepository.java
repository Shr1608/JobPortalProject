package com.project1.jobportal.repository;

import java.util.List;

import com.project1.jobportal.model.Post;

public interface SearchRepository {
	public List<Post> findByText(String text);
}
