package com.project1.jobportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project1.jobportal.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
